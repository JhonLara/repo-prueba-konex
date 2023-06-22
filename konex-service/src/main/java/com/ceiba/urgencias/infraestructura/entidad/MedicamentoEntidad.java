package com.ceiba.urgencias.infraestructura.entidad;

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
@Table(name = "MEDICAMENTO")
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoEntidad {

	@Id
	@Column(name = "ID_MEDICAMENTO")
	@Getter
	@Setter
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="MY_ENTITY_SEQ",allocationSize = 1)
	private Long idMedicamento;

	@Getter
	@Setter
	@Column(name = "NOMBRE_MEDICAMENTO")
	private String nombreMedicamento;

	@Getter
	@Setter
	@Column(name = "LABORATORIO")
	private String laboratorio;

	@Getter
	@Setter
	@Column(name = "FECHA_FABRICACION")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaFabricacion;

	@Getter
	@Setter
	@Column(name = "FECHA_VENCIMIENTO")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaVencimiento;

	@Getter
	@Setter
	@Column(name = "CANTIDAD")
	private Long cantidad;

	@Getter
	@Setter
	@Column(name = "VALOR")
	private Double valor;

}
