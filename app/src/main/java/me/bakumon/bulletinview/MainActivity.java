package me.bakumon.bulletinview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.bakumon.bulletinview.adapter.ProductsAdapter;
import me.bakumon.bulletinview.adapter.SaleAdapter;
import me.bakumon.bulletinview.entity.SaleEntity;
import me.bakumon.library.adapter.SimpleBulletinAdapter;
import me.bakumon.library.view.BulletinView;

public class MainActivity extends AppCompatActivity {

    private BulletinView mBulletinView;
    private BulletinView mBulletinViewSale;
    private BulletinView mBulletinViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///////////////////////////////
        // 普通公告
        ///////////////////////////////
        mBulletinView = (BulletinView) findViewById(R.id.bulletin_view);
        List<String> list = new ArrayList<>();
        list.add("智能数码手表12期免息！");
        list.add("领券家电立减800");
        mBulletinView.setAdapter(new SimpleBulletinAdapter(this, list));

        mBulletinView.setOnBulletinItemClickListener(new BulletinView.OnBulletinItemClickListener() {
            @Override
            public void onBulletinItemClick(int position) {
                Toast.makeText(MainActivity.this, "click:" + position, Toast.LENGTH_SHORT).show();
            }
        });

        ///////////////////////////////
        // 复杂公告
        ///////////////////////////////
        mBulletinViewSale = (BulletinView) findViewById(R.id.bulletin_view_sale);
        final List<SaleEntity> saleEntities = new ArrayList<>();

        SaleEntity saleEntity = new SaleEntity();
        saleEntity.saleTitle = "花少爷的粥全场优惠券";
        saleEntity.salePrice = "10元";
        saleEntity.saleTag = "新人专享";
        saleEntity.saleImgRes = R.mipmap.sale0;

        SaleEntity saleEntity1 = new SaleEntity();
        saleEntity1.saleTitle = "豪客来全场代金券";
        saleEntity1.salePrice = "16元";
        saleEntity1.saleTag = "再减8元";
        saleEntity1.saleImgRes = R.mipmap.sale0;

        saleEntities.add(saleEntity);
        saleEntities.add(saleEntity1);

        mBulletinViewSale.setAdapter(new SaleAdapter(this, saleEntities));
        mBulletinViewSale.setOnBulletinItemClickListener(new BulletinView.OnBulletinItemClickListener() {
            @Override
            public void onBulletinItemClick(int position) {
                Toast.makeText(MainActivity.this, saleEntities.get(position).saleTitle, Toast.LENGTH_SHORT).show();
            }
        });

        ///////////////////////////////
        // 商品展示
        ///////////////////////////////
        mBulletinViewProduct = (BulletinView) findViewById(R.id.bulletin_view_product);
        mBulletinViewProduct.setAdapter(new ProductsAdapter(this, null));
    }
}
