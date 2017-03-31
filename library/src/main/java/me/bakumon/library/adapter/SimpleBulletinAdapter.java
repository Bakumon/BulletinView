package me.bakumon.library.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.bakumon.library.R;

/**
 * SimpleBulletinAdapter 简单的垂直公告栏轮播适配器
 * Created by bakumon on 2017/3/31 17:22.
 */
public class SimpleBulletinAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<String> mDataList;

    public SimpleBulletinAdapter(Context context, List<String> dataList) {
        mDataList = dataList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public String getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        //判断 convertView 是否为空
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.simple_item, null);
            //将所用的控件保存到viewHolder中
            viewHolder.iv_image = (ImageView) convertView.findViewById(R.id.iv_image);
            viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
            //将viewHolder和convertView绑定
            convertView.setTag(viewHolder);
        } else {
            //如果存在convertView，取出在convertView中保存的viewHolder并赋值给viewHolder
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String data = mDataList.get(position);
        //通过viewHolder找到对应控件，避免每次通过`findViewById`找控件
        viewHolder.iv_image.setImageResource(R.drawable.icon_notice);
        viewHolder.tv_content.setText(data);
        return convertView;
    }

    //自定义ViewHolder类，属性包含所用到的控件
    class ViewHolder {
        ImageView iv_image;
        TextView tv_content;
    }
}
