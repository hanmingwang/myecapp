package com.hmw.lib.ec.main;

import android.graphics.Color;

import com.hmw.lib.core.delegates.bottom.BaseBottomDelegate;
import com.hmw.lib.core.delegates.bottom.BottomItemDelegate;
import com.hmw.lib.core.delegates.bottom.BottomTabBean;
import com.hmw.lib.core.delegates.bottom.ItemBuilder;
import com.hmw.lib.ec.main.index.IndexDelegate;

import java.util.LinkedHashMap;

/**
 * Created by han on 2018/6/3.
 */

public class EcBottomDelegate extends BaseBottomDelegate {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
//        items.put(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
//        items.put(new BottomTabBean("{fa-compass}", "发现"), new DiscoverDelegate());
//        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new ShopCartDelegate());
//        items.put(new BottomTabBean("{fa-user}", "我的"), new PersonalDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
