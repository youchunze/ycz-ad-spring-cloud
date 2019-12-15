package com.ycz.ad.service;

import com.ycz.ad.exception.AdException;
import com.ycz.ad.vo.CreateUserRequest;
import com.ycz.ad.vo.CreateUserResponse;

/**
 * @author: hyczzz
 * @date: 2019/12/9 0009 22:28
 * @description:
 */
public interface IUserService {
    /**
     * 创建用户
     */
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
