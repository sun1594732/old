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
 * Created by wubin on 2017/3/2.
 */

public class RecordLvAdapter extends BaseAdapter{
    private List<ContactBean>list;
    private Context context;

    public RecordLvAdapter(List<ContactBean> list, Context context) {
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
        RecordHolder holder ;
        if (convertView == null) {
            holder = new RecordHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_record_lv,null);
            holder.name = (TextView) convertView.findViewById(R.id.record_lv_name);
            holder.content = (TextView)convertView.findViewById(R.id.record_lv_content);
            holder.phoneNumber = (TextView)convertView.findViewById(R.id.record_lv_phone);
            holder.date = (TextView)convertView.findViewById(R.id.record_lv_date);
            convertView.setTag(holder);
        }else holder = (RecordHolder) convertView.getTag();
        ContactBean peopleBean =list.get(position);
        holder.name.setText(peopleBean.getName());
        holder.content.setText("    "+peopleBean.getContent());
        holder.phoneNumber.setText("联系方式 ： "+peopleBean.getPhoneNumber());
        holder.date.setText(peopleBean.getDate());
        return convertView;
    }
    class RecordHolder{
        TextView name,content,date,phoneNumber;
    }
    }

