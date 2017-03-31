package me.bakumon.library.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

/**
 * 简单的适配器，提供 View
 * Created by bakumon on 17-3-31.
 */
public abstract class BulletinAdapter<T> {

    protected LayoutInflater mLayoutInflater;
    protected List<T> mData;

    public BulletinAdapter(Context context, List<T> list) {
        this.mData = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    /**
     * 提供数据的大小
     *
     * @return 数据的大小
     */
    public int getCount() {
        return mData.size();
    }

    /**
     * 提供具体的 View
     *
     * @param position view 所在的索引
     * @return 具体的 View
     */
    public abstract View getView(int position);
}
