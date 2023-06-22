package com.ceiba.urgencias.aplicacion.manejador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.urgencias.aplicacion.comando.ComandoVenta;
import com.ceiba.urgencias.dominio.servicio.ServicioConsultarVentas;

@Component
public class ManejadorConsultarVentas {
	private final ServicioConsultarVentas servicioConsultarVentas;

	public ManejadorConsultarVentas(ServicioConsultarVentas servicioConsultarVentas) {
		this.servicioConsultarVentas = servicioConsultarVentas;
	}

	@Transactional
	public List<ComandoVenta> ejecutar() {
		return this.servicioConsultarVentas.ejecutar();
	}

}
