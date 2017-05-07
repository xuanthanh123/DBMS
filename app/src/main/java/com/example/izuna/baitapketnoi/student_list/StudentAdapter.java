package com.example.izuna.baitapketnoi.student_list;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.izuna.baitapketnoi.R;
import com.example.izuna.baitapketnoi.models.Student;

import java.util.List;

/**
 * Created by buivu on 07/05/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private Activity activity;
    private List<Student> students;

    public StudentAdapter(Activity activity, List<Student> students) {
        this.activity = activity;
        this.students = students;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(activity, R.layout.item_student, null);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Student student = students.get(position);
        holder.txtMssv.setText(student.getMssv());
        holder.txtName.setText(student.getHoTen());
        holder.txtDate.setText(student.getNgaySinh());
        if (student.getGioiTinh().equals("1")) {
            holder.txtGender.setText("Nam");
        } else {
            holder.txtGender.setText("Nữ");
        }
        holder.txtClass2.setText(student.getTenLop()); //
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        public TextView txtMssv, txtName, txtDate, txtGender,txtClass2;//

        public StudentViewHolder(View itemView) {
            super(itemView);

            txtMssv = (TextView) itemView.findViewById(R.id.txt_mssv);
            txtName = (TextView) itemView.findViewById(R.id.txt_student_name);
            txtDate = (TextView) itemView.findViewById(R.id.txt_student_date);
            txtGender = (TextView) itemView.findViewById(R.id.txt_gender);
            txtClass2 = (TextView) itemView.findViewById(R.id.txt_class2);//
        }
    }
}
