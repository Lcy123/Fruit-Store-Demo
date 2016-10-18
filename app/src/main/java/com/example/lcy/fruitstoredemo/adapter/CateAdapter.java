package com.example.lcy.fruitstoredemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lcy.fruitstoredemo.R;
import com.example.lcy.fruitstoredemo.activity.CateDetailActivity;
import com.example.lcy.fruitstoredemo.activity.KnowDetailActivity;
import com.example.lcy.fruitstoredemo.bean.eat.CateBean;
import com.example.lcy.fruitstoredemo.bean.eat.KnowBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lcy on 2016/10/18.
 */
public class CateAdapter extends BaseAdapter {

    List<CateBean.FeedsBean>feedsBeen;
    Context context;

    public CateAdapter(List<CateBean.FeedsBean> feedsBeen, Context context) {
        this.feedsBeen = feedsBeen;
        this.context = context;
    }

    @Override
    public int getCount() {
        return feedsBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return feedsBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.know_list_item,parent,false);
            viewHolder=new ViewHolder(convertView);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tail.setText(feedsBeen.get(position).getTail());
        viewHolder.source.setText(feedsBeen.get(position).getSource());
        viewHolder.title.setText(feedsBeen.get(position).getTitle());
        List<String> images = feedsBeen.get(position).getImages();
        for (int i=0;i<images.size();i++){
            Picasso.with(context).load(images.get(i)).into(viewHolder.imageView);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initEvent(feedsBeen.get(position));
            }
        });
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.know_list_image)
        ImageView imageView;
        @BindView(R.id.know_list_agree)
        TextView tail;
        @BindView(R.id.know_list_source)
        TextView source;
        @BindView(R.id.know_list_title)
        TextView title;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
    private void initEvent(CateBean.FeedsBean bean) {
        Intent intent=new Intent(context, CateDetailActivity.class);
        intent.putExtra("url",bean.getLink());
        context.startActivity(intent);
    }
}
