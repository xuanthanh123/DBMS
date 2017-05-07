package com.example.izuna.baitapketnoi.student_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.izuna.baitapketnoi.DBHelper.ConnectClass;
import com.example.izuna.baitapketnoi.R;
import com.example.izuna.baitapketnoi.models.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by buivu on 01/05/2017.
 */

public class StudentFragment extends Fragment {
    private View rootView;
    private StudentAdapter studentAdapter;
    private ConnectClass connectDatabase;
    private RecyclerView mRecycler;
    private List<Student> listStudent = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_subject, container, false);
        mRecycler = (RecyclerView) rootView.findViewById(R.id.recycler_subject);
        connectDatabase = new ConnectClass(getActivity());
        loadData();
        return rootView;
    }

    //hàm lấy dữ liệu, sẽ connect tới database để lấy dữ liệu
    private void loadData() {
        try {
            //thực hiện câu truy vấn
            listStudent = connectDatabase.getAllStudent(connectDatabase.conn());
            studentAdapter = new StudentAdapter(getActivity(), listStudent);
            mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecycler.setAdapter(studentAdapter);
            //notifyDatasetChanged để gọi lại hàm onBIndViewHolder bên Adapter, để reload lại dữ liệu
            studentAdapter.notifyDataSetChanged();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
