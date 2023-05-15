package com.example.btvnandroidday52;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button btnSignUp;
    private EditText edtUserName;
    private EditText edtPasswords;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

    }

    private void initView() {
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);
        edtUserName = findViewById(R.id.edtUserName);
        edtPasswords = findViewById(R.id.edtPasswords);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(LoginActivity.this,SignUpActivity.class);
           //     startActivity(intent);
                activityResultLauncher.launch(intent);
            }
        });




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(LoginActivity.this,HomeActivity.class);

                String userName = edtUserName.getText().toString();
                String passwords = edtPasswords.getText().toString();


                UserModel userModel = new UserModel();
                userModel.setUserName(userName);
                userModel.setPasswords(passwords);


          //      intent.putExtra(Constants.USER_NAME,userName);
            //    intent.putExtra(Constants.PASSWORDS,passwords);


                intent.putExtra(Constants.USER,userModel);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.USER_NAME, userName);
                bundle.putString(Constants.PASSWORDS, passwords);

                intent.putExtras(bundle);


                startActivity(intent);
            }
        });

    }

    ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {

                        if (result.getResultCode() == RESULT_OK) {
                            Intent intent = result.getData();
                            UserModel userModel = (UserModel) intent.getSerializableExtra(Constants.USER);

                        }
                    });
}