package com.hmw.lib.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by han on 2018/5/31.
 */

public enum EcIcons implements Icon {
    icon_scan('\ue602'),   //扫描的图标  &#xe602;
    icon_ali_pay('\ue606'); //支付宝的图标  &#xe606;

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
