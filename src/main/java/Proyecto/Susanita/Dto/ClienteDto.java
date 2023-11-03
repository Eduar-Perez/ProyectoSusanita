package Proyecto.Susanita.Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


import Proyecto.Susanita.Entity.ClienteServicioEntity;
import Proyecto.Susanita.Entity.ClienteEntity;
import lombok.Data;

@Data 

public class ClienteDto {

	private Long id;

	private String nombres;

	private String apellidos;

	private Long telefono;

	private List <ClienteClienteServicioDto> clienteServicio;


	public static final Function <ClienteDto, ClienteEntity> CONVERT_ENTITY = (ClienteDto clienteDto) ->{

		if (clienteDto.getClienteServicio() != null) {
			clienteDto.getClienteServicio().forEach(item ->{
				ClienteDto clienteDtoResponse = new ClienteDto();
				clienteDtoResponse.setId(clienteDto.getId());
				item.setIdCliente(clienteDtoResponse);
			});
		}

		ClienteEntity clienteResponse = new ClienteEntity();

		clienteResponse.setId(clienteDto.getId());
		clienteResponse.setNombres(clienteDto.getNombres());
		clienteResponse.setApellidos(clienteDto.getApellidos());
		clienteResponse.setTelefono(clienteDto.getTelefono());


		if (clienteDto.getClienteServicio() != null) {
			List <ClienteServicioEntity> listaClienteClienteServicio = new ArrayList<>();
			clienteDto.getClienteServicio().forEach(item -> {
				listaClienteClienteServicio.add(ClienteClienteServicioDto.CONVERT_ENTITY.apply(item));

				clienteResponse.setListaClienteServicio(listaClienteClienteServicio);
			});
		}

		return clienteResponse;

	};

	public static final Function <ClienteEntity, ClienteDto> CONVERT_DTO = (ClienteEntity clienteEntity) ->{

		ClienteDto clienteDtoResponse = new ClienteDto();

		if(clienteEntity.getListaClienteServicio()!= null && clienteEntity.getListaClienteServicio().size() >= 1) {

			List <ClienteClienteServicioDto> listaClienteClienteServicio = new ArrayList<>();
			clienteEntity.getListaClienteServicio().forEach(item -> {
				listaClienteClienteServicio.add(ClienteClienteServicioDto.CONVERT_DTO.apply(item));
			});
			clienteDtoResponse.setClienteServicio(listaClienteClienteServicio);
		}

		clienteDtoResponse.setId(clienteEntity.getId());
		clienteDtoResponse.setNombres(clienteEntity.getNombres());
		clienteDtoResponse.setApellidos(clienteEntity.getApellidos());
		clienteDtoResponse.setTelefono(clienteEntity.getTelefono());

		return clienteDtoResponse;

	};
}