package com.tol.consulta.exception;

import com.tol.consulta.model.dto.RespuestaExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador de excepciones globales
 */
@Slf4j
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<RespuestaExceptionDto> notFoundHandler(ElementNotFoundException ex, HttpServletRequest request){
        RespuestaExceptionDto resp = RespuestaExceptionDto.builder().
                mensaje(this.filtrarMensaje(ex.getMessage())).
                esError(Boolean.TRUE).
                hora(LocalDateTime.now()).
                uri(request.getRequestURI()).build();
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<RespuestaExceptionDto> invalidDataHandler(InvalidDataException ex, HttpServletRequest request){
        RespuestaExceptionDto resp = RespuestaExceptionDto.builder().mensaje(ex.getMessage()).esError(Boolean.TRUE).hora(LocalDateTime.now()).uri(request.getRequestURI()).build();
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> invalidDataHandler(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, String> erroresCampos = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                erroresCampos.put(error.getField(), error.getDefaultMessage())
        );

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("codigo", "ERROR_VALIDACION");
        respuesta.put("esError", Boolean.TRUE);
        respuesta.put("mensaje", "Datos de entrada incorrectos");
        respuesta.put("detalles", erroresCampos); // Aquí van tus @NotBlank
        respuesta.put("hora", LocalDateTime.now());

        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    private String filtrarMensaje(String msm){
        if(msm == null){
            return "Error interno del servidor";
        }

        Integer inicio = msm.indexOf("ORA-20");
         msm = msm.substring(inicio+11);
        Integer fin = msm.indexOf("ORA-");
        msm = msm.substring(0, fin);

        return msm.replace("\n", "");
    }

}
