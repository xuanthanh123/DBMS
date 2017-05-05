package com.example.izuna.baitapketnoi.models;

/**
 * Created by buivu on 05/05/2017.
 */

public class Subject {
    private String maMonHoc;
    private String tenMonHoc;
    private int hocKy;
    private String tenLop;
    private String khoa;

    public Subject() {
    }

    public Subject(String maMonHoc, String tenMonHoc, int hocKy, String tenLop, String khoa) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.hocKy = hocKy;
        this.tenLop = tenLop;
        this.khoa = khoa;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
}
