package com.ceiba.urgencias.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioMedicamento;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioVenta;
import com.ceiba.urgencias.dominio.servicio.ServicioConsultarMedicamentos;
import com.ceiba.urgencias.dominio.servicio.ServicioConsultarVentas;
import com.ceiba.urgencias.dominio.servicio.ServicioCrearMedicamento;
import com.ceiba.urgencias.dominio.servicio.ServicioCrearVenta;
import com.ceiba.urgencias.dominio.servicio.ServicioEliminarMedicamento;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearVenta crearServicioCrearVenta(RepositorioVenta repositorioVenta) {
		return new ServicioCrearVenta(repositorioVenta);
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
