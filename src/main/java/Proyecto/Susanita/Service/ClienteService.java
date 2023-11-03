package Proyecto.Susanita.Service;

import java.util.List;

import Proyecto.Susanita.Dto.ClienteDto;
import Proyecto.Susanita.Entity.ClienteEntity;

public interface ClienteService {

	public ClienteDto agregarCliente (ClienteEntity cliente) throws Exception;

	public ClienteDto agregarClienteManualmente(ClienteEntity cliente) throws Exception;

	public ClienteDto modificarCliente (ClienteEntity cliente) throws Exception;

	public ClienteDto buscarCliente (Long id) throws Exception;

	public List <ClienteDto> obtenerListaCliente () throws Exception;

	public void borrarCliente (Long id) throws Exception;


}
