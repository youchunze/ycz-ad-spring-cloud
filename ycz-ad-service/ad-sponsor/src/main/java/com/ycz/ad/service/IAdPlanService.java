package com.ycz.ad.service;

import com.ycz.ad.entity.AdPlan;
import com.ycz.ad.exception.AdException;
import com.ycz.ad.vo.AdPlanGetRequest;
import com.ycz.ad.vo.AdPlanRequest;
import com.ycz.ad.vo.AdPlanResponse;

import java.util.List;

/**
 * @author: hyczzz
 * @date: 2019/12/9 0009 22:54
 * @description:
 */
public interface IAdPlanService  {

    /**
     * 创建推广计划
     */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 获取推广计划
     */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * 更新推广计划
     */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 删除推广计划
     */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
