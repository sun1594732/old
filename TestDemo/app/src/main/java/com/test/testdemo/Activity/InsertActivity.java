package com.test.testdemo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.test.testdemo.R;

public class InsertActivity extends AppCompatActivity {
    private Spinner mySpinner;
    private String name,location;
    private Button commit;
    private EditText myEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        mySpinner =(Spinner) findViewById(R.id.mine_address);
        commit =(Button) findViewById(R.id.commit);
        myEditText =(EditText) findViewById(R.id.mine_name);
           ArrayAdapter<CharSequence> adapter =
               ArrayAdapter.createFromResource(
                       this,
                       R.array.positions,
                       android.R.layout.simple_spinner_item   //定义下拉菜单的样式
               );
       adapter.setDropDownViewResource(
               android.R.layout.simple_spinner_dropdown_item);  //定义每一个item的样式
       mySpinner.setAdapter(adapter);
        commit .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(myEditText.getText())) {
                    Toast.makeText(InsertActivity.this,"请正确填写商铺名称",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(InsertActivity.this,SecondActivity.class);
                Bundle b = new Bundle();
                b.putString("name",myEditText.getText().toString());
                b.putString("position",location);
                intent.putExtras(b);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
       mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               switch (position) {
                   case 0:
                       location = "东城区";
                       break;
                   case 1:
                       location = "昌平区";
                       break;
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
    }
}
