package com.ycz.ad.service.impl;

import com.ycz.ad.constant.Constants;
import com.ycz.ad.dao.AdPlanRepository;
import com.ycz.ad.dao.AdUnitRepository;
import com.ycz.ad.dao.CreativeRepository;
import com.ycz.ad.dao.unit_condition.AdUnitDistrictRepository;
import com.ycz.ad.dao.unit_condition.AdUnitItRepository;
import com.ycz.ad.dao.unit_condition.AdUnitKeywordRepository;
import com.ycz.ad.dao.unit_condition.CreativeUnitRepository;
import com.ycz.ad.entity.AdPlan;
import com.ycz.ad.entity.AdUnit;
import com.ycz.ad.entity.unit_condition.AdUnitDistrict;
import com.ycz.ad.entity.unit_condition.AdUnitIt;
import com.ycz.ad.entity.unit_condition.AdUnitKeyword;
import com.ycz.ad.entity.unit_condition.CreativeUnit;
import com.ycz.ad.exception.AdException;
import com.ycz.ad.service.IAdUnitService;
import com.ycz.ad.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: hyczzz
 * @date: 2019/12/10 0010 22:12
 * @description:
 */
@Service
public class AdUnitServiceImpl implements IAdUnitService {

    private final AdUnitRepository unitRepository;
    private final AdPlanRepository planRepository;
    private final AdUnitKeywordRepository unitKeywordRepository;
    private final AdUnitItRepository unitItRepository;
    private final AdUnitDistrictRepository unitDistrictRepository;
    private final CreativeRepository creativeRepository;
    private final CreativeUnitRepository creativeUnitRepository;


    @Autowired
    public AdUnitServiceImpl(AdUnitRepository unitRepository, AdPlanRepository planRepository, AdUnitItRepository unitItRepository, AdUnitDistrictRepository unitDistrictRepository, AdUnitKeywordRepository unitKeywordRepository, CreativeRepository creativeRepository, CreativeUnitRepository creativeUnitRepository) {
        this.unitRepository = unitRepository;
        this.planRepository = planRepository;
        this.unitItRepository = unitItRepository;
        this.unitDistrictRepository = unitDistrictRepository;
        this.unitKeywordRepository = unitKeywordRepository;
        this.creativeRepository = creativeRepository;
        this.creativeUnitRepository = creativeUnitRepository;
    }

    @Override
    public AdUnitResponse createUnit(AdUnitRequest request) throws AdException {
        if (!request.createValidate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        Optional<AdPlan> adPlan = planRepository.findById(request.getPlanId());
        if (!adPlan.isPresent()){
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        AdUnit oldUnit = unitRepository.findByPlanIdAnAndUnitName(request.getPlanId(), request.getUnitName());
        if (oldUnit != null){
            throw new AdException(Constants.ErrorMsg.SAME_NAME_UNIT_ERROR);
        }
        AdUnit newUnit = unitRepository.save(new AdUnit(request.getPlanId(),request.getUnitName(),request.getPositionType(),request.getBudget()));

        return new AdUnitResponse(newUnit.getId(),request.getUnitName());
    }

    @Override
    public AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException {
        List<Long> unitIds = request.getUnitKeywords().stream()
                .map(AdUnitKeywordRequest.UnitKeyword::getUnitId)
                .collect(Collectors.toList());
        if (!isRelateUnitExist(unitIds)){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<Long> ids = Collections.emptyList();

        List<AdUnitKeyword> unitKeywords = new ArrayList<>();
        if (!CollectionUtils.isEmpty(request.getUnitKeywords())){
            request.getUnitKeywords().forEach(i -> unitKeywords.add(
                    new AdUnitKeyword(i.getUnitId(),i.getKeyword())
            ));
            ids = unitKeywordRepository.saveAll(unitKeywords).stream()
                    .map(AdUnitKeyword::getId).collect(Collectors.toList());
        }

        return new AdUnitKeywordResponse(ids);
    }

    @Override
    public AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException {
        List<Long> unitIds = request.getUnitIts().stream()
                .map(AdUnitItRequest.UnitIt::getUnitId)
                .collect(Collectors.toList());
        if (!isRelateUnitExist(unitIds)){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<AdUnitIt> unitIts = new ArrayList<>();
        request.getUnitIts().forEach(i -> unitIts.add(
                new AdUnitIt(i.getUnitId(),i.getItTag())
        ));

        List<Long> ids = unitItRepository.saveAll(unitIts).stream()
                .map(AdUnitIt::getId).collect(Collectors.toList());

        return new AdUnitItResponse(ids);
    }

    @Override
    public AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException {
        List<Long> unitIds = request.getUnitDistricts().stream()
                .map(AdUnitDistrictRequest.UnitDistrict::getUnitId)
                .collect(Collectors.toList());
        if (!isRelateUnitExist(unitIds)){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<AdUnitDistrict> unitDistricts = new ArrayList<>();
        request.getUnitDistricts().forEach(i -> unitDistricts.add(
                new AdUnitDistrict(i.getUnitId(),i.getProvince(),i.getCity())
        ));
        List<Long> ids = unitDistrictRepository.saveAll(unitDistricts).stream()
                .map(AdUnitDistrict::getId).collect(Collectors.toList());
        return new AdUnitDistrictResponse(ids);
    }

    @Override
    public CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException {
        List<Long> unitIds = request.getUnitItems().stream()
                .map(CreativeUnitRequest.CreativeUnitItem::getUnitId).collect(Collectors.toList());
        List<Long> creativeIds = request.getUnitItems().stream()
                .map(CreativeUnitRequest.CreativeUnitItem::getCreativeId).collect(Collectors.toList());
        if (!(isRelateCreativeExist(creativeIds) && isRelateUnitExist(unitIds))){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<CreativeUnit> creativeUnits = new ArrayList<>();
        request.getUnitItems().forEach(i -> creativeUnits.add(
                new CreativeUnit(i.getCreativeId(),i.getUnitId())
        ));
        List<Long> ids = creativeUnitRepository.saveAll(creativeUnits).stream()
                .map(CreativeUnit::getId).collect(Collectors.toList());
        return new CreativeUnitResponse(ids);
    }

    private boolean isRelateUnitExist(List<Long> unitIds){
        if (CollectionUtils.isEmpty(unitIds)){
            return false;
        }
        return unitRepository.findAllById(unitIds).size() ==
                new HashSet<>(unitIds).size();
    }

    private boolean isRelateCreativeExist(List<Long> creativeIds){
        if (CollectionUtils.isEmpty(creativeIds)){
            return false;
        }
        return creativeRepository.findAllById(creativeIds).size() ==
                new HashSet<>(creativeIds).size();
    }
}
