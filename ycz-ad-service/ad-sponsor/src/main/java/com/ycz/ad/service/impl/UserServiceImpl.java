package com.ycz.ad.service.impl;

import com.ycz.ad.constant.Constants;
import com.ycz.ad.dao.AdUserRepository;
import com.ycz.ad.entity.AdUser;
import com.ycz.ad.exception.AdException;
import com.ycz.ad.service.IUserService;
import com.ycz.ad.utils.CommonUtils;
import com.ycz.ad.vo.CreateUserRequest;
import com.ycz.ad.vo.CreateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: hyczzz
 * @date: 2019/12/9 0009 22:33
 * @description:
 */
@Service
public class UserServiceImpl implements IUserService {

    private final AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws Exception {

        if (!request.validata()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        AdUser oldUser = userRepository.findByUsername(request.getUsername());
        if (oldUser != null){
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }
        AdUser newUser = userRepository.save(new AdUser(request.getUsername(),
                CommonUtils.md5(request.getUsername())));
        return new CreateUserResponse(newUser.getId(),newUser.getUsername(),newUser.getToken(),
                newUser.getCreateTime(),newUser.getUpdateTime());
    }
}
