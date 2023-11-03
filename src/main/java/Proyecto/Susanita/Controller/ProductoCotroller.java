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

import Proyecto.Susanita.Dto.ProductoDto;
import Proyecto.Susanita.Entity.ProductoEntity;
import Proyecto.Susanita.Service.ProductoService;

@RestController
@RequestMapping ("/producto")

public class ProductoCotroller {

	@Autowired
	private ProductoService productoService;

	@PostMapping ("/añadir")
	public ProductoDto añadirProducto (@RequestBody ProductoDto producto) throws Exception {

		ProductoEntity productoEntity = ProductoDto.CONVERT_ENTITY.apply(producto);
		productoService.agregarProducto(productoEntity);

		return ProductoDto.CONVERT_DTO.apply(productoEntity);

	}

	@PutMapping ("/modificar")
	public ProductoDto modificarProducto (@RequestBody ProductoDto producto) throws Exception {

		ProductoEntity productoEntity = ProductoDto.CONVERT_ENTITY.apply(producto);
		productoService.modificarProducto(productoEntity);

		return ProductoDto.CONVERT_DTO.apply(productoEntity);
	}

	@GetMapping ("/obtenerProducto/{id}")
	public ProductoDto modificarProducto (@PathVariable Integer id) throws Exception {

		return productoService.buscarProducto(id);
	}

	@GetMapping ("/obtenerLista")
	public List<ProductoDto> obtenerListaProductos () throws Exception {

		return productoService.obtenerListaProducto();
	}

	@DeleteMapping ("/borrar/{id}")
	public void borrarProducto (Integer id) throws Exception {

		productoService.borrarProducto(id);
	}

}
