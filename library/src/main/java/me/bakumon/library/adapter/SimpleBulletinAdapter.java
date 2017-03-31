package me.bakumon.library.adapter;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.bakumon.library.R;

/**
 * SimpleBulletinAdapter 简单的垂直公告栏轮播适配器
 * Created by bakumon on 2017/3/31 17:22.
 */
public class SimpleBulletinAdapter extends BulletinAdapter {

    private LayoutInflater layoutInflater;
    private List<String> mDataList;
    private int mImageDrawableID = R.drawable.icon_notice;

    public SimpleBulletinAdapter(Context context, List<String> dataList) {
        this(context, dataList, R.drawable.icon_notice);
    }

    public SimpleBulletinAdapter(Context context, List<String> dataList, @DrawableRes int imageDrawableID) {
        mDataList = dataList;
        mImageDrawableID = imageDrawableID;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public View getView(int position) {

        View view = layoutInflater.inflate(R.layout.simple_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_image);
        TextView textView = (TextView) view.findViewById(R.id.tv_content);

        String data = mDataList.get(position);
        imageView.setImageResource(mImageDrawableID);
        textView.setText(data);
        return view;
    }

}
