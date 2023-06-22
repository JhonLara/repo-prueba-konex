package com.konex.prueba.aplicacion.manejador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.konex.prueba.aplicacion.comando.ComandoMedicamento;
import com.konex.prueba.dominio.servicio.ServicioConsultarMedicamentos;

@Component
public class ManejadorConsultarMedicamentos {
	private final ServicioConsultarMedicamentos servicioConsultarMedicamentos;

	public ManejadorConsultarMedicamentos(ServicioConsultarMedicamentos servicioConsultarMedicamentos) {
		this.servicioConsultarMedicamentos = servicioConsultarMedicamentos;
	}

	@Transactional
	public List<ComandoMedicamento> ejecutar() {
		return this.servicioConsultarMedicamentos.ejecutar();
	}
}
