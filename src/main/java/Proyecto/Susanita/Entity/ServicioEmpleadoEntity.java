package Proyecto.Susanita.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name = "Servicio_Empleado_Entity")
public class ServicioEmpleadoEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_ServicioEmpleado")
	private Integer id;

	@ManyToOne
	@JoinColumn (name = "Fk_Servicio")
	private ServicioEntity idServicioEntity;

	@ManyToOne
	@JoinColumn (name = "Fk_Empleado")
	private EmpleadoEntity idEmpleadoEntity;
}
	