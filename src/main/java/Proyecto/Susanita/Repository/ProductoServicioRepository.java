package Proyecto.Susanita.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Proyecto.Susanita.Entity.ServicioProductoEntity;

@Repository

public interface ProductoServicioRepository extends JpaRepository<ServicioProductoEntity, Integer> {

}
