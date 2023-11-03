package Proyecto.Susanita.Service;

import java.util.List;

import Proyecto.Susanita.Dto.EmpleadoDto;
import Proyecto.Susanita.Dto.ProductoDto;
import Proyecto.Susanita.Dto.ServicioDto;

public interface ServicioService {

	public ServicioDto agregarServicio(ServicioDto servicio) throws Exception;

	public ServicioDto modificarServicio(ServicioDto servicio) throws Exception;

	public ServicioDto buscarServicio (Integer id) throws Exception;

	public List <ServicioDto> obtenerListaServicios () throws Exception;

	public void borrarServicio (Integer id) throws Exception;
	
	public void agregarEmpleadoaServicio (ServicioDto servicio, EmpleadoDto producto) throws Exception;
	
	public void agregarProductoaServicio (ServicioDto servicio, ProductoDto producto);

}
