package com.example.btvnandroidday52;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private Button btnSignUp;
    private EditText edtUserName;
    private EditText edtPasswords;
    private EditText edtEmail;
    private EditText edtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        btnSignUp = findViewById(R.id.btnSignUp);
        edtUserName = findViewById(R.id.edtUserName);
        edtPasswords = findViewById(R.id.edtPasswords);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent();

                UserModel userModel = new UserModel();

                String userName  = edtUserName.getText().toString();
                String passwords  = edtPasswords.getText().toString();
                String email  = edtEmail.getText().toString();
                String phone  = edtPhone.getText().toString();

                userModel.setUserName(userName);
                userModel.setPasswords(passwords);
                userModel.setEmail(email);
                userModel.setPhone(phone);
                intent.putExtra(Constants.USER,userModel);
                setResult(RESULT_OK,intent);
                finish();


            }
        });

    }
}