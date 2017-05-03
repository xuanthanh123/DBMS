package com.example.shadow.quanlydiemsv;

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

public class ManHinhMonHoc extends AppCompatActivity  {

    EditText edtTenMon,edtMaMon;
    Button btnThemMonHoc,btnXoaMon;
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
        setContentView(R.layout.activity_man_hinh_mon_hoc);
        mData = FirebaseDatabase.getInstance().getReference();
        /* Ánh Xạ*/
        AnhXa();
        /*Load csdl*/
        LoadCSDL();
        //su kien them mon hoc
        SukienThemMonHoc();
        //su kien thay doi lv
        SKThayDoiVaoLV();
        //Su khien nut xoa mon hoc
        SuKienNutXoa();

        listView.setAdapter(adapter);

    }
    public void AnhXa(){
        btnThemMonHoc = (Button) findViewById(R.id.btnThemMH);
        edtMaMon = (EditText) findViewById(edtMaMH);
        edtTenMon = (EditText) findViewById(edtTenMH);
        btnXoaMon = (Button)findViewById(R.id.btnXoaMH) ;
        ListMonHoc = new ArrayList<MonHoc>();
        listView = (ListView) findViewById(R.id.lvMH) ;
        sv = new SinhVien();
        dsv = new DiemSinhVien();
        /*Set dữ liệu cho Adapter*/
        adapter = new ListMonHocAdapter(
                ManHinhMonHoc.this,R.layout.activity_dong_mon_hoc,ListMonHoc
        );
    }

    public void LoadCSDL() {
        mData.child("Môn Học").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MonHoc mh = dataSnapshot.getValue(MonHoc.class);
                ListMonHoc.add(mh);
                adapter.notifyDataSetChanged();
                Toast.makeText(ManHinhMonHoc.this, "Load thành công", Toast.LENGTH_SHORT).show();
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
        public void SukienThemMonHoc(){
            btnThemMonHoc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tenMon = edtTenMon.getText().toString();
                    maMon = edtMaMon.getText().toString();
                    MonHoc mh = new MonHoc(maMon,tenMon);
                    //ListMonHoc.add(mh);
                    mData.child("Môn Học").child(mh.maMon).setValue(mh);
                    adapter.notifyDataSetChanged();
                    edtTenMon.setText("");
                    edtMaMon.setText("");
                    Toast.makeText(ManHinhMonHoc.this,"Thêm Thành Công", Toast.LENGTH_SHORT).show();
                }
            });
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
        public void SuKienNutXoa(){
            btnXoaMon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    tenMon = edtTenMon.getText().toString();
                    maMon = edtMaMon.getText().toString();

                    ListMonHoc.remove(vt);
                    mData.child("Môn Học").child(maMon).removeValue();
                    adapter.notifyDataSetChanged();
                    edtTenMon.setText("");
                    edtMaMon.setText("");
                    Toast.makeText(ManHinhMonHoc.this,"Xóa Thành Công", Toast.LENGTH_SHORT).show();
                }
            });
        }

}
