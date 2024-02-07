package com.ipartek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.model.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer>{

}
