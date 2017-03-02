package com.contact.contactdemo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.contact.contactdemo.R;
import com.contact.contactdemo.Util.ToastUtils;

public class LoginActivity extends AppCompatActivity {

    private EditText mLoginName;
    private EditText mLoginPwd;
    private Button mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        assignView();
        initView();
        login();
    }

    public void assignView(){
        mLoginName = (EditText) findViewById(R.id.login_name);
        mLoginPwd = (EditText) findViewById(R.id.login_pwd);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
    }

    public  void initView(){
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLoginName.getText().toString().equals("123")&&mLoginPwd.getText().toString().equals("123")) {
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                }else ToastUtils.ToastShort("用户名密码错误");
            }
        });
    }
    public void login(){

    }
}
