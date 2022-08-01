package com.ApiPortfolio.SpringBoot.repository;

import com.ApiPortfolio.SpringBoot.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad,Long> {

}
