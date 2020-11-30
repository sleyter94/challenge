package com.intercorp.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@SpringBootApplication
@EnableSwagger2
public class ChallengeApplication {

  public static void main(String[] args) {
    SpringApplication.run(ChallengeApplication.class, args);
  }

}
