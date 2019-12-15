package com.ycz.ad.constant;

import lombok.Getter;

/**
 * @author: hyczzz
 * @date: 2019/12/9 0009 00:00
 * @description:
 */
@Getter
@SuppressWarnings("all")
public enum CreativeType {

    IMAGE(1, "图片"),
    VIDEO(2, "视频"),
    TEXT(3, "文本"),;

    private Integer type;
    private String desc;

    CreativeType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
