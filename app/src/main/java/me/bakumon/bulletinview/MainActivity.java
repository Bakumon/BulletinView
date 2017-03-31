package me.bakumon.bulletinview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.bakumon.library.adapter.SimpleBulletinAdapter;
import me.bakumon.library.view.BulletinView;

public class MainActivity extends AppCompatActivity {

    private BulletinView mBulletinView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }
}
