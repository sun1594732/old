package com.contact.contactdemo.Activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.contact.contactdemo.Bean.ContactBean;
import com.contact.contactdemo.R;
import com.contact.contactdemo.Util.DatabaseHelper;
import com.contact.contactdemo.Util.ToastUtils;

import java.io.Serializable;

public class ContactDetailActivity extends AppCompatActivity {

    private ImageView mBack;
    private TextView mTitle,mName,mAge,mGender,mPhone,mSkill,mJob;
    private ContactBean bean;
    private EditText mEdit;
    private Button mCommit;
    private DatePicker mDatePicker;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        assignView();
        getDataFromIntent();
        initView();
        initDatabase();
    }

    public void assignView(){
        mBack = (ImageView) findViewById(R.id.titleBar_back);
        mTitle = (TextView) findViewById(R.id.titleBar_title);
        mName = (TextView)findViewById(R.id.contact_detail_name);
        mAge = (TextView)findViewById(R.id.contact_detail_age);
        mGender = (TextView)findViewById(R.id.contact_detail_gender);
        mPhone = (TextView)findViewById(R.id.contact_detail_phoneNumber);
        mSkill = (TextView)findViewById(R.id.contact_detail_skill);
        mJob = (TextView)findViewById(R.id.contact_detail_job);
        mEdit = (EditText) findViewById(R.id.contact_detail_edit);
        mCommit = (Button) findViewById(R.id.contact_detail_commit);
        mDatePicker = (DatePicker) findViewById(R.id.dataPicker);
    }

    public void getDataFromIntent(){
        bean = (ContactBean) getIntent().getSerializableExtra("peopleInfo");
    }

    public void initView(){
        mEdit.clearFocus();
        mTitle.setText("个人信息");
        mName.setText(bean.getName());
        mJob.setText(bean.getJob());
        mAge.setText(bean.getJob());
        mSkill.setText(bean.getSkill());
        mPhone.setText(bean.getPhoneNumber());
        mGender.setText(bean.getGender());
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDb();
                ToastUtils.ToastShort("提交成功，在个人中心查看");
                finish();
            }
        });
    }

    public void initDatabase(){
        dbHelper = new DatabaseHelper(this,"people.db",null,1);
        db = dbHelper.getWritableDatabase();

    }

    public void updateDb(){
        db.beginTransaction();
        db.execSQL("insert into people(name,content,publishtime,phone)values(?,?,?,?)",
                new Object[]{bean.getName(), mEdit.getText().toString(), mDatePicker.getYear()+"年 "+(mDatePicker.getMonth()+1)+"月  "+mDatePicker.getDayOfMonth()+"日 ", bean.getPhoneNumber()});
        db.setTransactionSuccessful();
        db.endTransaction();
    }
}
