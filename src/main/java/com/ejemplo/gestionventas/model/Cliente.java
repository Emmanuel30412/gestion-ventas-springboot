package com.ejemplo.gestionventas.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data //Genera getter y setter automaticamente. Proviene de lombok
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "El correo debe ser válido")
    @NotBlank(message = "El correo es obligatorio")
    @Column(unique = true)
    private String correo;

    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Factura> facturas = new ArrayList<>();

}
