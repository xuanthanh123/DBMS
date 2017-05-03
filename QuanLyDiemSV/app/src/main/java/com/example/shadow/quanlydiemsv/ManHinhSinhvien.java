package com.example.shadow.quanlydiemsv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static com.example.shadow.quanlydiemsv.R.id.listSV;

public class ManHinhSinhvien extends AppCompatActivity {

    Button btnThem, btnXoa;
    String hoTen,maSo,lopHoc;
    String gioiTinh;
    EditText hoTenn,maSosv;
    Spinner sp;
    RadioButton radNam,radNu;
    String arr[]={
            "DHCNTT10A",
            "DHCNTT10B",
            "DHCNTT10C"};
    ArrayList<SinhVien> mangSV;
    ArrayList<MonHoc> listMonHoc;
    ArrayList<DiemSinhVien> listDiemSV;
    ListView lv;
    DatabaseReference mData;
    ListAdapter adapter1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_sinhvien);
        // anh xa

        AnhXa();
        ThemActionlistenner();
        DatabaseChildListenner();
        Toast.makeText(ManHinhSinhvien.this,"Load Thành công",Toast.LENGTH_SHORT).show();
        adapter1 = new ListAdapter(

                ManHinhSinhvien.this,R.layout.activity_dong_sinh_vien,mangSV
        );
        lv.setAdapter(adapter1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                maSosv.setText(mangSV.get(position).getMaSoSinhVien());
                hoTenn.setText(mangSV.get(position).getHoTen());
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i<mangSV.size();i++)
                {
                    String XXX = maSosv.getText().toString();
                    if(mangSV.get(i).getMaSoSinhVien().equalsIgnoreCase(XXX))
                    {
                        mangSV.remove(mangSV.get(i));
                        Toast.makeText(ManHinhSinhvien.this,"Xóa thành công",Toast.LENGTH_SHORT).show();
                        mData.child("Sinh Viên").child(XXX).removeValue();
                        adapter1.notifyDataSetChanged();
                        return;
                    }
                }
                Toast.makeText(ManHinhSinhvien.this,"Xóa thất bại.",Toast.LENGTH_SHORT).show();
            }
        });


    }
    public  void AnhXa()
    {
        btnThem = (Button) findViewById(R.id.btnThem);
        hoTenn = (EditText)findViewById(R.id.txtTenNV);
        mData = FirebaseDatabase.getInstance().getReference();
        maSosv = (EditText) findViewById(R.id.txtMaNV) ;
        btnXoa = (Button) findViewById(R.id.btnXoaSinhVien);
        lv = (ListView) findViewById(listSV);
        sp = (Spinner) findViewById(R.id.spinLop);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(

                this,android.R.layout.simple_spinner_item,arr
        );
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        sp.setAdapter(adapter);
        radNam = (RadioButton) findViewById(R.id.rdbGTnam) ;
        radNu = (RadioButton) findViewById(R.id.rdbGTnu);
        mangSV = new ArrayList<SinhVien>();
        listMonHoc = new ArrayList<MonHoc>();

    }

    public  void DatabaseChildListenner()
    {
        // Sự kiện database thêm childNode
        mData.child("Sinh Viên").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                SinhVien sv = dataSnapshot.getValue(SinhVien.class);
                mangSV.add(sv);
                adapter1.notifyDataSetChanged();
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
    public  void ThemActionlistenner()
    {
        //Sự kiện nút thêm
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoTen = hoTenn.getText().toString();
                maSo = maSosv.getText().toString();
                lopHoc = sp.getSelectedItem().toString();
                if(radNam.isChecked()) gioiTinh ="Nam" ;else gioiTinh ="Nữ";
                SinhVien sv = new SinhVien(maSo,hoTen,lopHoc,gioiTinh);
                adapter1.notifyDataSetChanged();
                mData.child("Sinh Viên").child(sv.getMaSoSinhVien()).setValue(sv);
                Toast.makeText(ManHinhSinhvien.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
