package Proyecto.Susanita.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Proyecto.Susanita.Entity.ProductoEntity;

@Repository

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

}
