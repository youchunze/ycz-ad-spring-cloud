package com.ycz.ad.service.impl;

import com.ycz.ad.dao.CreativeRepository;
import com.ycz.ad.entity.Creative;
import com.ycz.ad.service.ICreativeService;
import com.ycz.ad.vo.CreativeRequest;
import com.ycz.ad.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hyczzz
 * @date: 2019/12/10 0010 22:58
 * @description:
 */
@Service
public class CreativeServiceImpl implements ICreativeService{

    @Autowired
    private CreativeRepository creativeRepository;

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {
        Creative creative = creativeRepository.save(request.convertToEntity());
        return new CreativeResponse(creative.getId(),creative.getName());
    }
}
