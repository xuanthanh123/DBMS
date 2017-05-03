package com.example.shadow.quanlydiemsv;

import java.util.ArrayList;

/**
 * Created by Shadow on 10/6/2016.
 */

public class MonHoc {
    public  String maMon;
    public  String tenMon;
    public  DiemSinhVien diemSinhVien;
    public ArrayList<SinhVien> listSV;
    public MonHoc() {
    }

    public MonHoc(String maMon, String tenMon) {
        this.maMon = maMon;
        this.tenMon = tenMon;
    }

    public MonHoc(String maMon, String tenMon, DiemSinhVien diemSinhVien) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.diemSinhVien = diemSinhVien;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
}
