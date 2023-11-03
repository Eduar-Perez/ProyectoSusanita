package Proyecto.Susanita.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "Productos")
@Data

public class ProductoEntity {
	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "Nombre_Producto", nullable = false)
	private String nombreProducto;
	
	@Column (name = "Precio_Producto", nullable = false)
	private Long precioProducto;
	
}
