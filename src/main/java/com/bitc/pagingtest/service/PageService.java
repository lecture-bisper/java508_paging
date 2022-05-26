package com.bitc.pagingtest.service;

import com.bitc.pagingtest.dto.CityDto;
import com.github.pagehelper.Page;

import java.util.List;

public interface PageService {
  List<CityDto> getCityList() throws Exception;

  Page<CityDto> getCityListPage(int pageNum) throws Exception;
}
