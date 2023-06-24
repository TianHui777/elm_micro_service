package com.tianhui.controller;


import com.tianhui.po.CommonResult;
import com.tianhui.po.DeliveryAddress;
import com.tianhui.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RefreshScope
@RestController
@RequestMapping("/DeliveryAddress")
public class DeliveryAddressController {
    @Autowired
    private DeliveryAddressService deliveryAddressService;

    /**
     * 查询
     * @param deliveryAddress
     * @return
     * @throws Exception
     */
    @GetMapping("/UserId")
    public CommonResult<List> listDeliveryAddressByUserId(DeliveryAddress deliveryAddress)
            throws Exception {
        return new CommonResult<List>(200, "success",
                deliveryAddressService.listDeliveryAddressByUserId(deliveryAddress.getUserId()));
    }

    /**
     * 查询
     * @param deliveryAddress
     * @return
     * @throws Exception
     */
    @GetMapping("/DaId")
    public CommonResult<DeliveryAddress> getDeliveryAddressById(DeliveryAddress deliveryAddress) throws
            Exception {
        return new CommonResult<DeliveryAddress>(200, "success",
                deliveryAddressService.getDeliveryAddressById(deliveryAddress.getDaId()));
    }

    /**
     * 保存地址
     * @param deliveryAddress
     * @return
     * @throws Exception
     */
    @PostMapping("/DaId")
    public CommonResult<Integer> saveDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        return new CommonResult<Integer>(200, "success",
                deliveryAddressService.saveDeliveryAddress(deliveryAddress));
    }

    /**
     * 修改
     * @param deliveryAddress
     * @return
     * @throws Exception
     */
    @PutMapping("/DaId")
    public CommonResult<Integer> updateDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        return new CommonResult<Integer>(200, "success",
                deliveryAddressService.updateDeliveryAddress(deliveryAddress));
    }

    /**
     * 删除
     * @param deliveryAddress
     * @return
     * @throws Exception
     */
    @DeleteMapping("/DaId")
    public CommonResult<Integer> removeDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception {
        return new CommonResult<Integer>(200, "success",
                deliveryAddressService.removeDeliveryAddress(deliveryAddress.getDaId()));
    }
}