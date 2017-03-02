package com.contact.contactdemo.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.contact.contactdemo.Fragment.ContactFragment;
import com.contact.contactdemo.Fragment.MineFragment;
import com.contact.contactdemo.R;

public class HomeActivity extends AppCompatActivity {
    private RadioGroup rg;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment contactFragment,mineFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        assignView();
        createFragment();
        initView();
    }

    public void assignView(){
        rg = (RadioGroup) findViewById(R.id.home_rg);
    }

    public void initView(){
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.contact:
                        changeFragment(contactFragment);
                        break;
                    case R.id.mine:
                        changeFragment(mineFragment);
                        break;
                    default:
                        break;
                }
            }
        });
    }
    public void createFragment(){
        contactFragment = new ContactFragment();
        mineFragment = new MineFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.home_container, contactFragment);
        transaction.add(R.id.home_container, mineFragment);
        transaction.hide(mineFragment);
        transaction.commit();
    }

    public void changeFragment(Fragment f){
        transaction = manager.beginTransaction();
        transaction.hide(contactFragment);
        transaction.hide(mineFragment);
        transaction.show(f);
        transaction.commit();
    }
}
