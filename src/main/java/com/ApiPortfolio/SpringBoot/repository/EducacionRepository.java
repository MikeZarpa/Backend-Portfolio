
package com.ApiPortfolio.SpringBoot.repository;

import com.ApiPortfolio.SpringBoot.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion,Long> {
}