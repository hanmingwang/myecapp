package com.hmw.lib.ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.hmw.lib.core.app.AccountManager;
import com.hmw.lib.core.app.IUserChecker;
import com.hmw.lib.core.delegates.LatteDelegate;
import com.hmw.lib.core.util.storage.LattePreference;
import com.hmw.lib.core.util.timer.BaseTimerTask;
import com.hmw.lib.core.util.timer.ITimerListener;
import com.hmw.lib.ec.R;
import com.hmw.lib.ui.launcher.ILauncherListener;
import com.hmw.lib.ui.launcher.OnLauncherFinishTag;
import com.hmw.lib.ui.launcher.ScrollLauncherTag;

import java.text.MessageFormat;
import java.util.Timer;


/**
 * Created by han on 2018/6/3.
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    private AppCompatTextView mTvTimer = null;
    private Timer mTimer = null;
    private int mCount = 5;
    private ILauncherListener mILauncherListener = null;

    private void onClickTimerView() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            checkIsShowScroll();
        }
    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener) {
            mILauncherListener = (ILauncherListener) activity;
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        initTimer();
        mTvTimer = $(R.id.tv_launcher_timer);
        $(R.id.tv_launcher_timer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickTimerView();
            }
        });

    }

    //判断是否显示滑动启动页
    private void checkIsShowScroll() {
        if (!LattePreference.getAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name())) {
            getSupportDelegate().start(new LauncherScrollDelegate(), SINGLETASK);
        } else {
            //检查用户是否登录了APP
            AccountManager.checkAccount(new IUserChecker() {
                @Override
                public void onSignIn() {
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                    }
                }

                @Override
                public void onNotSignIn() {
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);
                    }
                }
            });
        }
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                            checkIsShowScroll();
                        }
                    }
                }
            }
        });
    }
}
