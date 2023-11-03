package Proyecto.Susanita.Service;

import java.util.List;

import Proyecto.Susanita.Dto.EmpleadoDto;
import Proyecto.Susanita.Entity.EmpleadoEntity;

public interface EmpleadoService {

	public EmpleadoDto agregarEmpleado(EmpleadoEntity empleado) throws Exception;

	public EmpleadoDto modificarEmpleado(EmpleadoEntity empleado) throws Exception;

	public EmpleadoDto buscarCliente(Long id) throws Exception;

	public List<EmpleadoDto> obtenerListaEmpleado();

	public void borrarEmpleado(Long id) throws Exception;

}
