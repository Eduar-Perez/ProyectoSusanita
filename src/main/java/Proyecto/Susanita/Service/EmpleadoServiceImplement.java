package Proyecto.Susanita.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Proyecto.Susanita.Dto.EmpleadoDto;
import Proyecto.Susanita.Entity.EmpleadoEntity;
import Proyecto.Susanita.Repository.EmpleadoRepository;

@Service

public class EmpleadoServiceImplement implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public EmpleadoDto agregarEmpleado(EmpleadoEntity empleado) throws Exception {

		EmpleadoEntity empleadoResponse = new EmpleadoEntity();

		if (empleado.getId() != null && empleadoRepository.existsById(empleado.getId())) {
			throw new Exception("YA EXISTE UN EMPLEADO CON ESTA CEDULA,");
		}
		else {
			try {
				empleadoResponse = empleadoRepository.save(empleado);

			} catch (Exception error) {

				throw new Exception("OCURRIO UN ERROR GUARDANDO LOS DATOS DEL EMPLEADO.");

			}
		}

		return EmpleadoDto.CONVERT_DTO.apply(empleadoResponse);
	}

	@Override
	public EmpleadoDto modificarEmpleado(EmpleadoEntity empleado) throws Exception {

		EmpleadoEntity empleadoResponse = new EmpleadoEntity();

		if (empleado.getId() != null && empleadoRepository.existsById(empleado.getId())) {
			try {
				empleadoResponse = empleadoRepository.save(empleado);

			} catch (Exception error) {
				throw new Exception("OCURRIO UN ERROR MODIFICANDO LOS DATOS DEL EMPLEADO.");

			}
		}
		else {
			throw new Exception("NO EXISTEN REGISTRO SIMILARES PARA MODIFICAR.");
		}

		return EmpleadoDto.CONVERT_DTO.apply(empleadoResponse);
	}

	@Override
	public EmpleadoDto buscarCliente(Long id) throws Exception {

		Optional<EmpleadoEntity> empleadoResponse = null;

		if (! empleadoRepository.existsById(id) ) {
			throw new Exception("NO EXISTEN REGISTROS CON EL NUMERO DE CEDULA INGRESADO.");

		}
		else {
			try {
				empleadoResponse = empleadoRepository.findById(id);

			} catch (Exception error) {
				throw new Exception("OCURRIO UN ERROR REALIZANDO LA BUSQUEDA DEL EMPLEADO.");

			}
		}

		return  EmpleadoDto.CONVERT_DTO.apply(empleadoResponse.get());
	}

	@Override
	public List<EmpleadoDto> obtenerListaEmpleado() {

		List<EmpleadoEntity> listaEmpleadoEntity = new ArrayList<>();
		List<EmpleadoDto> listaEmpleadoResponse = new ArrayList<>();

		listaEmpleadoEntity = empleadoRepository.findAll();

		listaEmpleadoEntity.forEach(item -> {
			listaEmpleadoResponse.add(EmpleadoDto.CONVERT_DTO.apply(item));

		});

		return listaEmpleadoResponse;
	}

	@Override
	public void borrarEmpleado(Long id) throws Exception {

		if (empleadoRepository.existsById(id)) {
			try {
				empleadoRepository.deleteById(id);

			} catch (Exception error) {
				throw new Exception("OCURRIO UN ERROR BORRANDO EL REGISTRO DEL EMPLEADO.");

			}
		}
		else {
			throw new Exception("NO SE ENCONTRAR CONCIDENCIAS CON EL NUMERO DE CEDULA PARA ELIMINAR.");
		}
	}

}
