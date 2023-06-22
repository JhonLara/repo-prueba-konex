package com.konex.prueba.infraestructura.entidad;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VENTA")
@AllArgsConstructor
@NoArgsConstructor
public class VentaEntidad {
	
	@Id
	@Column(name = "ID_VENTA")
	@Getter
	@Setter
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="MY_ENTITY_SEQ_VENTA",allocationSize = 1)
	private Long idVenta;

	@Getter
	@Setter
	@Column(name = "NOMBRE_MEDICAMENTO")
	private String nombreMedicamento;


	@Getter
	@Setter
	@Column(name = "FECHA")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:MM")
	private LocalDate fecha;

	@Getter
	@Setter
	@Column(name = "CANTIDAD")
	private Long cantidad;

	@Getter
	@Setter
	@Column(name = "VALOR")
	private Double valor;
	
	@Getter
	@Setter
	@Column(name = "VALOR_TOTAL")
	private Double valorTotal;

}
