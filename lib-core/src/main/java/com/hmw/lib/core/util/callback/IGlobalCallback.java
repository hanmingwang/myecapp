package com.hmw.lib.core.util.callback;

import android.support.annotation.Nullable;

/**
 * Created by han on 2018/5/31.
 */

public interface IGlobalCallback<T> {

    void executeCallback(@Nullable T args);
}
