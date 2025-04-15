package com.mtobdvlb.service;

import com.mtobdvlb.entity.City;
import com.mtobdvlb.entity.Province;

import java.util.List;

public interface CommonService {

    List<Province> getProvinces();

    List<City> getCities(Long provinceId);
}
