package com.example.shadow.quanlydiemsv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shadow on 10/5/2016.
 */

public class ListAdapter extends ArrayAdapter<SinhVien> {

    public ListAdapter(Context context, int textViewResourceID )
    {
        super(context,textViewResourceID);
    }
    public ListAdapter(Context context, int resource, List<SinhVien> item)
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
            v = vi.inflate(R.layout.activity_dong_sinh_vien,null);
        }
        SinhVien p = getItem(position) ;
        if(p!=null)
        {
            TextView txtMaSV1 = (TextView) v.findViewById(R.id.txtMaSV1);
            TextView txtTenSV = (TextView) v.findViewById(R.id.txtTensv);
            TextView txtLop = (TextView) v.findViewById(R.id.txtDongLopHoc);
            txtLop.setText(p.getLopHoc());
            txtMaSV1.setText(p.getMaSoSinhVien());
            txtTenSV.setText(p.getHoTen());
        }
        return v;
    }

}
