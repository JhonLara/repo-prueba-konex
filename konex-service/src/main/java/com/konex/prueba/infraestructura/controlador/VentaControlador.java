package com.konex.prueba.infraestructura.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konex.prueba.aplicacion.comando.ComandoVenta;
import com.konex.prueba.aplicacion.manejador.ManejadorConsultarVentas;
import com.konex.prueba.aplicacion.manejador.ManejadorCrearVenta;

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

	@GetMapping("/obtener-ventas/{FECHA_INICIAL}/{FECHA_FINAL}")
	public List<ComandoVenta> obtenerVentas(@PathVariable(name = "FECHA_INICIAL") String  fechaInicial,
			@PathVariable(name = "FECHA_FINAL") String  fechaFinal) {
		return manejadorConsultarVentas.ejecutar(fechaInicial, fechaFinal);
	}
}
