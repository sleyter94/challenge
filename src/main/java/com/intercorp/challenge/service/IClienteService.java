package com.intercorp.challenge.service;

import com.intercorp.challenge.dto.ClienteDto;
import com.intercorp.challenge.dto.KpiClientDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClienteService {
  Mono<ClienteDto> createClient(ClienteDto clienteDto);

  Mono<KpiClientDto> getKpiClients();

  Flux<ClienteDto> getClients();
}
