package com.intercorp.challenge.controller;

import com.intercorp.challenge.dto.ClienteDto;
import com.intercorp.challenge.dto.KpiClientDto;
import com.intercorp.challenge.service.IClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class ClientController {

  private final IClienteService clienteService;

  public ClientController(IClienteService clienteService) {
    this.clienteService = clienteService;
  }

  @PostMapping(value = "/creacliente")
  public Mono<ClienteDto> createClient(@RequestBody ClienteDto clienteDto) {
    log.debug("Inicio createClient - request {}", clienteDto);
    return clienteService.createClient(clienteDto)
            .doOnTerminate(() -> log.debug("Fin createClient"));
  }

  @GetMapping(value = "/kpideclientes")
  public Mono<KpiClientDto> getKpiClients(){
    log.debug("Inicio getKpiClients - request");
    return clienteService.getKpiClients()
            .doOnTerminate(() -> log.debug("Fin getKpiClients"));
  }

  @GetMapping(value = "/listclientes")
  public Flux<ClienteDto> getClients() {
    log.debug("Inicio getClients - request");
    return clienteService.getClients()
            .doOnTerminate(() -> log.debug("Fin getClients"));
  }

}
