package com.ceiba.urgencias.infraestructura.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.urgencias.aplicacion.comando.ComandoVenta;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorConsultarVentas;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorCrearVenta;

@RestController
@RequestMapping(value = "/ventas")
public class VentaControlador {

	private final ManejadorCrearVenta manejadorCrearVenta;
	private final ManejadorConsultarVentas manejadorConsultarVentas;

	public VentaControlador(ManejadorConsultarVentas manejadorConsultarVentas,
			ManejadorCrearVenta manejadorCrearVenta) {
		this.manejadorCrearVenta = manejadorCrearVenta;
		this.manejadorConsultarVentas = manejadorConsultarVentas;

	}

	@PostMapping("/agregar-venta")
	public void agregarMedicamento(@RequestBody ComandoVenta comandoVenta) {
		this.manejadorCrearVenta.ejecutar(comandoVenta);
	}

	@GetMapping("/obtener-ventas")
	public List<ComandoVenta> obtenerMedicamentos() {
		return manejadorConsultarVentas.ejecutar();
	}
}
