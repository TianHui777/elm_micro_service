package com.tianhui.service.Impl;

import com.tianhui.service.BusinessService;
import jakarta.annotation.Resource;
import com.tianhui.mapper.BusinessMapper;
import com.tianhui.po.Business;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusinessServiceImpl implements BusinessService {
    @Resource
    protected BusinessMapper businessMapper;

    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        return businessMapper.listBusinessByOrderTypeId(orderTypeId);
    }
    @Override
    public Business getBusinessById(Integer businessId) {
        return businessMapper.getBusinessById(businessId);
    }
}
