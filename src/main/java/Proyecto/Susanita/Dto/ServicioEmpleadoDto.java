package Proyecto.Susanita.Dto;

import java.util.function.Function;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Proyecto.Susanita.Entity.ServicioEmpleadoEntity;
import lombok.Data;

@Data

public class ServicioEmpleadoDto {

	private Integer id;

	@JsonIgnore
	private ServicioDto idServicio;

	private EmpleadoDto idEmpleado;

	public static final Function <ServicioEmpleadoEntity, ServicioEmpleadoDto> CONVERT_DTO = (ServicioEmpleadoEntity servicioEmpleado) -> {

		ServicioEmpleadoDto servicioEmpleadoResponse = new ServicioEmpleadoDto(); 

		servicioEmpleadoResponse.setId(servicioEmpleado.getId());
		servicioEmpleadoResponse.setIdEmpleado(EmpleadoDto.CONVERT_DTO.apply(servicioEmpleado.getIdEmpleadoEntity()));

		return servicioEmpleadoResponse;
	};

	public static final Function <ServicioEmpleadoDto, ServicioEmpleadoEntity> CONVERT_ENTITY = (ServicioEmpleadoDto servicioEmpleado) -> {

		ServicioEmpleadoEntity servicioEmpleadoResponse = new ServicioEmpleadoEntity();

		servicioEmpleadoResponse.setId(servicioEmpleado.getId());
		servicioEmpleadoResponse.setIdEmpleadoEntity(EmpleadoDto.CONVERT_ENTITY.apply(servicioEmpleado.getIdEmpleado()));

		return servicioEmpleadoResponse;
	};

}
