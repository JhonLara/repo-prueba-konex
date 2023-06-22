package com.konex.prueba.aplicacion.manejador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.konex.prueba.aplicacion.comando.ComandoVenta;
import com.konex.prueba.dominio.servicio.ServicioConsultarVentas;

@Component
public class ManejadorConsultarVentas {
	private final ServicioConsultarVentas servicioConsultarVentas;

	public ManejadorConsultarVentas(ServicioConsultarVentas servicioConsultarVentas) {
		this.servicioConsultarVentas = servicioConsultarVentas;
	}

	@Transactional
	public List<ComandoVenta> ejecutar(String  fechaInicial, String  fechaFinal) {
		return this.servicioConsultarVentas.ejecutar(fechaInicial, fechaFinal);
	}

}
