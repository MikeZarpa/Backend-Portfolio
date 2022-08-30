
package com.ApiPortfolio.SpringBoot.security.repository;

import com.ApiPortfolio.SpringBoot.security.entity.UsuarioS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioSRepository extends JpaRepository<UsuarioS,Long>{
    
    Optional<UsuarioS> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}
