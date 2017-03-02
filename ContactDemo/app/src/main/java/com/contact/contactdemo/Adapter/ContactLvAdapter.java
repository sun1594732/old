package com.contact.contactdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.contact.contactdemo.Bean.ContactBean;
import com.contact.contactdemo.R;

import java.util.List;

/**
 * Created by wubin on 2017/3/1.
 */

public class ContactLvAdapter extends BaseAdapter{
    private List<ContactBean> list;
    private Context context;

    public ContactLvAdapter(List<ContactBean> list, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact_lv,null);
            holder.name = (TextView) convertView.findViewById(R.id.item_contact_name);
            holder.age = (TextView)convertView.findViewById(R.id.item_contact_age);
            holder.phoneNumber = (TextView)convertView.findViewById(R.id.item_contact_phone);
            convertView.setTag(holder);
        }else holder = (PeopleHolder) convertView.getTag();
        ContactBean peopleBean =list.get(position);
        holder.name.setText(peopleBean.getName());
        holder.age.setText("年龄 ： "+peopleBean.getAge());
        holder.phoneNumber.setText("联系方式 ： "+peopleBean.getPhoneNumber());
        return convertView;
    }
    class PeopleHolder{
        TextView name,age,phoneNumber;
    }
}
