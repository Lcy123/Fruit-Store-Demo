package com.example.lcy.fruitstoredemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lcy.fruitstoredemo.R;
import com.example.lcy.fruitstoredemo.bean.eat.EatBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Lcy on 2016/10/17.
 */
public class HomePageFragmentAdapter extends BaseAdapter {

    List<EatBean.FeedsBean> feedsBeen;
    Context context;

    public HomePageFragmentAdapter(List<EatBean.FeedsBean> feedsBeen, Context context) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.home_grid_item,parent,false);
            viewHolder=new ViewHolder(convertView);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.publisher.setText(feedsBeen.get(position).getPublisher());
        viewHolder.home_title.setText(feedsBeen.get(position).getTitle());
        Picasso.with(context).load(feedsBeen.get(position).getPublisher_avatar()).into(viewHolder.publisherImage);
        Picasso.with(context).load(feedsBeen.get(position).getCard_image()).into(viewHolder.card_image);
        return convertView;
    }
    class ViewHolder{
        @BindView(R.id.home_card_image)
        ImageView card_image;
        @BindView(R.id.home_publisherImage)
        CircleImageView publisherImage;
        @BindView(R.id.home_publisher)
        TextView publisher;
        @BindView(R.id.home_title)
        TextView home_title;

        public ViewHolder(View view) {
            ButterKnife.bind(this,view);
            view.setTag(this);
        }
    }
}
