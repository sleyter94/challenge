package com.intercorp.challenge.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class KpiClientDto implements Serializable {
  private BigDecimal mean;
  private BigDecimal std;

}
