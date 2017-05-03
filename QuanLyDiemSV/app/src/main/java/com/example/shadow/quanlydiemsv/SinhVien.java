package com.example.shadow.quanlydiemsv;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Shadow on 10/5/2016.
 */

public class SinhVien implements Serializable {
    public String maSoSinhVien;
    public String hoTen;
    public String lopHoc;
    public String gioiTinh;

    public ArrayList<MonHoc> listMonHoc;
    public DiemSinhVien dsv;

    public SinhVien() {
    }

    public SinhVien(String maSoSinhVien) {
        this.maSoSinhVien = maSoSinhVien;
    }

    public SinhVien(String maSoSinhVien, String hoTen, String lopHoc, String gioiTinh) {
        this.maSoSinhVien = maSoSinhVien;
        this.hoTen = hoTen;
        this.lopHoc = lopHoc;
        this.gioiTinh = gioiTinh;
    }

    public SinhVien(String maSoSinhVien, String hoTen, String lopHoc, String gioiTinh, ArrayList<MonHoc> listMonHoc, DiemSinhVien dsv) {
        this.maSoSinhVien = maSoSinhVien;
        this.hoTen = hoTen;
        this.lopHoc = lopHoc;
        this.gioiTinh = gioiTinh;
        this.listMonHoc = listMonHoc;
        this.dsv = dsv;
    }

    public ArrayList<MonHoc> getListMonHoc() {
        return listMonHoc;
    }

    public void setListMonHoc(ArrayList<MonHoc> listMonHoc) {
        this.listMonHoc = listMonHoc;
    }

    public DiemSinhVien getDsv() {
        return dsv;
    }

    public void setDsv(DiemSinhVien dsv) {
        this.dsv = dsv;
    }

    public String getMaSoSinhVien() {
        return maSoSinhVien;
    }

    public void setMaSoSinhVien(String maSoSinhVien) {
        this.maSoSinhVien = maSoSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
