package com.test.testdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.testdemo.Bean.GoodBean;
import com.test.testdemo.Bean.PeopleBean;
import com.test.testdemo.R;

import java.util.List;

/**
 * Created by wubin on 2017/3/1.
 */

public class PeopleAdapter extends BaseAdapter{
    private List<PeopleBean> list;
    private Context context;

    public PeopleAdapter(List<PeopleBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PeopleHolder holder ;
        if (convertView == null) {
            holder = new PeopleHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.select_people_lv,null);
            holder.name = (TextView) convertView.findViewById(R.id.people_name);
            holder.address = (TextView)convertView.findViewById(R.id.people_address);
            holder.phoneNumber = (TextView)convertView.findViewById(R.id.people_phoneNumber);
            convertView.setTag(holder);
        }else holder = (PeopleHolder) convertView.getTag();
        PeopleBean peopleBean =list.get(position);
        holder.name.setText(peopleBean.getName());
        holder.address.setText("住址 ： "+peopleBean.getAddress());
        holder.phoneNumber.setText("联系方式 ： "+peopleBean.getPhoneNumber());
        return convertView;
    }
    class PeopleHolder{
        TextView name,address,phoneNumber;
    }
}
