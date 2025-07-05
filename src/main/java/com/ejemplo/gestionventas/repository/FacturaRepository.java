package com.ejemplo.gestionventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.gestionventas.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long>{

}
