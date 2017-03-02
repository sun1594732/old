package com.test.testdemo.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.testdemo.Bean.CompanyBean;
import com.test.testdemo.R;

import java.util.List;

/**
 * Created by wubin on 2017/3/1.
 */

public class SelectLvAdapter extends BaseAdapter{
    private List<CompanyBean> list;
    private Context context;

    public SelectLvAdapter(List<CompanyBean> list, Context context) {
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
        SelectHolder holder ;
        if (convertView == null) {
            holder = new SelectHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.select_company_lv,null);
            holder.name = (TextView) convertView.findViewById(R.id.company_name);
            holder.count = (TextView) convertView.findViewById(R.id.company_count);
            holder.rate = (TextView) convertView.findViewById(R.id.company_rate);
            convertView.setTag(holder);
        }else holder = (SelectHolder) convertView.getTag();
        CompanyBean companyBean =list.get(position);
        holder.name.setText(companyBean.getName());
        holder.count.setText("月销售额 ： "+companyBean.getCount());
        holder.rate.setText("好评率 ： "+companyBean.getRate());
        return convertView;
    }
    class SelectHolder{
        TextView name,count,rate;
    }
}
