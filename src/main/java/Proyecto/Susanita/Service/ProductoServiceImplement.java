package Proyecto.Susanita.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Proyecto.Susanita.Dto.ProductoDto;
import Proyecto.Susanita.Entity.ProductoEntity;
import Proyecto.Susanita.Repository.ProductoRepository;

@Service

public class ProductoServiceImplement implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public ProductoDto agregarProducto(ProductoEntity producto) throws Exception {

		ProductoEntity productoResponse = new ProductoEntity();

		if(producto.getId() != null && productoRepository.existsById(producto.getId()) ) {
			throw new Exception("YA EXISTE UN REGISTRO CON EL MISMO ID");
		}
		else {
			try {
				productoResponse = productoRepository.save(producto);

			} catch (Exception error) {
				throw new Exception("OCURRIO UN ERROR GUARDANDO EL REGISTRO.");
			}
		}
		return ProductoDto.CONVERT_DTO.apply(productoResponse);
	}

	@Override
	public ProductoDto modificarProducto(ProductoEntity producto) throws Exception {

		ProductoEntity productoResponse = new ProductoEntity();

		if (producto.getId() != null && productoRepository.existsById(producto.getId())) {
			try {
				productoResponse = productoRepository.save(producto);

			} catch (Exception error) {
				throw new Exception("OCURRIO UN ERROR MODIFICANDO EL PRODUCTO.");
			}
		}
		else {
			throw new Exception("NO EXISTEN REGISTROS SIMILARES PARA MODIFICAR.");
		}

		return ProductoDto.CONVERT_DTO.apply(productoResponse);
	}

	@Override
	public ProductoDto buscarProducto(Integer id) throws Exception {

		Optional<ProductoEntity> productoResponse = null;

		if (productoRepository.existsById(id)) {
			try {
				productoResponse = productoRepository.findById(id);

			} catch (Exception error) {
				throw new Exception("OCURRIO UN ERROR OBTENIENDO EL REGISTRO REQUERIDO.");
			}
		}

		return ProductoDto.CONVERT_DTO.apply(productoResponse.get()) ;
	}

	@Override
	public List<ProductoDto> obtenerListaProducto() throws Exception {

		List<ProductoEntity> listaProductoEntity = new ArrayList<>();
		List<ProductoDto> listaResponse = new ArrayList<>();

		listaProductoEntity = productoRepository.findAll();
		listaProductoEntity.forEach(item -> {
			listaResponse.add(ProductoDto.CONVERT_DTO.apply(item));
		});

		return listaResponse;
	}

	@Override
	public void borrarProducto(Integer id) throws Exception {
		if (productoRepository.existsById(id)) {
			try {
				productoRepository.deleteById(id);
			} catch (Exception error) {
				throw new Exception("OCURRIO UN ERROR ELIMINADO EL REGISTRO");
			}
		}
		else {
			throw new Exception("NO EXISTEN REGISTROS SIMILARES PARA ELIMINAR");
		}
	}


}
