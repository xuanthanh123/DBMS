package com.example.izuna.baitapketnoi.models;

/**
 * Created by buivu on 02/05/2017.
 */

public class Class {
    private String maLop;
    private String tenLop;
    private String khoa;
    private String heDaoTao;
    private int namNhapHoc;
    private int siSo;
    private String maKhoa;

    public Class() {
    }

    public Class(String maLop, String tenLop, String khoa, String heDaoTao, int namNhapHoc, int siSo, String maKhoa) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.khoa = khoa;
        this.heDaoTao = heDaoTao;
        this.namNhapHoc = namNhapHoc;
        this.siSo = siSo;
        this.maKhoa = maKhoa;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
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

    public String getHeDaoTao() {
        return heDaoTao;
    }

    public void setHeDaoTao(String heDaoTao) {
        this.heDaoTao = heDaoTao;
    }

    public int getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(int namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }
}
