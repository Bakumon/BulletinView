package me.bakumon.bulletinview.adapter;

import android.content.Context;
import android.view.View;

import java.util.List;

import me.bakumon.bulletinview.R;
import me.bakumon.library.adapter.BulletinAdapter;

/**
 * ProductsAdapter
 * Created by bakumon on 17-3-31.
 */

public class ProductsAdapter extends BulletinAdapter {


    public ProductsAdapter(Context context, List list) {
        super(context, list);
    }


    @Override
    public View getView(int position) {
        View view;
        if (position % 2 == 0) { //
            view = getRootView(R.layout.item_product_first);
        } else {
            view = getRootView(R.layout.item_product_second);
        }
        return view;
    }
}
