package me.bakumon.library.adapter;

import android.view.View;

/**
 * 简单的适配器，提供 View
 * Created by bakumon on 17-3-31.
 */
public abstract class BulletinAdapter {
    /**
     * 提供数据的大小
     *
     * @return 数据的大小
     */
    public abstract int getCount();

    /**
     * 提供具体的 View
     *
     * @param position view 所在的索引
     * @return 具体的 View
     */
    public abstract View getView(int position);
}
