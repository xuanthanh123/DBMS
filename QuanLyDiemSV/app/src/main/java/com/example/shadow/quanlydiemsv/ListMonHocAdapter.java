package com.example.shadow.quanlydiemsv;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shadow on 10/6/2016.
 */

public class ListMonHocAdapter extends ArrayAdapter<MonHoc> {

    public ListMonHocAdapter(Context context, int textViewResourceID )
    {
        super(context,textViewResourceID);
    }
    public ListMonHocAdapter(Context context, int resource, List<MonHoc> item)
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
            v = vi.inflate(R.layout.activity_dong_mon_hoc,null);
        }
        MonHoc p = getItem(position) ;
        if(p!=null)
        {
            TextView txtMaMonHoc = (TextView) v.findViewById(R.id.txtMaMH);
            TextView txtTenMonHoc = (TextView) v.findViewById(R.id.txtTenMH);
            txtMaMonHoc.setText(p.getMaMon());
            txtTenMonHoc.setText(p.getTenMon());
        }
        return v;
    }

}
