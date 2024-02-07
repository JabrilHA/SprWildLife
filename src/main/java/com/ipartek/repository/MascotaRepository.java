package com.ipartek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipartek.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer>{

	@Query(value = "SELECT * FROM mascotas WHERE especie_id =:valor", nativeQuery = true)
	List<Mascota> obtenerMascotaPorEspecie(@Param("valor") int valor);
	
	
}
