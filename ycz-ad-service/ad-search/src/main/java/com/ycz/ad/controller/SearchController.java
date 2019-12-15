package com.ycz.ad.controller;

import com.alibaba.fastjson.JSON;
import com.ycz.ad.annotation.IgnoreResponseAdvice;
import com.ycz.ad.client.SponsorClient;
import com.ycz.ad.client.vo.AdPlan;
import com.ycz.ad.client.vo.AdPlanGetRequest;
import com.ycz.ad.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: hyczzz
 * @date: 2019/12/10 0010 23:57
 * @description:
 */
@Slf4j
@RestController
public class SearchController {
    private final RestTemplate restTemplate;
    private final SponsorClient sponsorClient;

    @Autowired
    public SearchController(RestTemplate restTemplate, SponsorClient sponsorClient) {
        this.restTemplate = restTemplate;
        this.sponsorClient = sponsorClient;
    }

    @IgnoreResponseAdvice
    @PostMapping("/getAdPlans")
    public CommonResponse<List<AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request){
        log.info("ad-search: getAdPlans -> {}",
                JSON.toJSONString(request));
        return sponsorClient.getAdPlans(request);
    }

    @SuppressWarnings("all")
    @IgnoreResponseAdvice
    @PostMapping("/getAdPlansByRibbon")
    public CommonResponse<List<AdPlan>> getAdPlansByRibbon(@RequestBody AdPlanGetRequest request){
        log.info("ad-search: getAdPlansByRibbon -> {}",
                JSON.toJSONString(request));
        return restTemplate.postForEntity(
                "http://eureke-client-ad-sponsor/ad-sponsot/get/adPlan",
                request,
                CommonResponse.class).getBody();
    }
}
