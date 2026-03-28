package com.tol.consulta.model.enums;

import lombok.Getter;

/**
 * Enumerado del estado de la cuenta de un contribuyente
 */
@Getter
public enum EstadoEnum {

    AL_DIA ("al día"),
    EN_MORA ("en mora");

    String nombre;

    EstadoEnum(String nombre) {
        this.nombre = nombre;
    }
}
