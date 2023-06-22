package com.ceiba.urgencias.infraestructura.controlador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.aplicacion.comando.ComandoMedicamento;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorConsultarMedicamentos;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorCrearMedicamento;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorEliminarMedicamento;
import com.ceiba.urgencias.testdatabuilder.ComandoMedicamentoTestDataBuilder;

public class MedicamentoControladorTest {

	private ManejadorCrearMedicamento manejadorCrearMedicamento = mock(ManejadorCrearMedicamento.class);
	private ManejadorConsultarMedicamentos manejadorConsultarMedicamentos = mock(ManejadorConsultarMedicamentos.class);
	private ManejadorEliminarMedicamento manejadorEliminarMedicamento = mock(ManejadorEliminarMedicamento.class);

	// Hacer pruebas de integraci�n
	@Test
	void agregarMedicamento() {
		ComandoMedicamento medicamento = new ComandoMedicamentoTestDataBuilder().build();

		MedicamentoControlador controlador = new MedicamentoControlador(manejadorConsultarMedicamentos,
				manejadorEliminarMedicamento, manejadorCrearMedicamento);

		assertDoesNotThrow(() -> controlador.agregarMedicamento(medicamento));

	}

	@Test
	void eliminarMedicamento() {
		Long idMedicamento = 1L;
		MedicamentoControlador controlador = new MedicamentoControlador(manejadorConsultarMedicamentos,
				manejadorEliminarMedicamento, manejadorCrearMedicamento);
		assertDoesNotThrow(() -> controlador.eliminarMedicamento(idMedicamento));

	}

	@Test
	void obtenerMedicamentos() {
		MedicamentoControlador controlador = new MedicamentoControlador(manejadorConsultarMedicamentos,
				manejadorEliminarMedicamento, manejadorCrearMedicamento);
		assertDoesNotThrow(() -> controlador.obtenerMedicamentos());

	}

}