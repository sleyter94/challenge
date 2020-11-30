package com.intercorp.challenge.controller;

import com.intercorp.challenge.dto.ClienteDto;
import com.intercorp.challenge.dto.KpiClientDto;
import com.intercorp.challenge.service.IClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@Api(tags = "Cliente")
public class ClientController {

  private final IClienteService clienteService;

  public ClientController(IClienteService clienteService) {
    this.clienteService = clienteService;
  }

  @ApiOperation(value = "Registra un cliente")
  @ApiResponses({@ApiResponse(code = 200, message = "Cliente Creado")})
  @PostMapping(value = "/creacliente", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ClienteDto> createClient(@RequestBody ClienteDto clienteDto) {
    log.debug("Inicio createClient - request {}", clienteDto);
    return clienteService.createClient(clienteDto)
            .doOnTerminate(() -> log.debug("Fin createClient"));
  }

  @ApiOperation(value = "Obtiene los kpi de los clientes")
  @ApiResponses({@ApiResponse(code = 200, message = "KPI de Clientes")})
  @GetMapping(value = "/kpideclientes")
  public Mono<KpiClientDto> getKpiClients(){
    log.debug("Inicio getKpiClients - request");
    return clienteService.getKpiClients()
            .doOnTerminate(() -> log.debug("Fin getKpiClients"));
  }

  @ApiOperation(value = "Lista los clientes")
  @ApiResponses({@ApiResponse(code = 200, message = "Listado de clientes")})
  @GetMapping(value = "/listclientes")
  public Flux<ClienteDto> getClients() {
    log.debug("Inicio getClients - request");
    return clienteService.getClients()
            .doOnTerminate(() -> log.debug("Fin getClients"));
  }

}
