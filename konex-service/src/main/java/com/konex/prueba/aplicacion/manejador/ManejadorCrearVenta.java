package com.konex.prueba.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.konex.prueba.aplicacion.comando.ComandoVenta;
import com.konex.prueba.aplicacion.fabrica.FabricaVenta;
import com.konex.prueba.dominio.modelo.Venta;
import com.konex.prueba.dominio.servicio.ServicioCrearVenta;

@Component
public class ManejadorCrearVenta {
	private final ServicioCrearVenta servicioCrearVenta;
	private final FabricaVenta fabricaVenta;

	public ManejadorCrearVenta(ServicioCrearVenta servicioCrearVenta, FabricaVenta fabricaVenta) {
		this.servicioCrearVenta = servicioCrearVenta;
		this.fabricaVenta = fabricaVenta;
	}

	@Transactional
	public void ejecutar(ComandoVenta comandoVenta) {
		Venta venta = this.fabricaVenta.crearVenta(comandoVenta);
		this.servicioCrearVenta.ejecutar(venta);
	}

}
