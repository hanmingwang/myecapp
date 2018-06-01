package com.hmw.lib.core.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.hmw.lib.core.app.Latte;


/**
 * Created by han on 2018/5/31.
 */

public final class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
