package Proyecto.Susanita.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Proyecto.Susanita.Entity.ServicioEntity;

@Repository

public interface ServicioRepository extends JpaRepository<ServicioEntity, Integer> {

}
