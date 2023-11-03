package Proyecto.Susanita.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Proyecto.Susanita.Entity.ServicioEmpleadoEntity;

@Repository
public interface ServicioEmpleadoRepository extends JpaRepository<ServicioEmpleadoEntity, Integer> {

}
