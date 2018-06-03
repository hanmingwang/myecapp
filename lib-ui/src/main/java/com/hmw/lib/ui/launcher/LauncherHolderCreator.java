package com.hmw.lib.ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Created by han on 2018/6/3.
 */

public class LauncherHolderCreator implements CBViewHolderCreator<LauncherHolder> {

    @Override
    public LauncherHolder createHolder() {
        return new LauncherHolder();
    }
}
