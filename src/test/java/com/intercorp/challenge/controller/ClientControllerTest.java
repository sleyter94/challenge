package com.intercorp.challenge.controller;

import com.intercorp.challenge.dto.ClienteDto;
import com.intercorp.challenge.service.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@WebFluxTest(ClientController.class)
public class ClientControllerTest {

  @Autowired
  WebTestClient webTestClient;

  @MockBean
  private ClientService clientService;

  @Test
  public void testGetListClient() {
    ClienteDto cliente = ClienteDto.builder()
            .age(27)
            .firstname("Sleyter")
            .lastname("Sandoval")
            .bornDate(new Date())
            .build();
    Mockito.when(clientService.getClients()).thenReturn(Flux.just(cliente));

    webTestClient.get()
            .uri("/listclientes")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk()
            .expectBody(List.class)
            .value(clienteDto1 -> clienteDto1.size(), equalTo(1));
  }
}
