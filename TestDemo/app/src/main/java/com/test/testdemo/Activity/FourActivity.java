package com.test.testdemo.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.test.testdemo.Adapter.PeopleAdapter;
import com.test.testdemo.Bean.PeopleBean;
import com.test.testdemo.R;

import java.util.ArrayList;
import java.util.List;

public class FourActivity extends AppCompatActivity {

    private ListView lv;
    private List<PeopleBean> list;
    private PeopleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        lv = (ListView) findViewById(R.id.daifu_lv);
        initData();
        adapter  = new PeopleAdapter(list,FourActivity.this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog alertDialog = new AlertDialog.Builder(FourActivity.this).
                        setTitle("友情提示").
                        setMessage("确认以"+getIntent().getStringExtra("price")+"元为 "+list.get(position).getName()+" 购买"+getIntent().getStringExtra("name")+"?").
                        setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(FourActivity.this,"支付成功",Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(FourActivity.this,"取消购买",Toast.LENGTH_SHORT).show();
                    }
                }).create();
                alertDialog.show();
            }
        });

    }

    private void initData(){
        list = new ArrayList<>();
        PeopleBean bean = new PeopleBean("张三","东城区A区域","18245687894");
        PeopleBean bean1 = new PeopleBean("李四","东城区B区域","18142287894");
        PeopleBean bean2 = new PeopleBean("王五","昌平区A区域","18315687894");
        PeopleBean bean3 = new PeopleBean("朱六","东城区C区域","13245687894");
        PeopleBean bean4 = new PeopleBean("TONY","东城区A区域","1222447894");
        PeopleBean bean5 = new PeopleBean("SANDY","昌平区D区域","14545687894");
        PeopleBean bean6 = new PeopleBean("JIM","东城区D区域","15423447894");
        PeopleBean bean7 = new PeopleBean("TOM","昌平区A区域","1125687894");
        PeopleBean bean8 = new PeopleBean("HAHA","昌平区B区域","1766687894");
        PeopleBean bean9 = new PeopleBean("JACK","东城区B区域","10975687894");
        list.add(bean);
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        list.add(bean5);
        list.add(bean6);
        list.add(bean7);
        list.add(bean8);
        list.add(bean9);
    }
}
