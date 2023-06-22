package com.konex.prueba.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.konex.prueba.dominio.puerto.repositorio.RepositorioMedicamento;
import com.konex.prueba.dominio.puerto.repositorio.RepositorioVenta;
import com.konex.prueba.dominio.servicio.ServicioConsultarMedicamentos;
import com.konex.prueba.dominio.servicio.ServicioConsultarVentas;
import com.konex.prueba.dominio.servicio.ServicioCrearMedicamento;
import com.konex.prueba.dominio.servicio.ServicioCrearVenta;
import com.konex.prueba.dominio.servicio.ServicioEliminarMedicamento;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearVenta crearServicioCrearVenta(RepositorioVenta repositorioVenta,
			RepositorioMedicamento repositorioMedicamento) {
		return new ServicioCrearVenta(repositorioVenta, repositorioMedicamento);
	}

	@Bean
	public ServicioCrearMedicamento crearServicioCrearMedicamento(RepositorioMedicamento repositorioMedicamento) {
		return new ServicioCrearMedicamento(repositorioMedicamento);
	}

	@Bean
	public ServicioConsultarMedicamentos crearServicioConsultarMedicamentos(
			RepositorioMedicamento repositorioMedicamento) {
		return new ServicioConsultarMedicamentos(repositorioMedicamento);
	}

	@Bean
	public ServicioConsultarVentas crearServicioConsultarVentas(RepositorioVenta repositorioVenta) {
		return new ServicioConsultarVentas(repositorioVenta);
	}

	@Bean
	public ServicioEliminarMedicamento crearServicioEliminarMedicamento(RepositorioMedicamento repositorioMedicamento) {
		return new ServicioEliminarMedicamento(repositorioMedicamento);
	}
}
