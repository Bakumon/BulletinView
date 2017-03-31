package me.bakumon.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import me.bakumon.library.R;
import me.bakumon.library.adapter.BulletinAdapter;

/**
 * BulletinView
 * Created by bakumon on 2017/3/31 15:32.
 */
public class BulletinView extends ViewFlipper implements View.OnClickListener {

    private static final int DEFAULT_INTERVAL = 3000; // 默认轮播间隔 3 秒
    private static final int DEFAULT_ENTER_ANIM = R.anim.bulletin_item_enter; // 默认进入动画 平移加渐变
    private static final int DEFAULT_LEAVE_ANIM = R.anim.bulletin_item_leave; // 默认离开动画 平移加渐变

    private int mBulletinInterval = DEFAULT_INTERVAL;
    private int mBulletinEnterAnim = DEFAULT_ENTER_ANIM;
    private int mBulletinLeaveAnim = DEFAULT_LEAVE_ANIM;

    public BulletinView(Context context) {
        super(context);
        init();
    }

    public BulletinView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BulletinView);
        mBulletinInterval = a.getInt(R.styleable.BulletinView_bulletinInterval, DEFAULT_INTERVAL);
        mBulletinEnterAnim = a.getResourceId(R.styleable.BulletinView_bulletinEnterAnim, DEFAULT_ENTER_ANIM);
        mBulletinLeaveAnim = a.getResourceId(R.styleable.BulletinView_bulletinLeaveAnim, DEFAULT_LEAVE_ANIM);
        a.recycle();
        init();
    }

    private void init() {
        // 设置公告轮播间隔时间
        setFlipInterval(mBulletinInterval);
        // 设置进入和离开动画
        setInAnimation(AnimationUtils.loadAnimation(getContext(), mBulletinEnterAnim));
        setOutAnimation(AnimationUtils.loadAnimation(getContext(), mBulletinLeaveAnim));
    }

    public void setAdapter(BulletinAdapter adapter) {
        if (adapter == null) {
            return;
        }
        for (int i = 0; i < adapter.getCount(); i++) {
            View view = adapter.getView(i);
            view.setTag(i);
            addView(view);
            view.setOnClickListener(this);
        }
        startFlipping();
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        if (mOnBulletinItemClickListener != null) {
            mOnBulletinItemClickListener.onBulletinItemClick(position);
        }
    }

    /**
     * 公告条目点击监听接口
     */
    public interface OnBulletinItemClickListener {
        void onBulletinItemClick(int position);
    }

    private OnBulletinItemClickListener mOnBulletinItemClickListener;

    /**
     * 设置公告条目点击监听器
     *
     * @param onBulletinItemClickListener 公告条目点击监听器
     */
    public void setOnBulletinItemClickListener(OnBulletinItemClickListener onBulletinItemClickListener) {
        mOnBulletinItemClickListener = onBulletinItemClickListener;
    }

}
