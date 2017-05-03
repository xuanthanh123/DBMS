package com.example.izuna.baitapketnoi.DBHelper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.StrictMode;
import android.util.Log;

import com.example.izuna.baitapketnoi.models.Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ConnectDatabase {
    String ip = "192.168.250.16";
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "databaseconnect";
    String un = "androidtest";
    String password = "adidas1995"; //

    private Connection conn;
    private Activity activity;

    public ConnectDatabase(Activity activity) {
        this.activity = activity;
        conn = conn();
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
    public List<Class> getAllClass() throws SQLException {

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
        return classes;
    }
}
