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
@Table(name = "Clientes")
@Data

public class ClienteEntity {

	@Id
	private Long Id;

	@Column (name = "Nombres_Cliente", nullable = false)
	private String nombres;

	@Column (name = "Apellidos_Cliente", nullable = false)
	private String apellidos;

	@Column (name = "Telefono_Cliente", nullable = false)
	private Long telefono;

	@OneToMany (mappedBy = "idCliente", cascade = {CascadeType.ALL} ) 
	private List <ClienteServicioEntity> listaClienteServicio;
}
