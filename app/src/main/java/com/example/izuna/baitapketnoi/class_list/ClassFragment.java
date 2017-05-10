package com.example.izuna.baitapketnoi.class_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.izuna.baitapketnoi.DBHelper.ConnectClass;
import com.example.izuna.baitapketnoi.R;
import com.example.izuna.baitapketnoi.models.Class;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by buivu on 01/05/2017.
 */

public class ClassFragment extends Fragment {

    private View rootView;
    private ClassAdapter classAdapter;
    private ConnectClass connectDatabase;
    private RecyclerView mRecycler;
    private List<Class> listClass = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_class, container, false);
        mRecycler = (RecyclerView) rootView.findViewById(R.id.recycler_class);
        connectDatabase = new ConnectClass(getActivity());
        loadData();
        return rootView;
    }

    //hàm lấy dữ liệu từ sql
    private void loadData() {
        try {
            //lấy data từ sql
            listClass = connectDatabase.getAllClass(connectDatabase.conn());
            //khởi tạo lớp adapter với 2 tham số
            classAdapter = new ClassAdapter(listClass, getActivity());
            //cài đặt layout manager cho recyclerview, trường hợp này là layout dạng list, kiểu vertical
            mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecycler.setAdapter(classAdapter);
            //để gọi lại hàm onBindViewHolder trong adapter
            classAdapter.notifyDataSetChanged();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
