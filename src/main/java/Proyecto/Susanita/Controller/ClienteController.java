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

import Proyecto.Susanita.Dto.ClienteDto;
import Proyecto.Susanita.Entity.ClienteEntity;
import Proyecto.Susanita.Service.ClienteService;

@RestController
@RequestMapping ("/cliente")

public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping ("/añadir")
	public ClienteDto añadirCliente(@RequestBody ClienteDto cliente) throws Exception {

		ClienteEntity clienteEntity = ClienteDto.CONVERT_ENTITY.apply(cliente);
		clienteService.agregarClienteManualmente(clienteEntity);

		return ClienteDto.CONVERT_DTO.apply(clienteEntity);

	}

	@PutMapping ("/modificar")
	public ClienteDto mdificarCliente(@RequestBody ClienteDto cliente) throws Exception {

		ClienteEntity clienteEntity = ClienteDto.CONVERT_ENTITY.apply(cliente);
		clienteService.modificarCliente(clienteEntity);

		return ClienteDto.CONVERT_DTO.apply(clienteEntity);

	}

	@GetMapping ("/buscar/{id}")
	public ClienteDto buscarCliente(@PathVariable Long id) throws Exception {

		return clienteService.buscarCliente(id);

	}

	@GetMapping ("/obtenerLista")
	public List<ClienteDto> obtenerLista() throws Exception {

		return clienteService.obtenerListaCliente();

	}

	@DeleteMapping ("/borrar/{id}")
	public void borrarCliente(@PathVariable Long id) throws Exception {

		clienteService.borrarCliente(id);

	}

}
