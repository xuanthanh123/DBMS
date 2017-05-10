package com.example.izuna.baitapketnoi.subject_list;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.izuna.baitapketnoi.R;
import com.example.izuna.baitapketnoi.models.Subject;

import java.util.List;

/**
 * Created by thanh on 05/05/2017.
 */

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {

    private Activity activity;
    private List<Subject> subjects;

    //hàm khởi tạo
    public SubjectAdapter(Activity activity, List<Subject> subjects) {
        this.activity = activity;
        this.subjects = subjects;
    }

    //hàm này ánh xạ tới itemview, cho biết layout nào sẽ được dùng để hiển thị dữ liệu
    @Override
    public SubjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(activity, R.layout.item_subject, null);
        return new SubjectViewHolder(itemView);
    }

    //hàm này dùng để load dữ liệu lên itemview
    @Override
    public void onBindViewHolder(SubjectViewHolder holder, int position) {
        //lấy 1 đối tưỡng SUbject ra dể hiển thị
        Subject subject = subjects.get(position);
        holder.txtTenMonHoc.setText(subject.getTenMonHoc());
        holder.txtHocKy.setText(String.format("Học kỳ %d", subject.getHocKy()));
        holder.txtKhoa.setText(subject.getKhoa());
        holder.txtTenLop.setText(subject.getTenLop());
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    //viewholder tương ứng với mỗi item, holder này sẽ quản lý các components trong item đó
    public class SubjectViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTenMonHoc, txtHocKy, txtTenLop, txtKhoa;

        public SubjectViewHolder(View itemView) {
            super(itemView);

            txtTenMonHoc = (TextView) itemView.findViewById(R.id.txt_subject_name);
            txtHocKy = (TextView) itemView.findViewById(R.id.txt_semester);
            txtTenLop = (TextView) itemView.findViewById(R.id.txt_class_name);
            txtKhoa = (TextView) itemView.findViewById(R.id.txt_faculty);

        }
    }
}
