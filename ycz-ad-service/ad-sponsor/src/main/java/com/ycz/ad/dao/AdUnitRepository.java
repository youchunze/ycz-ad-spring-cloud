package com.ycz.ad.dao;

import com.ycz.ad.entity.AdUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: hyczzz
 * @date: 2019/12/9 0009 00:14
 * @description:
 */
public interface AdUnitRepository extends JpaRepository<AdUnit,Long> {

    AdUnit findByPlanIdAnAndUnitName(Long planId,String unitName);

    List<AdUnit> findAllByUnitStatus(Integer status);
}
