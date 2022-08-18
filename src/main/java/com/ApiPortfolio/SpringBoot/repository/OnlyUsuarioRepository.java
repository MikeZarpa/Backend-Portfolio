package com.ApiPortfolio.SpringBoot.repository;

import com.ApiPortfolio.SpringBoot.model.OnlyUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnlyUsuarioRepository extends JpaRepository<OnlyUsuario,Long> {
}