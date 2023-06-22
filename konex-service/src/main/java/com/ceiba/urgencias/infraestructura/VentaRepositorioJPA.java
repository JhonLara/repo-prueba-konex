package com.ceiba.urgencias.infraestructura;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.urgencias.infraestructura.entidad.VentaEntidad;

@Repository
public interface VentaRepositorioJPA extends JpaRepository<VentaEntidad, Serializable> {

}
