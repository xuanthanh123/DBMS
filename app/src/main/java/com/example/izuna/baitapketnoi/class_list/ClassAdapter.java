package com.example.izuna.baitapketnoi.class_list;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.izuna.baitapketnoi.R;
import com.example.izuna.baitapketnoi.models.Class;

import java.util.List;

/**
 * Created by thanh on 02/05/2017.
 * lớp adapter này dùng để đổ dữ liệu lên recyclerview, recyclerview là view để hiển thị dữ liệu
 */

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassListViewHolder> {

    private List<Class> classList;
    private Activity activity;

    //hàm khởi tạo
    public ClassAdapter(List<Class> classList, Activity activity) {
        this.classList = classList;
        this.activity = activity;
    }

    @Override
    public ClassListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //hàm ánh xạ, cho biết layout nào sẽ là itemview
        View itemView = View.inflate(activity, R.layout.item_class, null);
        return new ClassListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ClassListViewHolder holder, int position) {
        //lấy ra object trong list tương ứng với position
        //trường hợp này là lớp Class
        Class aClass = classList.get(position);
        holder.txtTenLop.setText(aClass.getTenLop());
        holder.txtKhoa.setText(aClass.getKhoa());
        holder.txtSiSo.setText(String.valueOf(aClass.getSiSo()));
        holder.txtHeDaoTao.setText(aClass.getHeDaoTao());
    }

    @Override
    public int getItemCount() {
        return classList.size();
    }

    //lớp viewholder, dùng để quản lý từng components trong itemview
    public class ClassListViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTenLop, txtKhoa, txtHeDaoTao, txtSiSo;

        public ClassListViewHolder(View itemView) {
            super(itemView);

            txtTenLop = (TextView) itemView.findViewById(R.id.txt_class_name);
            txtKhoa = (TextView) itemView.findViewById(R.id.txt_faculty);
            txtHeDaoTao = (TextView) itemView.findViewById(R.id.txt_he_dao_tao);
            txtSiSo = (TextView) itemView.findViewById(R.id.txt_number);
        }
    }
}
