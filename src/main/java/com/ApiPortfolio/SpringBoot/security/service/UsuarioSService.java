
package com.ApiPortfolio.SpringBoot.security.service;

import com.ApiPortfolio.SpringBoot.security.entity.UsuarioS;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ApiPortfolio.SpringBoot.security.repository.UsuarioSRepository;

@Service
@Transactional
public class UsuarioSService {
    @Autowired
    UsuarioSRepository usuarioRepo;
    
    public Optional<UsuarioS> getByNombreUsuario(String nombreUsuario){
        return usuarioRepo.findByNombreUsuario(nombreUsuario);
    }
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepo.existsByNombreUsuario(nombreUsuario);
    }
    public boolean existsByEmail(String email){
        return usuarioRepo.existsByEmail(email);
    }
    public void save(UsuarioS usuario){
        usuarioRepo.save(usuario);
    }
}
