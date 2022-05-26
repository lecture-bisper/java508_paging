package com.bitc.pagingtest.service;

import com.bitc.pagingtest.dto.CityDto;
import com.bitc.pagingtest.mapper.PageMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {

  @Autowired
  private PageMapper pageMapper;

  @Override
  public List<CityDto> getCityList() throws Exception {
    return pageMapper.getCityList();
  }

  @Override
  public Page<CityDto> getCityListPage(int pageNum) throws Exception {
//    첫번째 매개변수를 현재 페이지 번호 설정
//    2번째 매개변수는 하나의 화면에 출력할 데이터의 수 설정
    PageHelper.startPage(pageNum, 20);
    return pageMapper.getCityListPage();
  }
}
