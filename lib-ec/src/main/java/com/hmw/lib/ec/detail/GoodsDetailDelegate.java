package com.hmw.lib.ec.detail;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.hmw.lib.core.delegates.LatteDelegate;

/**
 * Created by 傅令杰
 */

public class GoodsDetailDelegate extends LatteDelegate {


    @Override
    public Object setLayout() {
        return null;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public static GoodsDetailDelegate create(int goodsId) {
        return null;
    }

}
