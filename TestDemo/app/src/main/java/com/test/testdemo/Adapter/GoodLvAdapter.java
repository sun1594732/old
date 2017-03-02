package com.test.testdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.testdemo.Bean.CompanyBean;
import com.test.testdemo.Bean.GoodBean;
import com.test.testdemo.R;

import java.util.List;

/**
 * Created by wubin on 2017/3/1.
 */

public class GoodLvAdapter extends BaseAdapter{
    private List<GoodBean> list;
    private Context context;

    public GoodLvAdapter(List<GoodBean> list, Context context) {
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
        GoodHolder holder ;
        if (convertView == null) {
            holder = new GoodHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.select_good_lv,null);
            holder.name = (TextView) convertView.findViewById(R.id.good_name);
            holder.price = (TextView)convertView.findViewById(R.id.good_price);
            convertView.setTag(holder);
        }else holder = (GoodHolder) convertView.getTag();
        GoodBean goodBean =list.get(position);
        holder.name.setText(goodBean.getGoodName());
        holder.price.setText(goodBean.getGoodPrice()+"元/串（个）");
        return convertView;
    }
    class GoodHolder{
        TextView name,price;
    }
}
