package com.ycz.ad.constant;

import lombok.Getter;

/**
 * @author: hyczzz
 * @date: 2019/12/8 0008 23:37
 * @description:
 */
@Getter
@SuppressWarnings("all")
public enum CommonStatus {

    VALID(1,"有效状态"),
    INVALID(2,"无效状态"),;

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
