package com.ejemplo.gestionventas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String correo;
    private String telefono;
}
