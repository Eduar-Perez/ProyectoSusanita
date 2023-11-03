package Proyecto.Susanita.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ServicioProductoEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_ServicioProducto")
	private Integer id;

	@ManyToOne
	@JoinColumn (name = "Fk_Servicio")
	private ServicioEntity idServicio;

	@ManyToOne
	@JoinColumn (name = "Fk_Producto")
	private ProductoEntity idProducto;
}
	