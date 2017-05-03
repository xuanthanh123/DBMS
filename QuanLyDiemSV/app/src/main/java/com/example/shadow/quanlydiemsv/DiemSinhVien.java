package com.example.shadow.quanlydiemsv;

/**
 * Created by Shadow on 10/8/2016.
 */

public class DiemSinhVien  {


    public int diemThuongKi;
    public int diemGiuaKi;
    public int diemCuoiKi;
    public MonHoc monHoc;
    public SinhVien sv;
    public DiemSinhVien() {
    }

    public DiemSinhVien(SinhVien sv,MonHoc monHoc, int diemThuongKi, int diemGiuaKi, int diemCuoiKi ) {
        this.sv = sv;
        this.diemThuongKi = diemThuongKi;
        this.diemGiuaKi = diemGiuaKi;
        this.diemCuoiKi = diemCuoiKi;
        this.monHoc = monHoc;
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public int getDiemThuongKi() {
        return diemThuongKi;
    }

    public void setDiemThuongKi(int diemThuongKi) {
        this.diemThuongKi = diemThuongKi;
    }

    public int getDiemGiuaKi() {
        return diemGiuaKi;
    }

    public void setDiemGiuaKi(int diemGiuaKi) {
        this.diemGiuaKi = diemGiuaKi;
    }

    public int getDiemCuoiKi() {
        return diemCuoiKi;
    }

    public void setDiemCuoiKi(int diemCuoiKi) {
        this.diemCuoiKi = diemCuoiKi;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }
}
