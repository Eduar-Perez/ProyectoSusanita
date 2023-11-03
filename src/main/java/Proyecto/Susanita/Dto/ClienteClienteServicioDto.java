package Proyecto.Susanita.Dto;

import java.util.function.Function;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Proyecto.Susanita.Entity.ClienteServicioEntity;
import lombok.Data;

@Data

public class ClienteClienteServicioDto {


	private Integer idClienteClienteServicio;

	@JsonIgnore
	private ClienteDto idCliente;

	private ServicioDto idServicio;


	public static final Function <ClienteServicioEntity, ClienteClienteServicioDto> CONVERT_DTO = (ClienteServicioEntity clienteClienteServicioEntity) -> {

		ClienteClienteServicioDto clienteClienteServicioResponse = new ClienteClienteServicioDto();

		clienteClienteServicioResponse.setIdClienteClienteServicio(clienteClienteServicioEntity.getIdClienteClienteServicio());
		clienteClienteServicioResponse.setIdServicio(ServicioDto.CONVERT_DTO.apply(clienteClienteServicioEntity.getIdServicio()));
		//clienteClienteServicioResponse.setIdCliente(ClienteDto.CONVERT_DTO.apply(clienteClienteServicioEntity.getIdCliente()));

		return clienteClienteServicioResponse;

	};

	public static final Function <ClienteClienteServicioDto, ClienteServicioEntity> CONVERT_ENTITY = (ClienteClienteServicioDto clienteClienteServicioDto) -> {

		ClienteServicioEntity clienteClienteServicioResponse = new ClienteServicioEntity();

		clienteClienteServicioResponse.setIdClienteClienteServicio(clienteClienteServicioDto.getIdClienteClienteServicio());
		clienteClienteServicioResponse.setIdCliente(ClienteDto.CONVERT_ENTITY.apply(clienteClienteServicioDto.getIdCliente()));
		clienteClienteServicioResponse.setIdServicio(ServicioDto.CONVERT_ENTITY.apply(clienteClienteServicioDto.getIdServicio()));

		return clienteClienteServicioResponse;
	};

}
