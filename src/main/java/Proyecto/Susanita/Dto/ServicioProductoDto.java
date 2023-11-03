package Proyecto.Susanita.Dto;

import java.util.function.Function;

import Proyecto.Susanita.Entity.ServicioProductoEntity;


import lombok.Data;

@Data

public class ServicioProductoDto {

	private Integer id;

	private ServicioDto idServicio;

	private ProductoDto idProducto;

	public final static Function <ServicioProductoDto, ServicioProductoEntity> CONVERT_ENTITY = (ServicioProductoDto servcioProducto) -> {

		ServicioProductoEntity servicioProductoResponse = new ServicioProductoEntity ();

		servicioProductoResponse.setId(servcioProducto.getId());
		servicioProductoResponse.setIdServicio(ServicioDto.CONVERT_ENTITY.apply(servcioProducto.getIdServicio()));
		servicioProductoResponse.setIdProducto(ProductoDto.CONVERT_ENTITY.apply(servcioProducto.getIdProducto()));


		return servicioProductoResponse;
	};

	public final static Function <ServicioProductoEntity, ServicioProductoDto > CONVERT_DTO = (ServicioProductoEntity servcioProducto) -> {

		ServicioProductoDto servicioProductoResponse = new ServicioProductoDto ();

		servicioProductoResponse.setId(servcioProducto.getId());
	//	servicioProductoResponse.setIdServicio(ServicioDto.CONVERT_DTO.apply(servcioProducto.getIdServicio()));
		servicioProductoResponse.setIdProducto(ProductoDto.CONVERT_DTO.apply(servcioProducto.getIdProducto()));

		return servicioProductoResponse;
	};

}