package com.ycz.ad.service;

import com.ycz.ad.entity.unit_condition.AdUnitKeyword;
import com.ycz.ad.exception.AdException;
import com.ycz.ad.vo.*;

/**
 * @author: hyczzz
 * @date: 2019/12/10 0010 22:11
 * @description:
 */
public interface IAdUnitService {

    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException;

    AdUnitItResponse  createUnitIt(AdUnitItRequest request) throws AdException;

    AdUnitDistrictResponse  createUnitDistrict(AdUnitDistrictRequest request) throws AdException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException;
}
