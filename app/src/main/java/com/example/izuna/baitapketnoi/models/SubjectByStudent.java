package com.example.izuna.baitapketnoi.models;

/**
 * Created by buivu on 08/05/2017.
 */

public class SubjectByStudent {
    private String maSV;
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private String maMonHoc;
    private String tenMonHoc;
    private float diemLan1;
    private float diemLan2;
    private float tb;
    private String ketQua;

    public SubjectByStudent() {
    }

    public SubjectByStudent(String maSV, String hoTen, String ngaySinh, String gioiTinh, String maMonHoc,
                            String tenMonHoc, float diemLan1, float diemLan2, float tb, String ketQua) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.diemLan1 = diemLan1;
        this.diemLan2 = diemLan2;
        this.tb = tb;
        this.ketQua = ketQua;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public float getDiemLan1() {
        return diemLan1;
    }

    public void setDiemLan1(float diemLan1) {
        this.diemLan1 = diemLan1;
    }

    public float getDiemLan2() {
        return diemLan2;
    }

    public void setDiemLan2(float diemLan2) {
        this.diemLan2 = diemLan2;
    }

    public float getTb() {
        return tb;
    }

    public void setTb(float tb) {
        this.tb = tb;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }
}
