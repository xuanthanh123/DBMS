package com.example.izuna.baitapketnoi.subject_by_student;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.izuna.baitapketnoi.DBHelper.ConnectClass;
import com.example.izuna.baitapketnoi.R;
import com.example.izuna.baitapketnoi.models.SubjectByStudent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanh on 08/05/2017.
 */

public class SubjectByStudentActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private SubjectByStudentAdapter subjectByStudentAdapter;
    private List<SubjectByStudent> subjectByStudents = new ArrayList<>();
    private RecyclerView mRecycler;
    private ConnectClass connectClass;
    private String mssv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_by_student);
        //khởi tạo components
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecycler = (RecyclerView) findViewById(R.id.recycler_subject_by_student);
        //cấu hình toolbar
        setSupportActionBar(toolbar);
        //hiển thị icon back
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danh sách môn học");
        //init
        connectClass = new ConnectClass(this);
        //get intent dc truyền qua từ StudentAdapter, khi ta click vào button bên StudentAdapter
        mssv = getIntent().getStringExtra("MSSV");
        try {
            //gọi hàm lấy toàn bộ môn học của sv đó
            subjectByStudents = connectClass.getALlSubjectByStudent(connectClass.conn(), mssv);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        subjectByStudentAdapter = new SubjectByStudentAdapter(this, subjectByStudents);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(subjectByStudentAdapter);
        subjectByStudentAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
