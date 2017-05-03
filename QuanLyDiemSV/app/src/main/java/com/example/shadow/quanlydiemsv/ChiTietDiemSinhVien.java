package com.example.shadow.quanlydiemsv;

import java.util.ArrayList;

/**
 * Created by Shadow on 10/13/2016.
 */

public class ChiTietDiemSinhVien {
    private ArrayList<SinhVien> listSinhVien;
    private ArrayList<MonHoc> listMonHoc;
    private ArrayList<DiemSinhVien> listDiemSinhVien;

    public ChiTietDiemSinhVien() {
        listMonHoc = new ArrayList<MonHoc>();
        listSinhVien = new ArrayList<SinhVien>();
        listDiemSinhVien = new ArrayList<DiemSinhVien>();
    }



    public ArrayList<SinhVien> getListSinhVien() {
        return listSinhVien;
    }

    public void setListSinhVien(ArrayList<SinhVien> listSinhVien) {
        this.listSinhVien = listSinhVien;
    }

    public ArrayList<MonHoc> getListMonHoc() {
        return listMonHoc;
    }

    public void setListMonHoc(ArrayList<MonHoc> listMonHoc) {
        this.listMonHoc = listMonHoc;
    }

    public ArrayList<DiemSinhVien> getListDiemSinhVien() {
        return listDiemSinhVien;
    }

    public void setListDiemSinhVien(ArrayList<DiemSinhVien> listDiemSinhVien) {
        this.listDiemSinhVien = listDiemSinhVien;
    }
}
