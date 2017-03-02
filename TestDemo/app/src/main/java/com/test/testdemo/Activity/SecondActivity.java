package com.test.testdemo.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.test.testdemo.Adapter.SelectLvAdapter;
import com.test.testdemo.Bean.CompanyBean;
import com.test.testdemo.R;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ListView DongChengSelectLv,PositionSelectLv,ChangPingSelectLv;
    private SelectLvAdapter DongChengAdapter,ChangPingAdapter;
    private List<CompanyBean> DongChengList,ChangPingList;
    private String[] positions = new String[]{"东城区","昌平区"};
    private Button InsertButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        PositionSelectLv =(ListView) findViewById(R.id.position_lv);
        DongChengSelectLv = (ListView) findViewById(R.id.dongcheng_lv);
        ChangPingSelectLv = (ListView) findViewById(R.id.changping_lv);
        InsertButton = (Button) findViewById(R.id.insert);
        DongChengList = new ArrayList<>();
        ChangPingList = new ArrayList<>();
        DongChengAdapter = new SelectLvAdapter(DongChengList,this);
        ChangPingAdapter = new SelectLvAdapter(ChangPingList,this);
        PositionSelectLv.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, positions));
        initData();
        DongChengSelectLv.setAdapter(DongChengAdapter);
        ChangPingSelectLv.setAdapter(ChangPingAdapter);
        InsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivityForResult(new Intent(SecondActivity.this,InsertActivity.class),1);
            }
        });
        PositionSelectLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        DongChengSelectLv.setVisibility(View.VISIBLE);
                        ChangPingSelectLv.setVisibility(View.GONE);
                        break;
                    case 1:
                        DongChengSelectLv.setVisibility(View.GONE);
                        ChangPingSelectLv.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
        DongChengSelectLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("type",DongChengList.get(position).getType());
                startActivity(intent);
            }
        });
        ChangPingSelectLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("type",ChangPingList.get(position).getType());
                startActivity(intent);
            }
        });
    }

    private void initData(){
        CompanyBean bean = new CompanyBean("平娃三宝","2000","90%","0");
        CompanyBean bean1 = new CompanyBean("南北杂货","5000","95%","1");
        CompanyBean bean2 = new CompanyBean("恒顺烟酒","10000","80%","2");
        CompanyBean bean3 = new CompanyBean("一锅香","3000","91%","0");
        CompanyBean bean4 = new CompanyBean("日用百货","4000","88%","1");
        CompanyBean bean5 = new CompanyBean("升鸣烟酒","8000","85%","2");
        DongChengList.add(bean);
        DongChengList.add(bean1);
        DongChengList.add(bean2);
        ChangPingList.add(bean3);
        ChangPingList.add(bean4);
        ChangPingList.add(bean5);
        DongChengAdapter.notifyDataSetChanged();
        ChangPingAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case RESULT_OK:
                Bundle b = data.getExtras();
                switch (b.getString("position")) {
                    case "东城区":
                        DongChengList.add(new CompanyBean(b.getString("name"),"0","0","0"));
                        DongChengAdapter.notifyDataSetChanged();
                        break;
                    case "昌平区":
                        ChangPingList.add(new CompanyBean(b.getString("name"),"0","0","0"));
                        ChangPingAdapter.notifyDataSetChanged();
                        break;
                    default:
                        break;
                }
                Toast.makeText(SecondActivity.this,"店铺添加成功",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
