package com.konex.prueba.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.konex.prueba.aplicacion.comando.ComandoMedicamento;
import com.konex.prueba.dominio.modelo.Medicamento;

@Component
public class FabricaMedicamento {

	public Medicamento crearMedicamento(ComandoMedicamento comandoMedicamento) {
		return new Medicamento(comandoMedicamento.getIdMedicamento(), comandoMedicamento.getNombreMedicamento(),
				comandoMedicamento.getLaboratorio(), comandoMedicamento.getFechaFabricacion(),
				comandoMedicamento.getFechaVencimiento(), comandoMedicamento.getCantidad(),
				comandoMedicamento.getValor());
	}
}
