package com.example.izuna.baitapketnoi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.StrictMode;
import android.util.Log;

import com.example.izuna.baitapketnoi.models.Class;
import com.example.izuna.baitapketnoi.models.Subject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ConnectClass {
    String ip = "192.168.1.78";
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "dbms";
    String un = "tan";
    String password = "123"; //

    private Activity activity;

    public ConnectClass(Activity activity) {
        this.activity = activity;
    }

    @SuppressLint("NewApi")
    public Connection conn() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {

            java.lang.Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
                    + "databaseName=" + db + ";user=" + un + ";password="
                    + password + ";";
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }

    //get list province
    public List<Class> getAllClass(Connection conn) throws SQLException {

        List<Class> classes = new ArrayList<>();
        String query = "select * from LopHoc";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String maLop = rs.getString("MaLop");
            String tenLop = rs.getString("TenLop");
            String khoa = rs.getString("Khoa");
            String heDaoTao = rs.getString("HeDaoTao");
            int namNhapHoc = rs.getInt("NamNhapHoc");
            int siSo = rs.getInt("SiSo");
            String maKhoa = rs.getString("MaKhoa");

            Class aClass = new Class(maLop, tenLop, khoa, heDaoTao, namNhapHoc, siSo, maKhoa);
            // lưu vào list
            classes.add(aClass);
        }
        conn.close();
        return classes;
    }

    //get list province
    public List<Subject> getAllSubject(Connection conn) throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        String query = "select Mon.MaMH,Mon.TenMH,Mon_LopHoc.HocKy,LopHoc.TenLop,LopHoc.Khoa\n" +
                "from Mon,Mon_LopHoc,LopHoc\n" +
                "where Mon.MaMH=Mon_LopHoc.MaMH and Mon_LopHoc.MaMH=LopHoc.MaLop";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String maMonHoc = rs.getString("MaMH");
            String tenMonHoc = rs.getString("TenMH");
            int hocKy = rs.getInt("HocKy");
            String tenLop = rs.getString("TenLop");
            String khoa = rs.getString("Khoa");
            //add to class subject
            Subject subject = new Subject(maMonHoc, tenMonHoc, hocKy, tenLop, khoa);
            subjects.add(subject);
        }
        conn.close();
        return subjects;
    }
}
