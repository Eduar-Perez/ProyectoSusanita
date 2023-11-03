package Proyecto.Susanita.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Proyecto.Susanita.Entity.ClienteEntity;

@Repository

public interface ClienteRepository extends JpaRepository <ClienteEntity, Long>{

}
