package com.ceiba.urgencias.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.urgencias.dominio.servicio.ServicioEliminarMedicamento;

@Component
public class ManejadorEliminarMedicamento {

	private final ServicioEliminarMedicamento servicioEliminarMedicamento;

	public ManejadorEliminarMedicamento(ServicioEliminarMedicamento servicioEliminarMedicamento) {

		this.servicioEliminarMedicamento = servicioEliminarMedicamento;
	}

	@Transactional
	public void ejecutar(Long idMedicamento) {
		this.servicioEliminarMedicamento.ejecutar(idMedicamento);
	}
}
