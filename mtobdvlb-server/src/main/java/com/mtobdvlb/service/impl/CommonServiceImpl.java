package com.mtobdvlb.service.impl;

import com.mtobdvlb.constant.MessageConstant;
import com.mtobdvlb.entity.City;
import com.mtobdvlb.entity.Province;
import com.mtobdvlb.exception.CitiesException;
import com.mtobdvlb.mapper.CommonMapper;
import com.mtobdvlb.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonMapper commonMapper;

    @Override
    public List<Province> getProvinces() {
        List<Province> provinces = commonMapper.getProvinces();
        return provinces;
    }

    @Override
    public List<City> getCities(Long provinceId) {
        List<City> cities = commonMapper.getCities(provinceId);
        if(cities == null || cities.size() == 0) {
            throw new CitiesException(MessageConstant.UNKNOWN_ERROR);
        }
        return cities;
    }
}
