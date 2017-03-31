package me.bakumon.bulletinview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.bakumon.bulletinview.R;
import me.bakumon.bulletinview.entity.SaleEntity;
import me.bakumon.library.adapter.BulletinAdapter;

/**
 * SaleAdapter
 * Created by bakumon on 17-3-31.
 */

public class SaleAdapter extends BulletinAdapter {

    private List<SaleEntity> list;
    private LayoutInflater layoutInflater;

    public SaleAdapter(Context context, List<SaleEntity> list) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(int position) {
        View view = layoutInflater.inflate(R.layout.item_sale, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_sale);
        TextView tVSaleTitle = (TextView) view.findViewById(R.id.tv_sale_title);
        TextView tVSalePrice = (TextView) view.findViewById(R.id.tv_sale_price);
        TextView tVSaleTag = (TextView) view.findViewById(R.id.tv_sale_tag);

        SaleEntity saleEntity = list.get(position);
        imageView.setImageResource(R.mipmap.sale0);
        tVSaleTitle.setText(saleEntity.saleTitle);
        tVSalePrice.setText(saleEntity.salePrice);
        tVSaleTag.setText(saleEntity.saleTag);
        return view;
    }
}
