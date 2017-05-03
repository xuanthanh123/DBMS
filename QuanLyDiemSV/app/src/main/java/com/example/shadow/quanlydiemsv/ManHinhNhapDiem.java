package com.example.shadow.quanlydiemsv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;

public class ManHinhNhapDiem extends AppCompatActivity implements Serializable {


    Button btnSearchSV;
    EditText txtSearchMSSV;
    ArrayList<SinhVien> listSV;
    DatabaseReference mData;
    String mssv;
    Bundle bundle;
    ArrayList<MonHoc> listMonHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_man_hinh_nhap_diem);
        btnSearchSV = (Button) findViewById(R.id.btnSearch);
        txtSearchMSSV = (EditText) findViewById(R.id.edtTimKiemSV);
        mData = FirebaseDatabase.getInstance().getReference();

        listSV = new ArrayList<SinhVien>();
        listMonHoc = new ArrayList<MonHoc>();
        bundle = new Bundle();
        DatabaseChildListenner();




        btnSearchSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mssv = txtSearchMSSV.getText().toString();
                for(int i=0; i<listSV.size();i++)
                {
                    if(listSV.get(i).maSoSinhVien.equalsIgnoreCase(mssv)) {
                        Intent ManHinhTimKiem = new Intent(ManHinhNhapDiem.this, Thong_tin_sinh_vien.class);
                        bundle.putString("MSSV",listSV.get(i).getMaSoSinhVien());
                        bundle.putString("Name",listSV.get(i).getHoTen());
                        bundle.putString("Gender",listSV.get(i).gioiTinh);
                        bundle.putString("Class",listSV.get(i).getLopHoc());
                        ManHinhTimKiem.putExtra("Sinh Viên",bundle );
                        Toast.makeText(ManHinhNhapDiem.this, "Tìm Thấy", Toast.LENGTH_SHORT).show();
                        startActivity(ManHinhTimKiem);
                        return;
                    }
                }
                Toast.makeText(ManHinhNhapDiem.this, "Không tim thấy", Toast.LENGTH_SHORT).show();
            }
        });



    }
    public  void DatabaseChildListenner()
    {
        // Sự kiện database thêm childNode
        mData.child("Sinh Viên").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                SinhVien sv = dataSnapshot.getValue(SinhVien.class);
                listSV.add(sv);
                //Toast.makeText(ManHinhNhapDiem.this,"Load xong SV:"+sv.getMaSoSinhVien(),Toast.LENGTH_SHORT).show();
                //Toast.makeText(ManHinhNhapDiem.this,sv.getMaSoSinhVien(), Toast.LENGTH_SHORT).show();
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
}
