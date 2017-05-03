package com.example.shadow.quanlydiemsv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button sinhVien,btnMonHoc,btnNhapDiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sinhVien = (Button) findViewById(R.id.btnSinhVien);
        btnMonHoc = (Button) findViewById(R.id.btnMonHoc) ;
        btnNhapDiem = (Button) findViewById(R.id.btnNhapDiem) ;
        btnNhapDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ManHinhNhapDiem = new Intent(MainActivity.this, ManHinhNhapDiem.class);
                startActivity(ManHinhNhapDiem);
            }
        });
        btnMonHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ManHinhMonHoc = new Intent(MainActivity.this, ManHinhMonHoc.class);
                startActivity(ManHinhMonHoc);
            }
        });
        sinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ManHinhMain = new Intent(MainActivity.this, ManHinhSinhvien.class);
                startActivity(ManHinhMain);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
