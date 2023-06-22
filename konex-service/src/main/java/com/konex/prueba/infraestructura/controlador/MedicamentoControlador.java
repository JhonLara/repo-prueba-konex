package com.konex.prueba.infraestructura.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konex.prueba.aplicacion.comando.ComandoMedicamento;
import com.konex.prueba.aplicacion.manejador.ManejadorConsultarMedicamentos;
import com.konex.prueba.aplicacion.manejador.ManejadorCrearMedicamento;
import com.konex.prueba.aplicacion.manejador.ManejadorEliminarMedicamento;

@RestController
@RequestMapping(value = "/medicamentos")
public class MedicamentoControlador {

	private final ManejadorCrearMedicamento manejadorCrearMedicamento;
	private final ManejadorEliminarMedicamento manejadorEliminarMedicamento;
	private final ManejadorConsultarMedicamentos manejadorConsultarMedicamentos;

	public MedicamentoControlador(ManejadorConsultarMedicamentos manejadorConsultarMedicamentos,
			ManejadorEliminarMedicamento manejadorEliminarMedicamento,
			ManejadorCrearMedicamento manejadorCrearMedicamento) {
		this.manejadorCrearMedicamento = manejadorCrearMedicamento;
		this.manejadorEliminarMedicamento = manejadorEliminarMedicamento;
		this.manejadorConsultarMedicamentos = manejadorConsultarMedicamentos;

	}

	@PostMapping("/agregar-medicamento")
	public void agregarMedicamento(@RequestBody ComandoMedicamento comandoMedicamento) {
		this.manejadorCrearMedicamento.ejecutar(comandoMedicamento);
	}

	@DeleteMapping("/eliminar-medicamento/{ID_MEDICAMENTO}")
	public void eliminarMedicamento(@PathVariable(name = "ID_MEDICAMENTO") Long idMedicamento) {
		this.manejadorEliminarMedicamento.ejecutar(idMedicamento);
	}

	@GetMapping("/obtener-medicamentos")
	public List<ComandoMedicamento> obtenerMedicamentos() {
		return manejadorConsultarMedicamentos.ejecutar();
	}

}
