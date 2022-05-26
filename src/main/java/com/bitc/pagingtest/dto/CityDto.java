package com.bitc.pagingtest.dto;

import lombok.Data;

@Data
public class CityDto {
  private int id;
  private String name;
  private String countryCode;
  private String district;
  private String population;
}
