package Proyecto.Susanita.Entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "Servicios")
@Data

public class ServicioEntity {

	@Id
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column (name = "Nombre_Servicio")
	private String nombreServicio;

	//Esta es la lista de producto
	@OneToMany (mappedBy = "idServicio", cascade = {CascadeType.ALL} )
	private List<ServicioProductoEntity> listServicioProducto;

	//Esta es la lista de empleado
	@OneToMany (mappedBy = "idServicioEntity", cascade = {CascadeType.ALL} )
	private List <ServicioEmpleadoEntity> listServicioEmpleado;

}
