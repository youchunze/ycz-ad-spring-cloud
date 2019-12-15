package com.ycz.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * @author: hyczzz
 * @date: 2019/12/9 0009 22:29
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String username;

    public boolean validata(){
        return !StringUtils.isEmpty(username);
    }
}
