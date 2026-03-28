package com.tol.consulta.model.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ConsultaRequest(

        @NotBlank(message = "el código catastral es requerido")
        @Size(max = 100)
        String codCatastral,

        @NotBlank(message = "el tipo de documento es requerido")
        String tipoDocumento,

        @NotBlank(message = "el número de documento es requerido")
        @Size(max = 50)
        String numDocumento
) {
}
