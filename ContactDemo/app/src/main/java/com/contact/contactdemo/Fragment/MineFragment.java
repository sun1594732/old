package com.contact.contactdemo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.contact.contactdemo.Activity.RecordListActivity;
import com.contact.contactdemo.R;

/**
 * Created by wubin on 2017/3/2.
 */

public class MineFragment extends Fragment{
    private RelativeLayout mRecordList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine,container,false);
        assignView(view);
        initView();
        return view;
    }

    public void assignView(View view){
        mRecordList = (RelativeLayout) view.findViewById(R.id.mine_record);
    }

    public void initView(){
        mRecordList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RecordListActivity.class));
            }
        });
    }
}
