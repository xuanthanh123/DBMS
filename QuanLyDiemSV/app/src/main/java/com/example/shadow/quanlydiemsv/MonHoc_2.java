package com.example.shadow.quanlydiemsv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static com.example.shadow.quanlydiemsv.R.id.edtMaMH;
import static com.example.shadow.quanlydiemsv.R.id.edtTenMH;

public class MonHoc_2 extends AppCompatActivity  {

    EditText edtTenMon,edtMaMon;
    Button btnNhap;
    String tenMon,maMon;
    DatabaseReference mData;
    ArrayList<MonHoc> ListMonHoc;
    ListView listView;
    ListMonHocAdapter adapter;
    int vt;
    SinhVien sv;
    Bundle bundle,bundlee;
    DiemSinhVien dsv;


    //ArrayAdapter<MonHoc> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_hoc_2);
        mData = FirebaseDatabase.getInstance().getReference();
        /* Ánh Xạ*/
        AnhXa();
        /*Load csdl*/
        LoadCSDL();
        // đổ dữ liệu vào list view
        SKThayDoiVaoLV();

        listView.setAdapter(adapter);


        //Sự kiện nút nhập && chuyển dữ liệu qua màn hình khác
        nhapOnclick();

    }
    public void AnhXa(){
        edtMaMon = (EditText) findViewById(edtMaMH);
        edtTenMon = (EditText) findViewById(edtTenMH);
        btnNhap = (Button) findViewById(R.id.btnNhap); //1
        ListMonHoc = new ArrayList<MonHoc>();
        listView = (ListView) findViewById(R.id.lvMH) ;
        edtMaMon.setFocusable(false);
        edtTenMon.setFocusable(false);
        sv = new SinhVien();
        dsv = new DiemSinhVien();

        /*Set dữ liệu cho Adapter*/
        adapter = new ListMonHocAdapter(
                MonHoc_2.this,R.layout.activity_dong_mon_hoc,ListMonHoc
        );
    }

    public void SKThayDoiVaoLV(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtMaMon.setText(ListMonHoc.get(position).getMaMon() + "");
                edtTenMon.setText(ListMonHoc.get(position).getTenMon() + "");
                vt = position;
            }
        });
    }

    public void nhapOnclick()
    {
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Nhận dữ liệu từ màn hình Thông tin sinh viên và tạo ra điểm sinh viên
                Intent intent = getIntent();
                bundle = new Bundle();
                bundle = intent.getBundleExtra("Sinh Viên");
                sv.setMaSoSinhVien( bundle.getString("MSSV"));
                sv.setHoTen(bundle.getString("Name"));
                sv.setGioiTinh(bundle.getString("Gender"));
                sv.setLopHoc(bundle.getString("Class"));
                tenMon = edtTenMon.getText().toString();
                maMon = edtMaMon.getText().toString();
                if(edtTenMon.getText().toString().equals("")||edtMaMon.getText().toString().equals(""))
                {
                    Toast.makeText(MonHoc_2.this, "Chọn một môn học bên dưới", Toast.LENGTH_SHORT).show();
                    return;
                }
                MonHoc mh = new MonHoc(maMon,tenMon);
                dsv.setSv(sv);
                dsv.setMonHoc(mh);
                Intent intent2 = new Intent(MonHoc_2.this, Nhap_diem.class);
                bundlee = new Bundle();
                bundlee.putString("MSSV",dsv.getSv().getMaSoSinhVien());
                bundlee.putString("Name",dsv.getSv().getHoTen());
                bundlee.putString("Gender",dsv.getSv().gioiTinh);
                bundlee.putString("Class",dsv.getSv().getLopHoc());
                bundlee.putString("MaMonHoc",dsv.getMonHoc().getMaMon());
                bundlee.putString("TenMonHoc",dsv.getMonHoc().getTenMon());
                intent2.putExtra("Điểm Sinh Viên",bundlee );
                startActivity(intent2);

            }
        });
    }

    public void LoadCSDL() {
        mData.child("Môn Học").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MonHoc mh = dataSnapshot.getValue(MonHoc.class);
                ListMonHoc.add(mh);
                adapter.notifyDataSetChanged();
                Toast.makeText(MonHoc_2.this, "Load thành công", Toast.LENGTH_SHORT).show();
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
