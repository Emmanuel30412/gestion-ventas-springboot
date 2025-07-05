package com.ejemplo.gestionventas.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FacturaResponseDTO {
    private Long id;
    private LocalDate fecha;
    private BigDecimal total;
    private ClienteDTO cliente;
}
