package com.tol.consulta.controller;

import com.tol.consulta.model.records.ConsultaRequest;
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

/**
 * Controlador REST que expone los servicios de catastro.
 */
@RequiredArgsConstructor
@RequestMapping("catastro")
@RestController
public class CatastroController {

    private final ICuentaPredialService predialService;

    /**
     * Obtiene el estado de una cuenta predial a partir de los datos del contribuyente y predio.
     *
     * @param res Datos requeridos para la consulta (código catastral y documento).
     * @return Detalles de la cuenta predial y su estado actual.
     */
    @GetMapping(value = "/consultar-cuenta")
    public ResponseEntity<ConsultaResponse> consultarEstadoCuenta(@RequestBody @Valid ConsultaRequest res){

        return new ResponseEntity<>(predialService.consultarEstadoPredial(res), HttpStatus.OK);
    }

}
