
package com.contact.contactdemo.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.contact.contactdemo.Adapter.RecordLvAdapter;
import com.contact.contactdemo.Bean.ContactBean;
import com.contact.contactdemo.R;
import com.contact.contactdemo.Util.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class RecordListActivity extends AppCompatActivity {

    private TextView mTitle;
    SQLiteDatabase db;
    DatabaseHelper dbHelper;
    List<ContactBean> list;
    private ImageView mBack;
    private RecordLvAdapter adapter;
    private ListView mRecordLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);
        assignView();
        getDataFromSql();
        initView();
        initAdapter();
    }

    public void assignView(){
        mBack = (ImageView) findViewById(R.id.titleBar_back);
        mTitle = (TextView) findViewById(R.id.titleBar_title);
        mRecordLv = (ListView) findViewById(R.id.record_lv);
    }

    public void initView(){
        mTitle.setText("预约人员名单");
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initAdapter(){
        adapter = new RecordLvAdapter(list,RecordListActivity.this);
        mRecordLv.setAdapter(adapter);
    }

    public void getDataFromSql(){
        dbHelper = new DatabaseHelper(this,"people.db",null,1);
        db = dbHelper.getWritableDatabase();
        list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from people", null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    ContactBean bean = new ContactBean();
                    bean.setName(cursor.getString(cursor.getColumnIndex("name")));
                    bean.setPhoneNumber(cursor.getString(cursor.getColumnIndex("phone")));
                    bean.setContent(cursor.getString(cursor.getColumnIndex("content")));
                    bean.setDate(cursor.getString(cursor.getColumnIndex("publishtime")));
                    list.add(bean);
                }
            }
        }
    }

