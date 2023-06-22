package com.ceiba.urgencias.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.urgencias.aplicacion.comando.ComandoMedicamento;
import com.ceiba.urgencias.aplicacion.fabrica.FabricaMedicamento;
import com.ceiba.urgencias.dominio.modelo.Medicamento;
import com.ceiba.urgencias.dominio.servicio.ServicioCrearMedicamento;

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
