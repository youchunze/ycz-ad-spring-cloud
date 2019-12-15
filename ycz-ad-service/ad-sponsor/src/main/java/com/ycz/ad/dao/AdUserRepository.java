package com.ycz.ad.dao;

import com.ycz.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: hyczzz
 * @date: 2019/12/9 0009 00:05
 * @description:
 */
public interface AdUserRepository extends JpaRepository<AdUser,Long> {

    /**
     * 根据用户名查找用户记录
     * @param username
     * @return
     */
    AdUser findByUsername(String username);
}
