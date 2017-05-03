package com.example.shadow.quanlydiemsv;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Shadow on 10/5/2016.
 */

public class SpinnerActivity extends Activity {
    //Tạo một mảng dữ liệu giả
    String arr[]={
            "DHCNTT10A",
            "DHCNTT10B",
            "DHCNTT10C"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_sinhvien);

        //Lấy đối tượng Spinner ra
        Spinner spin=(Spinner) findViewById(R.id.spinLop);
        //Gán Data source (arr) vào Adapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr
                );
        //phải gọi lệnh này để hiển thị danh sách cho Spinner
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho Spinner
        spin.setAdapter(adapter);
        //thiết lập sự kiện chọn phần tử cho Spinner

    }
}
