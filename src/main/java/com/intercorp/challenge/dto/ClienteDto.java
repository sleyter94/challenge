package com.intercorp.challenge.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class ClienteDto implements Serializable {

  private String firstname;
  private String lastname;
  private String age;
  private Date bornDate;
  private Date deathDate;
}
