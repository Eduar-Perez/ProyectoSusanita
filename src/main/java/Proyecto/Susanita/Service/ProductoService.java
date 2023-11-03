package Proyecto.Susanita.Service;

import java.util.List;

import Proyecto.Susanita.Dto.ProductoDto;
import Proyecto.Susanita.Entity.ProductoEntity;

public interface ProductoService {

	public ProductoDto agregarProducto(ProductoEntity producto) throws Exception;

	public ProductoDto modificarProducto(ProductoEntity producto) throws Exception;

	public ProductoDto buscarProducto(Integer id) throws Exception;

	public List <ProductoDto> obtenerListaProducto() throws Exception;

	public void borrarProducto(Integer id) throws Exception;

	
}
