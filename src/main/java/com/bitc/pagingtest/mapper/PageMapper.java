package com.bitc.pagingtest.mapper;

import com.bitc.pagingtest.dto.CityDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PageMapper {
  List<CityDto> getCityList() throws Exception;

  Page<CityDto> getCityListPage() throws Exception;
}
