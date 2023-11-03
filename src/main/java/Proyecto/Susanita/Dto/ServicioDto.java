package Proyecto.Susanita.Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import Proyecto.Susanita.Entity.ServicioEmpleadoEntity;
import Proyecto.Susanita.Entity.ServicioEntity;
import Proyecto.Susanita.Entity.ServicioProductoEntity;
import lombok.Data;

@Data

public class ServicioDto {

	private Integer id;

	private String nombre;

	private List<ServicioProductoDto> productoServicio;

	private List<ServicioEmpleadoDto> empleadoServicio;


	public static final Function <ServicioDto, ServicioEntity> CONVERT_ENTITY = (ServicioDto servicioDto) ->{
		ServicioEntity servicioResponse = new ServicioEntity();
		if(servicioDto != null){
			servicioResponse.setId(servicioDto.getId());

			if (servicioDto.getProductoServicio() != null &&  servicioDto.getProductoServicio().size() >= 1) {
				List<ServicioProductoEntity> listaServicioProducto = new ArrayList<>();
				servicioDto.getProductoServicio().forEach(item -> {
					listaServicioProducto.add(ServicioProductoDto.CONVERT_ENTITY.apply(item));
				});
				servicioResponse.setListServicioProducto(listaServicioProducto);
			}

			if (servicioDto.getEmpleadoServicio() != null && servicioDto.getEmpleadoServicio().size() >= 1) {
				List<ServicioEmpleadoEntity> listaServicioEmpleado = new ArrayList<>();
				servicioDto.getEmpleadoServicio().forEach(item -> {
					listaServicioEmpleado.add(ServicioEmpleadoDto.CONVERT_ENTITY.apply(item));
				});
				servicioResponse.setListServicioEmpleado(listaServicioEmpleado);
			}
		}
		return servicioResponse;
	};

	public static final Function <ServicioEntity, ServicioDto> CONVERT_DTO = (ServicioEntity servicioEntity) ->{

		ServicioDto servicioResponse = new ServicioDto();

		if (servicioEntity.getListServicioProducto() != null && servicioEntity.getListServicioProducto().size() >= 1) {

			List<ServicioProductoDto> listaServicioProducto = new ArrayList<>();
			List <ServicioEmpleadoDto> listaServicioEmpleado = new ArrayList<>();

			servicioEntity.getListServicioProducto().forEach(item ->{
				listaServicioProducto.add(ServicioProductoDto.CONVERT_DTO.apply(item));

				servicioResponse.setProductoServicio(listaServicioProducto);
			});

			servicioEntity.getListServicioEmpleado().forEach(item ->{
				listaServicioEmpleado.add(ServicioEmpleadoDto.CONVERT_DTO.apply(item));

				servicioResponse.setEmpleadoServicio(listaServicioEmpleado);
			});
		}

		servicioResponse.setId(servicioEntity.getId());
		servicioResponse.setNombre(servicioEntity.getNombreServicio());

		return servicioResponse;
	};
}