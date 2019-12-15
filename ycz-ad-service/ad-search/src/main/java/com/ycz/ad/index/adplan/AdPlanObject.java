package com.ycz.ad.index.adplan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: hyczzz
 * @date: 2019/12/15 0015 19:48
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanObject   {

    private Long planId;
    private Long userId;
    private Integer planStatus;
    private Date startDate;
    private Date endDate;

    public void update(AdPlanObject newObject){
        if (null != newObject.getPlanId()){
            this.planId = planId;
        }
        if (null != newObject.getUserId()){
            this.userId = userId;
        }
        if (null != newObject.getPlanStatus()){
            this.planStatus = planStatus;
        }
        if (null != newObject.getStartDate()){
            this.startDate = startDate;
        }
        if (null != newObject.getEndDate()){
            this.endDate = endDate;
        }
    }
}
