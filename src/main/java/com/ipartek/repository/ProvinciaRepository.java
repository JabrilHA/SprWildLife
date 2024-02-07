package com.ipartek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer>{

}
