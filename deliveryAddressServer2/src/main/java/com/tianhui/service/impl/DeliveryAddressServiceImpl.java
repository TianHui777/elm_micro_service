package com.tianhui.service.impl;


import com.tianhui.mapper.DeliveryAddressMapper;
import com.tianhui.service.DeliveryAddressService;
import com.tianhui.po.DeliveryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {//注意这里要有service的标签才能自动装盘
    @Autowired
    private DeliveryAddressMapper deliveryAddressMapper;

    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        return deliveryAddressMapper.listDeliveryAddressByUserId(userId);
    }

    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        return deliveryAddressMapper.getDeliveryAddressById(daId);
    }

    @Override
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        return deliveryAddressMapper.saveDeliveryAddress(deliveryAddress);
    }

    @Override
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        return deliveryAddressMapper.updateDeliveryAddress(deliveryAddress);
    }

    @Override
    public int removeDeliveryAddress(Integer daId) {
        return deliveryAddressMapper.removeDeliveryAddress(daId);
    }
}
