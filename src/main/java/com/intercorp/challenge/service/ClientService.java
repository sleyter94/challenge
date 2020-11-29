package com.intercorp.challenge.service;

import com.intercorp.challenge.dto.ClienteDto;
import com.intercorp.challenge.dto.KpiClientDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientService implements IClienteService {

  @Override
  public Mono<ClienteDto> createClient(ClienteDto clienteDto) {

    return null;
  }

  @Override
  public Mono<KpiClientDto> getKpiClients() {
    return null;
  }

  @Override
  public Flux<ClienteDto> getClients() {
    return null;
  }
}
