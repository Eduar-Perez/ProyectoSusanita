package Proyecto.Susanita.Dto;

import java.util.function.Function;

import Proyecto.Susanita.Entity.ProductoEntity;
import lombok.Data;

@Data 

public class ProductoDto {

	private Integer id;

	private String nombreProducto;

	private Long precioProducto;


	public static final Function <ProductoDto, ProductoEntity> CONVERT_ENTITY = (ProductoDto productoDto) -> {

		ProductoEntity productoResponse = new ProductoEntity();	

		productoResponse.setId(productoDto.getId());
		productoResponse.setNombreProducto(productoDto.getNombreProducto());
		productoResponse.setPrecioProducto(productoDto.getPrecioProducto());

		return productoResponse;
	};

	public static final Function <ProductoEntity, ProductoDto> CONVERT_DTO = (ProductoEntity productoEntity) -> {

		ProductoDto productoResponse = new ProductoDto();

		productoResponse.setId(productoEntity.getId());
		productoResponse.setNombreProducto(productoEntity.getNombreProducto());
		productoResponse.setPrecioProducto(productoEntity.getPrecioProducto());


		return productoResponse;
	};

	
}
