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
@Table (name = "Cliente_SServicio_Entity")

public class ClienteServicioEntity {

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Id_ClienteServicio")
	private Integer idClienteClienteServicio;

	@ManyToOne
	@JoinColumn (name = "Fk_Cliente")
	private ClienteEntity idCliente;

	@ManyToOne
	@JoinColumn (name = "Fk_Servicio")
	private ServicioEntity idServicio;

}