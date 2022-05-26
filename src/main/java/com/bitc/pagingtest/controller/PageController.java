package com.bitc.pagingtest.controller;

import com.bitc.pagingtest.dto.CityDto;
import com.bitc.pagingtest.service.PageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PageController {
  @Autowired
  private PageService pageService;

  @RequestMapping("/")
  public String index() throws Exception {
    return "index";
  }

  @RequestMapping("/city")
  public ModelAndView openCityList() throws Exception {
    ModelAndView mv = new ModelAndView("city/cityList");

    List<CityDto> cityList = pageService.getCityList();
    mv.addObject("cityList", cityList);

    return mv;
  }

//  required = false : 클라이언트가 서버로 데이터 요청 시 지정된 매개변수를 입력하지 않아도 상관없음
//  defaultValue : 기본값
  @RequestMapping("/cityPaging")
  public ModelAndView openCityListPage(@RequestParam(required = false, defaultValue = "1") int pageNum) throws Exception {
    ModelAndView mv = new ModelAndView("city/cityListPage");

    PageInfo<CityDto> cityListPage = new PageInfo<>(pageService.getCityListPage(pageNum), 10);
    mv.addObject("cityList", cityListPage);

    return mv;
  }
//  PageInfo 클래스를 사용하여 페이징을 구현함
//  PageInfo의 내용
//  int pageNum : 현재 페이지 번호
//  int pageSize : 페이지당 수량
//  int size : 현재 페이지 수
//  long startRow : 현재 페이지의 첫번째 요소가 데이터베이스에 있는 줄 번호
//  long endRow : 현재 페이지의 마지막 요소가 데이터베이스에 있는 줄 번호
//  int pages : 전체 페이지 수
//  int prePage : 이전 페이지
//  int nextPage : 다음 페이지
//  boolean isFirstPage = false : 첫 페이지 여부
//  boolean isLastPage = false : 마지막 페이지 여부
//  boolean hasPreviousPage = false : 이전 페이지가 존재하는지 여부
//  boolean hasNextPage = false : 다음 페이지가 존재하는지 여부
//  int navigatePages : 내비게이션바에 표현할 페이지 수
//  int[] navigatepateNums : 모든 내비게이션 페이지 번호
//  int navigateFirstPage : 내비게이션의 첫 페이지
//  int navigateLastPage : 내비게이션의 마지막 페이지
//  list : DB에서 넘어온 데이터 리스트
}
