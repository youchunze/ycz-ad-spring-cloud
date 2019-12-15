package com.ycz.ad.constant;

import lombok.Getter;

/**
 * @author: hyczzz
 * @date: 2019/12/9 0009 00:02
 * @description:
 */
@Getter
@SuppressWarnings("all")
public enum CreativeMetrialType {

    JPG(1, "jpg"),
    BMP(2, "bmp"),

    MP4(3, "mp4"),
    AVI(4, "avi"),

    TXT(5, "txt"),;

    private Integer type;
    private String desc;

    CreativeMetrialType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
