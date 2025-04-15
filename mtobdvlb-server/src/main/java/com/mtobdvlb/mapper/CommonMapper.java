package com.mtobdvlb.mapper;

import com.mtobdvlb.entity.City;
import com.mtobdvlb.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommonMapper {

    @Select("select * from province")
    List<Province> getProvinces();

    @Select("select * from city where province_id = #{provinceId}")
    List<City> getCities(Long provinceId);

}
