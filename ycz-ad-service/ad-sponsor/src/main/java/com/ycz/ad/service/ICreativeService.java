package com.ycz.ad.service;

import com.ycz.ad.vo.CreativeRequest;
import com.ycz.ad.vo.CreativeResponse;

/**
 * @author: hyczzz
 * @date: 2019/12/10 0010 22:54
 * @description:
 */
public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request);

}
