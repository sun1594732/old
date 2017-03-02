package com.contact.contactdemo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.contact.contactdemo.Activity.ContactDetailActivity;
import com.contact.contactdemo.Adapter.ContactLvAdapter;
import com.contact.contactdemo.Bean.ContactBean;
import com.contact.contactdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wubin on 2017/3/2.
 */

public class ContactFragment extends Fragment {

    private ImageView mBack;
    private TextView mTitle;
    private ListView mContactLv;
    private List<ContactBean> list;
    private ContactLvAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        assignView(view);
        initView();
        initData();
        fillAdapter();
        return view;
    }

    public void assignView(View view) {
        mBack = (ImageView) view.findViewById(R.id.titleBar_back);
        mTitle = (TextView) view.findViewById(R.id.titleBar_title);
        mContactLv = (ListView) view.findViewById(R.id.contact_lv);
    }

    public void initView() {
        mBack.setVisibility(View.GONE);
        mTitle.setText("人员列表");
        mContactLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ContactDetailActivity.class);
                intent.putExtra("peopleInfo", list.get(position));
                startActivity(intent);
            }
        });
    }

    public void initData() {
        list = new ArrayList<>();
        list.add(getContactBean("jack", "20", "男", "网络小说作家", "读书写书，偶尔运动，爱好慢跑。", "13456789456"));
        list.add(getContactBean("jim", "30", "男", "无业", "空有一身远大理想抱负的无业青年", "11523578945"));
        list.add(getContactBean("pop", "22", "男", "学生", "在校学生，今年是一名大三的计算机软件专业的学生，爱好计算机", "18422501236"));
        list.add(getContactBean("bobby", "11", "女", "学生", "琴棋书画样样精通的五年级小学生，性格活泼好动", "12548645234"));
        list.add(getContactBean("david", "40", "男", "事业单位人员", "每天在悠闲中度日，为孩子不好好学习操碎了心", "14578954521"));
        list.add(getContactBean("jerry", "29", "男", "程序员", "爱读书爱看报的单身程序员，擅长php及node.js", "17895452131"));
        list.add(getContactBean("lizzy", "34", "女", "家庭主妇", "日常的洗衣做饭带孩子，逛超市买东西是唯一爱好", "17895421562"));
        list.add(getContactBean("july", "35", "女", "中学教师", "喜欢和学生们一起瞎胡闹的中学物理老师，逻辑思维优异", "17845236548"));
        list.add(getContactBean("juli", "50", "女", "教授", "名牌大学教授，为神经学研究献出一生", "13456789456"));
        list.add(getContactBean("lin", "21", "男", "服务员", "放弃学业而来到大北京打工谋生的年轻人一枚", "18745236489"));
    }

    public void fillAdapter() {
        adapter = new ContactLvAdapter(list, getActivity());
        mContactLv.setAdapter(adapter);
    }

    public ContactBean getContactBean(String name, String age, String gender, String job, String skill, String phone) {
        ContactBean b = new ContactBean(name, age, gender, job, skill, phone);
        return b;
    }
}
