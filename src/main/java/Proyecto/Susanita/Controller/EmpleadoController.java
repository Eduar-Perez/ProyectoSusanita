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

import Proyecto.Susanita.Dto.EmpleadoDto;
import Proyecto.Susanita.Entity.EmpleadoEntity;
import Proyecto.Susanita.Service.EmpleadoService;

@RestController
@RequestMapping ("/empleado")

public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@PostMapping ("/añadir")
	public EmpleadoDto crearEmpleado(@RequestBody EmpleadoDto empleado) throws Exception {

		EmpleadoEntity empleadoEntity = EmpleadoDto.CONVERT_ENTITY.apply(empleado);
		empleadoService.agregarEmpleado(empleadoEntity);

		return EmpleadoDto.CONVERT_DTO.apply(empleadoEntity);

	}

	@PutMapping ("/modificar")
	public EmpleadoDto modificarEmpleado(@RequestBody EmpleadoDto empleado) throws Exception {

		EmpleadoEntity empleadoEntity = EmpleadoDto.CONVERT_ENTITY.apply(empleado);
		empleadoService.modificarEmpleado(empleadoEntity);

		return EmpleadoDto.CONVERT_DTO.apply(empleadoEntity);
	}

	@GetMapping ("/buscar/{id}")
	public EmpleadoDto buscarEmpleado(@PathVariable Long id) throws Exception {

		return empleadoService.buscarCliente(id);

	}

	@GetMapping ("/obtenerLista")
	public List<EmpleadoDto> obtenerList(){

		return empleadoService.obtenerListaEmpleado();

	}

	@DeleteMapping ("/borrar/{id}")
	public void borrarEmpleado (@PathVariable Long id) throws Exception {

		empleadoService.borrarEmpleado(id);

	}

}
