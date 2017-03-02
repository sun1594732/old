package com.test.testdemo.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.test.testdemo.Adapter.GoodLvAdapter;
import com.test.testdemo.Bean.GoodBean;
import com.test.testdemo.R;
import com.test.testdemo.Util.AlertDialogUtil;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    private ListView goodLv;
    private GoodLvAdapter adapter;
    private List<GoodBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        goodLv = (ListView) findViewById(R.id.third_lv);
        initData();
        adapter = new GoodLvAdapter(list,this);
        goodLv .setAdapter(adapter);
        goodLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog alertDialog = new AlertDialog.Builder(ThirdActivity.this).
                        setTitle("友情提示").
                        setMessage("确认以"+list.get(position).getGoodPrice()+"元购买该商品?").
                        setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(ThirdActivity.this,FourActivity.class);
                                intent.putExtra("name",list.get(position).getGoodName());
                                intent.putExtra("price",list.get(position).getGoodPrice());
                                startActivity(intent);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ThirdActivity.this,"取消购买",Toast.LENGTH_SHORT).show();
                    }
                }).
                        create();
                alertDialog.show();

            }
        });
    }

    private void initData(){
        list = new ArrayList<>();
        switch (getIntent().getStringExtra("type")) {
            case "0":
                GoodBean bean = new GoodBean("羊肉串","10");
                GoodBean bean1 = new GoodBean("牛肉串","15");
                GoodBean bean2 = new GoodBean("羊腰","18");
                GoodBean bean3 = new GoodBean("菜串","5");
                GoodBean bean4 = new GoodBean("烤面包","8");
                GoodBean bean5 = new GoodBean("烤鱿鱼","15");
                GoodBean bean6 = new GoodBean("烤红薯","8");
                list.add(bean);
                list.add(bean1);
                list.add(bean2);
                list.add(bean3);
                list.add(bean4);
                list.add(bean5);
                list.add(bean6);
                break;
            case "1":
                GoodBean bean7 = new GoodBean("毛巾","10");
                GoodBean bean8 = new GoodBean("脸盆","15");
                GoodBean bean9 = new GoodBean("洗发露","38");
                GoodBean bean10 = new GoodBean("沐浴露","25");
                GoodBean bean11 = new GoodBean("锅","88");
                GoodBean bean12 = new GoodBean("碗","8");
                GoodBean bean13 = new GoodBean("筷子","10");
                list.add(bean7);
                list.add(bean8);
                list.add(bean9);
                list.add(bean10);
                list.add(bean11);
                list.add(bean12);
                list.add(bean13);
                break;
            case "2":
                GoodBean bean14 = new GoodBean("一等烟","100");
                GoodBean bean15 = new GoodBean("二等烟","50");
                GoodBean bean16 = new GoodBean("三等烟","20");
                GoodBean bean17 = new GoodBean("一等酒","500");
                GoodBean bean18 = new GoodBean("二等酒","300");
                GoodBean bean19 = new GoodBean("三等酒","100");
                GoodBean bean20 = new GoodBean("四等酒","50");
                list.add(bean14);
                list.add(bean15);
                list.add(bean16);
                list.add(bean17);
                list.add(bean18);
                list.add(bean19);
                list.add(bean20);
                break;
        }
    }
}
