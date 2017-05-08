package com.example.izuna.baitapketnoi.subject_by_student;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.izuna.baitapketnoi.R;
import com.example.izuna.baitapketnoi.models.SubjectByStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by buivu on 08/05/2017.
 */

public class SubjectByStudentAdapter extends RecyclerView.Adapter<SubjectByStudentAdapter.SubjectByStudentViewHolder> {

    public Activity activity;
    public List<SubjectByStudent> subjectByStudentList = new ArrayList<>();

    public SubjectByStudentAdapter(Activity activity, List<SubjectByStudent> subjectByStudentList) {
        this.activity = activity;
        this.subjectByStudentList = subjectByStudentList;
    }

    @Override
    public SubjectByStudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(activity, R.layout.item_subject_by_student, null);
        return new SubjectByStudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SubjectByStudentViewHolder holder, int position) {
        SubjectByStudent subjectByStudent = subjectByStudentList.get(position);
        holder.txtMaMonHoc.setText(subjectByStudent.getMaMonHoc());
        holder.txtTenMonHoc.setText(subjectByStudent.getTenMonHoc());
        holder.txtDiemLan1.setText(String.valueOf(subjectByStudent.getDiemLan1()));
        holder.txtDiemLan2.setText(String.valueOf(subjectByStudent.getDiemLan2()));
        holder.txtDiemTB.setText(String.valueOf(subjectByStudent.getTb()));
        holder.txtKetQua.setText(subjectByStudent.getKetQua());
    }

    @Override
    public int getItemCount() {
        return subjectByStudentList.size();
    }

    public class SubjectByStudentViewHolder extends RecyclerView.ViewHolder {

        public TextView txtMaMonHoc, txtTenMonHoc, txtDiemLan1, txtDiemLan2, txtDiemTB, txtKetQua;

        public SubjectByStudentViewHolder(View itemView) {
            super(itemView);

            txtMaMonHoc = (TextView) itemView.findViewById(R.id.txt_maMonHoc);
            txtTenMonHoc = (TextView) itemView.findViewById(R.id.txt_tenMonHoc);
            txtDiemLan1 = (TextView) itemView.findViewById(R.id.txt_diemLan1);
            txtDiemLan2 = (TextView) itemView.findViewById(R.id.txt_diemLan2);
            txtDiemTB = (TextView) itemView.findViewById(R.id.txt_diemTrungBinh);
            txtKetQua = (TextView) itemView.findViewById(R.id.txt_ketQua);
        }
    }
}
