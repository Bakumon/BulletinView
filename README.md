# BulletinView

[ ![Download](https://api.bintray.com/packages/bakumon/maven/bulletinview/images/download.svg) ](https://bintray.com/bakumon/maven/bulletinview/_latestVersion)

:camel: 万能的公告栏轮播 View，也可用于商品个性垂直轮播展示

## 预览图

![BulletinView.gif](https://github.com/Bakumon/BulletinView/raw/master/art/BulletinView.gif)

**Demo 下载体验**

<img src="https://github.com/Bakumon/BulletinView/raw/master/art/QR_code_BulletinView.png" width=120 height=120>

[去蒲公英下载](https://www.pgyer.com/BulletinView)

## 使用

### 下载

```
compile 'me.bakumon:bulletinview:1.0.0'
```

### 自定义属性

|属性|描述|类型|
|---|---|---|
|bulletinInterval|轮播间隔时间|毫秒，默认 3000|
|bulletinEnterAnim|公告进入动画|动画资源 ID，默认渐入平移|
|bulletinLeaveAnim|公告离开动画|动画资源 ID，默认渐出平移|

### XML

```xml
<me.bakumon.library.view.BulletinView
    android:id="@+id/bulletin_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:bulletinEnterAnim="@anim/bulletin_item_enter"
    app:bulletinLeaveAnim="@anim/bulletin_item_leave"
    app:bulletinInterval="3000" />
```

### 普通公告

效果图的第一种样式

默认提供了 `SimpleBulletinAdapter` 适配器。

```java
mBulletinView = (BulletinView) findViewById(R.id.bulletin_view);
List<String> list = new ArrayList<>();
list.add("智能数码手表12期免息！");
list.add("领券家电立减800");
mBulletinView.setAdapter(new SimpleBulletinAdapter(this, list));
```

### 复杂公告

效果图的第二种样式

需要创建适配器继承自 `BulletinAdapter<T>`

```java
public class SaleAdapter extends BulletinAdapter<SaleEntity> {

    public SaleAdapter(Context context, List<SaleEntity> data) {
        super(context, data);
    }

    @Override
    public View getView(int position) {
        // 获取 item 根 view
        View view = getRootView(R.layout.item_sale);
        // 实例化子 View
        TextView tVSaleTitle = (TextView) view.findViewById(R.id.tv_sale_title);
        // 获取当前 bean
        SaleEntity saleEntity = mData.get(position);
        // 设置 view 显示的值
        tVSaleTitle.setText(saleEntity.saleTitle);

        return view;
    }
}
```

给 BulletinView 设置自定义的 Adapter 即可。

```java
mBulletinViewSale = (BulletinView) findViewById(R.id.bulletin_view_sale)
List<SaleEntity> saleEntities = new ArrayList<>();

// ...
// 省略 new 对象操作

saleEntities.add(saleEntity);
saleEntities.add(saleEntity1);
mBulletinViewSale.setAdapter(new SaleAdapter(this, saleEntities));
```

### 设置点击事件监听

```java
mBulletinView.setOnBulletinItemClickListener(new BulletinView.OnBulletinItemClickListener() {
    @Override
    public void onBulletinItemClick(int position) {
        Toast.makeText(MainActivity.this, "click:" + position, Toast.LENGTH_SHORT).show();
    }
});
````

## 关于我

E-mail：bakumon@aliyun.com

个人博客: [https://www.bakumon.me/](https://www.bakumon.me/)

Github: [https://github.com/Bakumon](https://github.com/Bakumon)


## License
```
Copyright 2017 bakumon@aliyun.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```