package Proyecto.Susanita.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Proyecto.Susanita.Entity.ClienteServicioEntity;

@Repository

public interface ClienteServicioRepository extends JpaRepository<ClienteServicioEntity, Integer>  {

}
