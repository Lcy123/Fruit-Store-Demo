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
import com.example.lcy.fruitstoredemo.activity.EvaDetailActivity;
import com.example.lcy.fruitstoredemo.bean.eat.EvaluatingBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lcy on 2016/10/18.
 */
public class EvaluatingAdapter extends BaseAdapter {

    List<EvaluatingBean.FeedsBean>feedsBeen;
    Context context;

    public EvaluatingAdapter(List<EvaluatingBean.FeedsBean> feedsBeen, Context context) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.eva_list_item,parent,false);
            viewHolder=new ViewHolder(convertView);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(feedsBeen.get(position).getSource());
        viewHolder.tail.setText(feedsBeen.get(position).getTail());
        viewHolder.title.setText(feedsBeen.get(position).getTitle());
        Picasso.with(context).load(feedsBeen.get(position).getBackground()).into(viewHolder.imageView);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initEvent(feedsBeen.get(position));
            }
        });

        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.eva_image)
        ImageView imageView;
        @BindView(R.id.eva_source)
        TextView textView;
        @BindView(R.id.eva_title)
        TextView title;
        @BindView(R.id.eva_tail)
        TextView tail;

        public ViewHolder(View view) {
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }

    private void initEvent(EvaluatingBean.FeedsBean bean) {
        Intent intent=new Intent(context, EvaDetailActivity.class);
        intent.putExtra("url",bean.getLink());
        context.startActivity(intent);
    }

}
