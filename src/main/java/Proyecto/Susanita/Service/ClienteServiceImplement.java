package Proyecto.Susanita.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Proyecto.Susanita.Dto.ClienteDto;
import Proyecto.Susanita.Entity.ClienteServicioEntity;
import Proyecto.Susanita.Entity.ClienteEntity;
import Proyecto.Susanita.Repository.ClienteRepository;
import Proyecto.Susanita.Repository.ClienteServicioRepository;

@Service

public class ClienteServiceImplement implements ClienteService  {

	@Autowired
	private ClienteRepository clienteRepository;

	private ClienteServicioRepository clienteServicioRepository;

	//Agregar el Cliente manualmente porque primero debe estar guardado para poder asignarle la lista del servicio.
	@Override
	public ClienteDto agregarClienteManualmente (ClienteEntity cliente) throws Exception{

		ClienteEntity clienteResponse = new ClienteEntity();

		clienteResponse.setId(cliente.getId());
		clienteResponse.setNombres(cliente.getNombres());
		clienteResponse.setApellidos(cliente.getApellidos());
		clienteResponse.setTelefono(cliente.getTelefono());
		clienteResponse.setListaClienteServicio(cliente.getListaClienteServicio());

		try {
			clienteRepository.save(clienteResponse);

		} catch (Exception error) {
			throw  new Exception("OCURRIO UN ERROR GUARDANDO LOS DATOS DEL CLIENTE.");
		}  

		List <ClienteServicioEntity> listaClienteServicio = new ArrayList<>();

		cliente.getListaClienteServicio().forEach(item -> {
			listaClienteServicio.add(item);

		});
		listaClienteServicio.forEach(item1 -> {
			ClienteServicioEntity listaClienteServicioEntity = new ClienteServicioEntity();
			listaClienteServicioEntity.setIdCliente(item1.getIdCliente());
			listaClienteServicioEntity.setIdServicio(item1.getIdServicio());

			clienteServicioRepository.save(listaClienteServicioEntity);

		});

		clienteResponse.setListaClienteServicio(listaClienteServicio);
		return ClienteDto.CONVERT_DTO.apply(clienteResponse);
	}

	@Override
	public ClienteDto agregarCliente(ClienteEntity cliente) throws Exception {

		ClienteEntity clienteResponse = new ClienteEntity();

		if (cliente.getId() != null && clienteRepository.existsById(cliente.getId())) {
			throw new Exception("YA EXISTE UN REGISTRO CON LA MISMA CEDULA.");
		}

		try {
			clienteResponse = clienteRepository.save(cliente);
		} catch (Exception error) {
			throw new Exception("OCURRIO UN PROBLEMA GUARDANDO EL REGISTRO.");
		}


		return ClienteDto.CONVERT_DTO.apply(clienteResponse);
	}

	@Override
	public ClienteDto modificarCliente(ClienteEntity cliente) throws Exception {

		ClienteEntity clienteRepsonse = new ClienteEntity();

		if (cliente.getId() != null && clienteRepository.existsById(cliente.getId())) {
			try {
				clienteRepsonse = clienteRepository.save(cliente);
			} catch (Exception error) {
				throw new Exception("OCURRIO UN ERROR MODIFICANDO LOS DATOS DE SU REGISTRO.");
			}
		}
		else {
			throw new Exception("NO EXISTEN REGISTROS PARA MODIFICAR.");
		}
		return ClienteDto.CONVERT_DTO.apply(clienteRepsonse);
	}

	@Override
	public ClienteDto buscarCliente(Long id) throws Exception {

		Optional<ClienteEntity> ClientesResponse = null;

		if (! clienteRepository.existsById(id)) {
			throw new Exception("NO SE ENCUENTRAN REGISTROS REGISTRADOS CON LA CEDULA INGRESADA");
		}
		else {
			try {
				ClientesResponse = clienteRepository.findById(id);	
			} catch (Exception error) {
				throw new Exception("OCURRIO UN ERROR BUSCANDO LA LISTA DE CLIENTES");
			} 
		}

		return ClienteDto.CONVERT_DTO.apply(ClientesResponse.get()) ;
	}

	@Override
	public List<ClienteDto> obtenerListaCliente() throws Exception {

		List<ClienteEntity> listaEntity = new ArrayList<>();
		List<ClienteDto> listaClientesDtoResponse = new ArrayList<>();

		listaEntity = clienteRepository.findAll();

		listaEntity.forEach(item -> {
			listaClientesDtoResponse.add(ClienteDto.CONVERT_DTO.apply(item));
		});

		return listaClientesDtoResponse;
	}

	@Override
	public void  borrarCliente(Long id) throws Exception {

		if (clienteRepository.existsById(id)) {
			try {
				clienteRepository.deleteById(id);
			} catch (Exception error) {
				throw new Exception("OCURRIO UN ERROR ELIMINANDO LOS REGISTROS");
			}
		}
		else {
			throw new Exception("NO EXISTEN REGISTROS CON EL NUMERO DE CEDULA INGRESADO PARA BORRAR.");
		}
	}
}
