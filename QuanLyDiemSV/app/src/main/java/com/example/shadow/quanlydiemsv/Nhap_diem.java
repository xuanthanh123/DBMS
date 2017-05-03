package com.example.shadow.quanlydiemsv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Nhap_diem extends AppCompatActivity {

    Button btnLuu;
    EditText edtThuongKi,edtGiuaKi,edtCuoiKi;
    DiemSinhVien dsv;
    Bundle bundle,bundlee;
    DatabaseReference mData;
    SinhVien sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_diem);
        //ánh xạ
        edtThuongKi = (EditText) findViewById(R.id.edtThuongKi);
        edtGiuaKi = (EditText) findViewById(R.id.edtGiuaKi);
        edtCuoiKi = (EditText) findViewById(R.id.edtCuoiKi);
        btnLuu = (Button) findViewById(R.id.btnLuuDiem);
        mData = FirebaseDatabase.getInstance().getReference();
        dsv = new DiemSinhVien();
        sv = new SinhVien();
        bundle = new Bundle();
        bundlee = new Bundle();

        //phương thức
        nhanDiemSinhVien();
        luuDiem();

    }
    public void luuDiem()
    {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtThuongKi.getText().toString().equals("")||edtGiuaKi.getText().toString().equals("")
                        ||edtCuoiKi.getText().toString().equals(""))
                {
                    Toast.makeText(Nhap_diem.this,"Bạn phải nhập đủ 3 cột điểm",Toast.LENGTH_SHORT).show();return;
                }
                int TK = Integer.parseInt(edtThuongKi.getText().toString());
                int GK = Integer.parseInt(edtGiuaKi.getText().toString());
                int CK = Integer.parseInt(edtCuoiKi.getText().toString());
                if(TK >10 || GK > 10 || CK > 10 || TK <0 || GK < 0 || CK < 0)
                {
                    Toast.makeText(Nhap_diem.this,"Điểm trong khoản [0-10]",Toast.LENGTH_SHORT).show();
                    return;
                }
                dsv.setDiemThuongKi(TK);
                dsv.setDiemGiuaKi(GK);
                dsv.setDiemCuoiKi(CK);
                String s = dsv.getSv().getMaSoSinhVien()+dsv.getMonHoc().getMaMon();
                mData.child("Điểm Sinh Viên").child(s).setValue(dsv);
                Toast.makeText(Nhap_diem.this,"Lưu Thành Công",Toast.LENGTH_SHORT).show();
                rollBackNewData();
            }
        });
    }

    public void rollBackNewData()
    {
        Intent ManHinhMonHoc = new Intent(Nhap_diem.this, MainActivity.class);
        startActivity(ManHinhMonHoc);
    }

    public void nhanDiemSinhVien()
    {
        Intent intent = getIntent();
        bundle = intent.getBundleExtra("Điểm Sinh Viên");
        sv.setHoTen(bundle.getString("Name"));
        sv.setMaSoSinhVien(bundle.getString("MSSV"));
        sv.setGioiTinh(bundle.getString("Gender"));
        sv.setLopHoc(bundle.getString("Class"));
        MonHoc mh = new MonHoc();
        mh.setMaMon(bundle.getString("MaMonHoc"));
        mh.setTenMon(bundle.getString("TenMonHoc"));
        dsv.setSv(sv);
        dsv.setMonHoc(mh);
    }

}
