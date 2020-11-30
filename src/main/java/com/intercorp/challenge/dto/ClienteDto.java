package com.intercorp.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ClienteDto implements Serializable {

  private String firstname;
  private String lastname;
  private Integer age;
  private Date bornDate;
  private Date deathDate;
}
