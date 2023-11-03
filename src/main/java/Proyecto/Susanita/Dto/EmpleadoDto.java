package Proyecto.Susanita.Dto;

import java.util.function.Function;

import Proyecto.Susanita.Entity.EmpleadoEntity;
import lombok.Data;

@Data

public class EmpleadoDto {

	private Long id;

	private String nombres;

	private String apellidos;

	private Long telefono;



	public static final Function <EmpleadoEntity, EmpleadoDto> CONVERT_DTO = (EmpleadoEntity empleadoEntity) -> {

		EmpleadoDto empleadoDtoResponse = new EmpleadoDto();

		empleadoDtoResponse.setId(empleadoEntity.getId());
		empleadoDtoResponse.setNombres(empleadoEntity.getNombres());
		empleadoDtoResponse.setApellidos(empleadoEntity.getApellidos());
		empleadoDtoResponse.setTelefono(empleadoEntity.getTelefono());

		return empleadoDtoResponse;
	};

	public static final Function <EmpleadoDto, EmpleadoEntity> CONVERT_ENTITY = (EmpleadoDto empleadoDto) ->{

		EmpleadoEntity empleadoEntityResponse = new EmpleadoEntity();

		empleadoEntityResponse.setId(empleadoDto.getId());
		empleadoEntityResponse.setNombres(empleadoDto.getNombres());
		empleadoEntityResponse.setApellidos(empleadoDto.getApellidos());
		empleadoEntityResponse.setTelefono(empleadoDto.getTelefono());

		return empleadoEntityResponse;
	};
}