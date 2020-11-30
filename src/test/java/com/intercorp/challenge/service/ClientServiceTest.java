package com.intercorp.challenge.service;

import com.intercorp.challenge.controller.ClientController;
import com.intercorp.challenge.dto.ClienteDto;
import com.intercorp.challenge.model.Client;
import com.intercorp.challenge.repository.ClienteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.test.StepVerifier;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

  @Mock
  ClienteRepository repository;

  @InjectMocks
  private ClientService clienteService;

  @Test
  public void saveClientReturnUser() {

    ClienteDto clientDto = ClienteDto.builder()
            .firstname("Sleyter")
            .lastname("Sandoval")
            .age(27)
            .bornDate(new Date())
            .build();

    StepVerifier.create(clienteService.createClient(clientDto).log()).expectNext(clientDto)
    .verifyComplete();
  }


}
