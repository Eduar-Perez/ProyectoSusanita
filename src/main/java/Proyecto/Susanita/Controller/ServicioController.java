package Proyecto.Susanita.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Proyecto.Susanita.Dto.RequestSaveEmployeDto;
import Proyecto.Susanita.Dto.RequestSaveEmployeProductoDto;
import Proyecto.Susanita.Dto.ServicioDto;
import Proyecto.Susanita.Entity.ServicioEntity;
import Proyecto.Susanita.Service.ServicioService;

@RestController
@RequestMapping ("/servicio")

public class ServicioController {

	@Autowired
	private ServicioService servicioService;

	@PostMapping ("/agregar")
	public ServicioDto agregarServicio(@RequestBody ServicioDto servicio) throws Exception{

		ServicioEntity servicioEntity = ServicioDto.CONVERT_ENTITY.apply(servicio);
		servicioService.agregarServicio(servicio);

		return ServicioDto.CONVERT_DTO.apply(servicioEntity);
	} 
	
	@PostMapping ("/agregarEmpleadoaServicio")
	public void modificarServicioEmpleado (@RequestBody RequestSaveEmployeDto requestSaveEmployeDto) throws Exception {
		
		servicioService.agregarEmpleadoaServicio(requestSaveEmployeDto.getServicio(), requestSaveEmployeDto.getEmpleado());	
	}
	
	@PostMapping ("/agregarProductoaServicio")
	public void agregarProductoaServicio (@RequestBody RequestSaveEmployeProductoDto requestSaveEmployetProductoDto) {
		
		servicioService.agregarProductoaServicio(requestSaveEmployetProductoDto.getServicio(), requestSaveEmployetProductoDto.getProducto());
	}
	
	@PutMapping ("/modificar")
	public ServicioDto modificarServicio (@RequestBody ServicioDto servicio) throws Exception{

		ServicioEntity servicioEntity = ServicioDto.CONVERT_ENTITY.apply(servicio);
		servicioService.modificarServicio(servicio);

		return ServicioDto.CONVERT_DTO.apply(servicioEntity);
	}

	@GetMapping ("/buscar/{id}")
	public ServicioDto buscarServicio(@PathVariable Integer id) throws Exception{

		return servicioService.buscarServicio(id);
	}

	@GetMapping ("/obtenerListado")
	public List <ServicioDto> obtenerListaServicios() throws Exception{

		return  servicioService.obtenerListaServicios();
	}

	@DeleteMapping ("/borrar/{id}")
	public void borrarServicio (@PathVariable Integer id) throws Exception{

		servicioService.borrarServicio(id);
	}
}
