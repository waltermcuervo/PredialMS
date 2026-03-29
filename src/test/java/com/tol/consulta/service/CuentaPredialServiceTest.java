package com.tol.consulta.service;

import com.tol.consulta.exception.ElementNotFoundException;
import com.tol.consulta.model.records.ConsultaRequest;
import com.tol.consulta.model.records.ConsultaResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.StoredProcedureQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CuentaPredialServiceTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private StoredProcedureQuery query;

    @InjectMocks
    private CuentaPredialService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void consultarEstadoPredialExitoso() {
        ConsultaRequest request = new ConsultaRequest("01-01", "123", "CC");

        when(entityManager.createStoredProcedureQuery(anyString())).thenReturn(query);

        when(query.getOutputParameterValue("P_NOMBRE")).thenReturn("WALTER");
        when(query.getOutputParameterValue("P_VALOR_DEUDA")).thenReturn(new BigDecimal("150000.50"));
        when(query.getOutputParameterValue("P_ESTADO")).thenReturn("AL_DIA");

        ConsultaResponse response = service.consultarEstadoPredial(request);

        assertNotNull(response);
        assertEquals("WALTER", response.nombre());
        assertEquals(new BigDecimal("150000.50"), response.valorDeuda());


        // Verificamos que se registraron los parámetros (Uso de any())
        verify(query, Mockito.times(6)).registerStoredProcedureParameter(anyString(), any(), any());
        verify(query, Mockito.times(3)).setParameter(anyString(), any());
        verify(query).execute();
    }


    @Test
    @DisplayName("Debe lanzar ElementNotFoundException cuando Oracle devuelve un error")
    void consultarEstadoPredialFallido() {
        ConsultaRequest request = new ConsultaRequest("99-99-99", "123", "CC");

        when(entityManager.createStoredProcedureQuery(anyString())).thenReturn(query);

        PersistenceException oracleError = new PersistenceException("ORA-20001: El contribuyente no existe en el sistema.");

        doThrow(oracleError).when(query).execute();

        ElementNotFoundException exception = assertThrows(ElementNotFoundException.class, () -> {
            service.consultarEstadoPredial(request);
        });

        assertEquals("ORA-20001: El contribuyente no existe en el sistema.", exception.getMessage());

        verify(query).execute();
        verify(query, never()).getOutputParameterValue(anyString());
    }

}