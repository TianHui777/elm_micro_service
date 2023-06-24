package com.tianhui.mapper;




import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.tianhui.po.Business;

import java.util.List;


@Mapper
public interface BusinessMapper {
    @Select("select * from business where orderTypeId=#{orderTypeId} order by businessId")
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    @Select("select * from business where businessId=#{businessId}")
    public Business getBusinessById(Integer businessId);
}

