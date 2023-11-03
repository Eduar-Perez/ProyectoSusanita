package Proyecto.Susanita.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Proyecto.Susanita.Entity.EmpleadoEntity;

@Repository

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {

}
