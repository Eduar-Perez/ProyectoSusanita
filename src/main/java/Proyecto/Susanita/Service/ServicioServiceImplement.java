package Proyecto.Susanita.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Proyecto.Susanita.Dto.EmpleadoDto;
import Proyecto.Susanita.Dto.ProductoDto;
import Proyecto.Susanita.Dto.ServicioDto;
import Proyecto.Susanita.Entity.ServicioEmpleadoEntity;
import Proyecto.Susanita.Entity.ServicioEntity;
import Proyecto.Susanita.Entity.ServicioProductoEntity;
import Proyecto.Susanita.Repository.ProductoServicioRepository;
import Proyecto.Susanita.Repository.ServicioEmpleadoRepository;
import Proyecto.Susanita.Repository.ServicioRepository;

@Service

public class ServicioServiceImplement implements ServicioService {

	@Autowired
	private ServicioRepository servicioRepository;
	@Autowired
	private ServicioEmpleadoRepository servicioEmpleadoRepository; 
	@Autowired
	private ProductoServicioRepository servicioProductoRepository;

	@Override
	public ServicioDto agregarServicio(ServicioDto servicio) throws Exception {

		ServicioEntity servicioResponse = new ServicioEntity();

		if (servicio.getId() != null && servicioRepository.existsById(servicio.getId())) {
			throw new Exception("YA EXISTE UN REGISTRO CON EL MISMO CODIGO.");
		}

		try {
			servicioResponse = servicioRepository.save(ServicioDto.CONVERT_ENTITY.apply(servicio));

		} catch (Exception error) {
			throw new Exception("OCURRIO UN PROBLEMA GUARDANDO EL REGISTRO.");

		}

		return ServicioDto.CONVERT_DTO.apply(servicioResponse);
	}

	@Override
	public ServicioDto modificarServicio(ServicioDto servicio) throws Exception {

		ServicioEntity servicioResponse = new ServicioEntity();	

		if (servicio.getId() != null && servicioRepository.existsById(servicio.getId())) {
			try {
				servicioResponse = servicioRepository.save(ServicioDto.CONVERT_ENTITY.apply(servicio));

			} catch (Exception error) {
				throw new Exception("CURRIO UN ERROR MODIFICANDO LOS DATOS.");

			}
		}
		else {
			throw new Exception("NO EXISTEN REGISTROS SIMILARES PARA MODIFICAR CON EL CODIGO INGRESADO.");
		}

		return ServicioDto.CONVERT_DTO.apply(servicioResponse);
	}

	@Override
	public ServicioDto buscarServicio(Integer id) throws Exception {

		Optional <ServicioEntity> servicioResponse = null;	

		if (!servicioRepository.existsById(id) ) {
			throw new Exception("NO EXISTEN REGISTROS CON EL CODIGO INGRESADO.");
		}
		else {
			try {
				servicioResponse = servicioRepository.findById(id);
			} catch (Exception error) {
				throw new Exception("OCURRIO UN ERROR REALIZANDO LA BUSQUEDA.");

			} 
		}

		return ServicioDto.CONVERT_DTO.apply(servicioResponse.get());
	}

	@Override
	public List<ServicioDto> obtenerListaServicios() throws Exception {

		List <ServicioEntity> listaEntity = new ArrayList<>();
		List <ServicioDto> listaServiciosResponse = new ArrayList<>();

		listaEntity = servicioRepository.findAll();

		listaEntity.forEach(item -> {
			listaServiciosResponse.add(ServicioDto.CONVERT_DTO.apply(item));

		});

		return listaServiciosResponse;
	}

	@Override
	public void borrarServicio(Integer id) throws Exception {

		if (servicioRepository.existsById(id)) {
			try {
				servicioRepository.deleteById(id);

			} catch (Exception error) {
				throw new Exception("OCURRIO UN ERROR BORRANDO LOS REGISTROS.");

			}
		}
		else {
			throw new Exception("NO SE ENCONTRAROS REGISTROS SIMILARES PARA BORRAR.");
		}
	}

	@Override
	public void  agregarEmpleadoaServicio(ServicioDto servicioDto, EmpleadoDto empleadoDto) throws Exception {

		ServicioEmpleadoEntity servicioEmpleado = new ServicioEmpleadoEntity();

		if (servicioDto.getId() != null && servicioRepository.existsById(servicioDto.getId()) ) {

			servicioEmpleado.setIdServicioEntity(ServicioDto.CONVERT_ENTITY.apply(servicioDto));
			servicioEmpleado.setIdEmpleadoEntity(EmpleadoDto.CONVERT_ENTITY.apply(empleadoDto));

			servicioEmpleadoRepository.save(servicioEmpleado);
		}
		else {

			throw new Exception("NO EXISTEN REGISTROS DEL SERVICIO PARA AGREGAR UN EMPLEADO");
		}
	}

	@Override
	public void agregarProductoaServicio(ServicioDto servicio, ProductoDto producto) {

		ServicioProductoEntity servicioProducto = new ServicioProductoEntity();

		servicioProducto.setIdServicio(ServicioDto.CONVERT_ENTITY.apply(servicio));
		servicioProducto.setIdProducto(ProductoDto.CONVERT_ENTITY.apply(producto));

		servicioProductoRepository.save(servicioProducto);
	}
}
