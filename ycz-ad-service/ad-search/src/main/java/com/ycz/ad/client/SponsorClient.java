package com.ycz.ad.client;

import com.ycz.ad.client.vo.AdPlan;
import com.ycz.ad.client.vo.AdPlanGetRequest;
import com.ycz.ad.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author: hyczzz
 * @date: 2019/12/11 0011 00:06
 * @description:
 */
@FeignClient(value = "eureke-client-ad-sponsor",fallback = SponsorClientHystrix.class)
public interface SponsorClient {

    @RequestMapping(value = "/ad-sponsor/get/adPlan",method = RequestMethod.POST)
    CommonResponse<List<AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request);
}
