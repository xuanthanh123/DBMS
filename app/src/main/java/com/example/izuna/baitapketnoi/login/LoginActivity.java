package com.example.izuna.baitapketnoi.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.izuna.baitapketnoi.DBHelper.ConnectClass;
import com.example.izuna.baitapketnoi.MainActivity;
import com.example.izuna.baitapketnoi.R;

import java.sql.SQLException;

/**
 * Created by thanh on 10/05/2017.
 */

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private ConnectClass connectClass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        connectClass = new ConnectClass(this);
        //init view
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkDataComplete()) {
                    try {
                        int result = connectClass.login(connectClass.conn(), edtUsername.getText().toString(),
                                edtPassword.getText().toString());
                        if (result == 1) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    private boolean checkDataComplete() {
        boolean result = true;
        if (TextUtils.isEmpty(edtUsername.getText())) {
            edtUsername.setError("Bắt buộc");
            result = false;
        }
        if (TextUtils.isEmpty(edtPassword.getText())) {
            edtPassword.setError("Bắt buộc");
            result = false;
        }
        return result;
    }
}
