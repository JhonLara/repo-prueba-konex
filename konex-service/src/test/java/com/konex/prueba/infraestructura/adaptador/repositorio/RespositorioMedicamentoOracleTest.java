package com.konex.prueba.infraestructura.adaptador.repositorio;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.konex.prueba.dominio.modelo.Medicamento;
import com.konex.prueba.infraestructura.MedicamentoRepositorioJPA;
import com.konex.prueba.infraestructura.entidad.MedicamentoEntidad;
import com.konex.prueba.testdatabuilder.MedicamentoEntidadTestDataBuilder;
import com.konex.prueba.testdatabuilder.MedicamentoTestDataBuilder;

@AutoConfigureTestEntityManager
@Transactional
@SpringBootTest
class RespositorioMedicamentoOracleTest {

	@Autowired
	RepositorioMedicamentoOracle repositorioMedicamentoOracle;

	@Autowired
	private TestEntityManager entityManager;

	// MockMVC para pruebas de integraci�n
	@Test
	void obtenerMedicamentos() {

		MedicamentoEntidad medicamentoEntidad = new MedicamentoEntidadTestDataBuilder().build();
		List<MedicamentoEntidad> listaMedicamentosEntidad = new ArrayList<>();
		listaMedicamentosEntidad.add(medicamentoEntidad);

		MedicamentoRepositorioJPA medicamentoRepositorioJPA = mock(MedicamentoRepositorioJPA.class);
		RepositorioMedicamentoOracle repositorioMedicamentoOracle = new RepositorioMedicamentoOracle(
				medicamentoRepositorioJPA);

		when(medicamentoRepositorioJPA.findAll()).thenReturn(listaMedicamentosEntidad);

		assertNotNull(repositorioMedicamentoOracle.obtenerMedicamentos());

	}

	@Test
	void agregarMedicamento() {

		Medicamento medicamento = new MedicamentoTestDataBuilder().build();
		repositorioMedicamentoOracle.guardar(medicamento);

		MedicamentoEntidad medicamentoEntidad = entityManager.find(MedicamentoEntidad.class,
				medicamento.getIdMedicamento());

		assertEquals(medicamento.getNombreMedicamento(), medicamentoEntidad.getNombreMedicamento());
	}

	@Test
	void eliminarMedicamento() {

		Medicamento medicamento = new MedicamentoTestDataBuilder().build();

		repositorioMedicamentoOracle.guardar(medicamento);

		repositorioMedicamentoOracle.eliminar(medicamento.getIdMedicamento());
		MedicamentoEntidad medicamentoEntidad = entityManager.find(MedicamentoEntidad.class,
				medicamento.getIdMedicamento());
		assertNull(medicamentoEntidad);
	}

}
