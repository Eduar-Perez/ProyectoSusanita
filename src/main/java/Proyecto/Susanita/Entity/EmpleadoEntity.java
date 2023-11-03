package Proyecto.Susanita.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "Empleados")
@Data

public class EmpleadoEntity {

	@Id
	private Long id;

	@Column (name = "Nombres_Empleado", nullable = false)
	private String nombres;

	@Column (name = "Apellidos_Empleado", nullable = false)
	private String apellidos;

	@Column (name = "Teléfono_Empleado", nullable = false)
	private Long telefono;


}
