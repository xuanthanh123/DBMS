package com.example.izuna.baitapketnoi.subject_by_student;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.izuna.baitapketnoi.DBHelper.ConnectClass;
import com.example.izuna.baitapketnoi.R;
import com.example.izuna.baitapketnoi.models.SubjectByStudent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by buivu on 08/05/2017.
 */

public class SubjectByStudentAdapter extends RecyclerView.Adapter<SubjectByStudentAdapter.SubjectByStudentViewHolder> {

    public Activity activity;
    public List<SubjectByStudent> subjectByStudentList = new ArrayList<>();
    private ConnectClass connectClass;

    public SubjectByStudentAdapter(Activity activity, List<SubjectByStudent> subjectByStudentList) {
        this.activity = activity;
        this.subjectByStudentList = subjectByStudentList;
        connectClass = new ConnectClass(activity);
    }

    @Override
    public SubjectByStudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(activity, R.layout.item_subject_by_student, null);
        return new SubjectByStudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SubjectByStudentViewHolder holder, int position) {
        final SubjectByStudent subjectByStudent = subjectByStudentList.get(position);
        holder.txtMaMonHoc.setText(subjectByStudent.getMaMonHoc());
        holder.txtTenMonHoc.setText(subjectByStudent.getTenMonHoc());
        holder.txtDiemLan1.setText(String.valueOf(subjectByStudent.getDiemLan1()));
        holder.txtDiemLan2.setText(String.valueOf(subjectByStudent.getDiemLan2()));
        holder.txtDiemTB.setText(String.valueOf(subjectByStudent.getTb()));
        holder.txtKetQua.setText(subjectByStudent.getKetQua());
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(activity);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_dialog_edit_score);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setGravity(Gravity.CENTER);
                WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();

                //layoutParams.x = convertDpToPixel((float) 130 / 1, ResortsActivity.this);
                dialog.getWindow().setAttributes(layoutParams);
                //get instance of views in custom view
                final EditText edtDiemLan1 = (EditText) dialog.findViewById(R.id.edt_diemLan1);
                final EditText edtDiemLan2 = (EditText) dialog.findViewById(R.id.edt_diemLan2);
                TextView txtTenMH = (TextView) dialog.findViewById(R.id.txt_tenMonHoc);
                //show favorite name into edittext
                edtDiemLan1.setText(String.valueOf(subjectByStudent.getDiemLan1()));
                edtDiemLan2.setText(String.valueOf(subjectByStudent.getDiemLan2()));
                txtTenMH.setText(subjectByStudent.getTenMonHoc());
                Button btnEdit = (Button) dialog.findViewById(R.id.btn_edit);
                btnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            if (!TextUtils.isEmpty(edtDiemLan1.getText()) && !TextUtils.isEmpty(edtDiemLan2.getText())){
                                dialog.dismiss();
                                connectClass.updateScore(connectClass.conn(), Float.parseFloat(edtDiemLan1.getText().toString()),
                                        Float.parseFloat(edtDiemLan2.getText().toString()), subjectByStudent.getMaSV(),
                                        subjectByStudent.getMaMonHoc());
                                subjectByStudentList.clear();
                                subjectByStudentList = connectClass.getALlSubjectByStudent(connectClass.conn(), subjectByStudent.getMaSV());
                                notifyDataSetChanged();
                            }
                            else{
                                Toast.makeText(activity, "Điền điểm trước khi cập nhật", Toast.LENGTH_SHORT).show();
                            }

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
               // builder.create().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                //show dialog

                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjectByStudentList.size();
    }

    public class SubjectByStudentViewHolder extends RecyclerView.ViewHolder {

        public TextView txtMaMonHoc, txtTenMonHoc, txtDiemLan1, txtDiemLan2, txtDiemTB, txtKetQua;
        public Button btnEdit;

        public SubjectByStudentViewHolder(View itemView) {
            super(itemView);

            txtMaMonHoc = (TextView) itemView.findViewById(R.id.txt_maMonHoc);
            txtTenMonHoc = (TextView) itemView.findViewById(R.id.txt_tenMonHoc);
            txtDiemLan1 = (TextView) itemView.findViewById(R.id.txt_diemLan1);
            txtDiemLan2 = (TextView) itemView.findViewById(R.id.txt_diemLan2);
            txtDiemTB = (TextView) itemView.findViewById(R.id.txt_diemTrungBinh);
            txtKetQua = (TextView) itemView.findViewById(R.id.txt_ketQua);
            btnEdit = (Button) itemView.findViewById(R.id.btn_edit);
        }
    }
}
