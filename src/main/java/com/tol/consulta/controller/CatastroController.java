package com.tol.consulta.controller;

import com.tol.consulta.model.records.ConsultaRequest;
import com.tol.consulta.model.dto.ConsultaResponseDto;
import com.tol.consulta.model.records.ConsultaResponse;
import com.tol.consulta.service.implementation.ICuentaPredialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("catastro")
@RestController
public class CatastroController {

    private final ICuentaPredialService predialService;

    @GetMapping(value = "/consultar-cuenta")
    public ResponseEntity<ConsultaResponse> consultarEstadoCuenta(@RequestBody @Valid ConsultaRequest res){

        return new ResponseEntity<>(predialService.consultarEstadoPredial(res), HttpStatus.OK);
    }

}
