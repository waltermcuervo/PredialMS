package com.tol.consulta.exception;

/**
 * Excepcoin para cuando un dato no sea valido
 */
public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
}
