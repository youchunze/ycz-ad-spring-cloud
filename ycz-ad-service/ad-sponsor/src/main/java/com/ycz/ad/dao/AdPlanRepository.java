package com.ycz.ad.dao;

import com.ycz.ad.entity.AdPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: hyczzz
 * @date: 2019/12/9 0009 00:10
 * @description:
 */
public interface AdPlanRepository extends JpaRepository<AdPlan,Long>{

    AdPlan findByIdAndUserId(Long id,Long userId);

    List<AdPlan> findAllByIdAndUserId(List<Long> ids, Long userId);

    AdPlan findByUserIdAndPlanName(Long userId,String planName);

    List<AdPlan> findAllByPlanStatus(Integer status);
}
