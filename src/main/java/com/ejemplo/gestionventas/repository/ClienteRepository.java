package com.ejemplo.gestionventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.gestionventas.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
