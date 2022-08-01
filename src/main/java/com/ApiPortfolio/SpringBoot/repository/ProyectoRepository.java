package com.ApiPortfolio.SpringBoot.repository;

import com.ApiPortfolio.SpringBoot.model.Proyecto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto,Long> {
   // @Query("SELECT t FROM Proyecto t WHERE t.id_usuario = ?1")
   // Optional<List<Proyecto>> findAllByUsuarioID(Long id);
}
