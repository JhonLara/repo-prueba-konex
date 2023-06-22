package com.ceiba.urgencias.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.urgencias.aplicacion.comando.ComandoMedicamento;
import com.ceiba.urgencias.dominio.modelo.Medicamento;

@Component
public class FabricaMedicamento {

	public Medicamento crearMedicamento(ComandoMedicamento comandoMedicamento) {
		return new Medicamento(comandoMedicamento.getIdMedicamento(), comandoMedicamento.getNombreMedicamento(),
				comandoMedicamento.getLaboratorio(), comandoMedicamento.getFechaFabricacion(),
				comandoMedicamento.getFechaVencimiento(), comandoMedicamento.getCantidad(),
				comandoMedicamento.getValor());
	}
}
