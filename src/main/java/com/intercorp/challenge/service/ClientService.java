package com.intercorp.challenge.service;

import com.intercorp.challenge.dto.ClienteDto;
import com.intercorp.challenge.dto.KpiClientDto;
import com.intercorp.challenge.model.Client;
import com.intercorp.challenge.repository.ClienteRepository;
import com.intercorp.challenge.util.Util;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClientService implements IClienteService {

  private final ClienteRepository clienteRepository;

  public ClientService(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  @Override
  public Mono<ClienteDto> createClient(ClienteDto clienteDto) {
    Client client = Client.builder()
            .firstname(clienteDto.getFirstname())
            .lastname(clienteDto.getLastname())
            .age(clienteDto.getAge())
            .bornDate(clienteDto.getBornDate())
            .deathDate(Util.getDeathDate(clienteDto.getBornDate()))
            .build();
    this.clienteRepository.save(client);
    return Mono.just(clienteDto).map(cli -> {
      cli.setDeathDate(client.getDeathDate());
      return cli;
    });

  }

  @Override
  public Mono<KpiClientDto> getKpiClients() {
    List<Client> clients = this.clienteRepository.findAll();
    double mean = clients.stream()
            .mapToInt(Client::getAge)
            .average()
            .orElse(0);
    double std = clients.stream()
            .mapToDouble(Client::getAge)
            .reduce(0, (sub, ele) -> sub + Math.pow(mean - ele, 2)/clients.size());
    return Mono.just(KpiClientDto.builder()
            .mean(BigDecimal.valueOf(mean))
            .std(BigDecimal.valueOf(Math.sqrt(std)))
            .build())
    ;
  }

  @Override
  public Flux<ClienteDto> getClients() {
    return Flux.fromIterable(this.clienteRepository.findAll())
            .map(client -> ClienteDto.builder()
                    .age(client.getAge())
                    .firstname(client.getFirstname())
                    .lastname(client.getLastname())
                    .bornDate(client.getBornDate())
                    .deathDate(client.getDeathDate())
                    .build()
            );
  }
}
