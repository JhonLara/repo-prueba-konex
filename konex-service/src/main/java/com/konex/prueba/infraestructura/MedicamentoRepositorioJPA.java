package com.konex.prueba.infraestructura;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konex.prueba.infraestructura.entidad.MedicamentoEntidad;

@Repository
public interface MedicamentoRepositorioJPA extends JpaRepository<MedicamentoEntidad, Serializable> {
	MedicamentoEntidad findByNombreMedicamento(String nombreMedicamento);
}
