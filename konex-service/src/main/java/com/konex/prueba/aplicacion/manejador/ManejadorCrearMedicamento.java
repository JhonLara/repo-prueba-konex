package com.konex.prueba.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.konex.prueba.aplicacion.comando.ComandoMedicamento;
import com.konex.prueba.aplicacion.fabrica.FabricaMedicamento;
import com.konex.prueba.dominio.modelo.Medicamento;
import com.konex.prueba.dominio.servicio.ServicioCrearMedicamento;

@Component
public class ManejadorCrearMedicamento {

	private final ServicioCrearMedicamento servicioCrearMedicamento;
	private final FabricaMedicamento fabricaMedicamento;

	public ManejadorCrearMedicamento(ServicioCrearMedicamento servicioCrearMedicamento,
			FabricaMedicamento fabricaMedicamento) {
		this.fabricaMedicamento = fabricaMedicamento;
		this.servicioCrearMedicamento = servicioCrearMedicamento;
	}

	@Transactional
	public void ejecutar(ComandoMedicamento comandoMedicamento) {
		Medicamento medicamento = this.fabricaMedicamento.crearMedicamento(comandoMedicamento);
		this.servicioCrearMedicamento.ejecutar(medicamento);
	}
}
