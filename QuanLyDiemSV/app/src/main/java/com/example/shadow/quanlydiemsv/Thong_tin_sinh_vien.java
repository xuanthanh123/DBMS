package com.example.shadow.quanlydiemsv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;

import static com.example.shadow.quanlydiemsv.R.id.txtTenSV;

public class Thong_tin_sinh_vien extends AppCompatActivity implements Serializable {

    TextView txtMaSV;
    EditText edtTenSV;
    EditText edtGioiTinh;
    Bundle bundle;
    SinhVien sv;
    ArrayList<DiemSinhVien> listDiemSinhVien;
    ArrayList<MonHoc> listMonHoc;
    DatabaseReference mData;
    ListView lv;
    Adapter_DiemSinhVien adapter;
    DiemSinhVien dsv;
    Button btnNhapDiem,btnCapNhat;
    Bundle bundlee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_sinh_vien);
        //Đọc dữ liệu trên Firebase
        mData = FirebaseDatabase.getInstance().getReference();
        //listMonHoc = new ArrayList<MonHoc>();
        listDiemSinhVien = new ArrayList<DiemSinhVien>();
        //Ánh xạ
       txtMaSV = (TextView) findViewById(R.id.txtMaSV1);
        edtTenSV = (EditText) findViewById(txtTenSV);
        edtGioiTinh = (EditText) findViewById(R.id.txtGT1);
        sv = new SinhVien();
        edtTenSV.setFocusable(false);
        edtGioiTinh.setFocusable(false);
        lv = (ListView) findViewById(R.id.lvDiemSV);
        btnNhapDiem = (Button) findViewById(R.id.btnNhapDiem);
       // btnCapNhat = (Button) findViewById(R.id.btnCapNhat);

        // Khai báo adapter và đẩy điểm sinh viên lên list view
        adapter = new Adapter_DiemSinhVien(
                Thong_tin_sinh_vien.this, R.layout.activity_dong__diem_sv,listDiemSinhVien
        );
        lv.setAdapter(adapter);
        //Lấy dữ liệu từ màn hình tìm kiếm
        Intent intent = getIntent();
        bundle = intent.getBundleExtra("Sinh Viên");
        sv.setMaSoSinhVien( bundle.getString("MSSV"));
        sv.setHoTen(bundle.getString("Name"));
        sv.setGioiTinh(bundle.getString("Gender"));
        sv.setLopHoc(bundle.getString("Class"));
        sv.setListMonHoc(listMonHoc);


        // Gắn dữ liệu lên TextView và Edittext
        txtMaSV.setText(sv.getMaSoSinhVien());
        edtTenSV.setText(sv.getHoTen());
        edtGioiTinh.setText(sv.gioiTinh);


        // Đọc dữ liệu trên fireBase
        docDuLieu();
        btnNhapDiem = (Button) findViewById(R.id.bntNhapDiem);
        NhapDiem_OnClick();
        //CapNhapAction();
    }

   /* public void CapNhapAction()
    {
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtTenSV.setFocusableInTouchMode(true);
                edtGioiTinh.setFocusableInTouchMode(true);
            }
        });
    }*/

    public void docDuLieu()
    {
        mData.child("Điểm Sinh Viên").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DiemSinhVien dsv = dataSnapshot.getValue(DiemSinhVien.class);
                if(dsv.getSv().getMaSoSinhVien().equalsIgnoreCase(sv.getMaSoSinhVien()))
                     listDiemSinhVien.add(dsv);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void NhapDiem_OnClick()
    {
        btnNhapDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ManHinhNhapDiem = new Intent(Thong_tin_sinh_vien.this, MonHoc_2.class);
                bundlee = new Bundle();
                bundlee.putString("MSSV",sv.getMaSoSinhVien());
                bundlee.putString("Name",sv.getHoTen());
                bundlee.putString("Gender",sv.gioiTinh);
                bundlee.putString("Class",sv.getLopHoc());
                ManHinhNhapDiem.putExtra("Sinh Viên",bundlee );
                startActivity(ManHinhNhapDiem);
            }
        });
    }

}
