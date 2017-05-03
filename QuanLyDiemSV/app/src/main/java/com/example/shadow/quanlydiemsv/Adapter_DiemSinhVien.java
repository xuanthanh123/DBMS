package com.example.shadow.quanlydiemsv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shadow on 10/8/2016.
 */

public class Adapter_DiemSinhVien extends ArrayAdapter<DiemSinhVien> {

    public Adapter_DiemSinhVien(Context context, int textViewResourceID )
    {
        super(context,textViewResourceID);
    }
    public Adapter_DiemSinhVien(Context context, int resource, List<DiemSinhVien> item)
    {
        super(context,resource,item);
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;
        if(v==null)
        {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.activity_dong__diem_sv,null);
        }
        DiemSinhVien p = getItem(position) ;
        if(p!=null)
        {
            TextView txtMonHoc = (TextView) v.findViewById(R.id.txtMonHoc);
            TextView txtThuongKi = (TextView) v.findViewById(R.id.txtThuongKi);
            TextView txtGiuaKi = (TextView) v.findViewById(R.id.txtGiuaKi);
            TextView txtCuoiKi = (TextView) v.findViewById(R.id.txtCuoiKi);
            TextView txtTrungBinh = (TextView) v.findViewById(R.id.txtTrungBinh);
            txtMonHoc.setText(p.getMonHoc().getTenMon());
            txtThuongKi.setText(p.getDiemThuongKi()+"");
            txtGiuaKi.setText(p.getDiemGiuaKi()+"");
            txtCuoiKi.setText(p.getDiemCuoiKi()+"");
            int tk = Integer.parseInt(txtThuongKi.getText().toString());
            int gk = Integer.parseInt(txtGiuaKi.getText().toString());
            int ck = Integer.parseInt(txtCuoiKi.getText().toString());
            float trungbinh = (float) (tk+gk+ck)/3;
            txtTrungBinh.setText(String.valueOf(trungbinh));
        }
        return v;
    }

}
