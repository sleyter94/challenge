package com.intercorp.challenge.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Util {

  private static final Double ESPERANZA_VIDA_HOMBRE = 73.7;
  private static final Double ESPERANZA_VIDA_MUJER = 79.2;

  public static Date getDeathDate(Date bornDate){
    LocalDate localDate = bornDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    localDate = localDate.withYear(localDate.getYear() + (int)(ESPERANZA_VIDA_HOMBRE + Math.random()*(ESPERANZA_VIDA_MUJER - ESPERANZA_VIDA_HOMBRE)))
    .withMonth((int)(12*Math.random()))
    .withDayOfMonth((int)(30*Math.random()));
    return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
  }
}
