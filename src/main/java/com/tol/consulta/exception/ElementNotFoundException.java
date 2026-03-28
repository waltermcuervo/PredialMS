package com.tol.consulta.exception;

/**
 * Excepcion para cuándo no se encuentre un elemento
 */
public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String message) {
        super(message);
    }
}
