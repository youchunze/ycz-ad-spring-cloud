package com.ycz.ad.client;

import com.ycz.ad.client.vo.AdPlan;
import com.ycz.ad.client.vo.AdPlanGetRequest;
import com.ycz.ad.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: hyczzz
 * @date: 2019/12/11 0011 00:13
 * @description:    断路器
 */
@Component
public class SponsorClientHystrix implements SponsorClient {
    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1,
                "eureke-client-ad-sponsor error");
    }
}
