package com.ApiPortfolio.SpringBoot.service;

import com.ApiPortfolio.SpringBoot.model.Usuario;
import com.ApiPortfolio.SpringBoot.repository.UsuarioRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepo;
    

    
    @Override
    public List<Usuario> getAll() {
        return usuarioRepo.findAll();
    }

    @Override
    public void save(Usuario entidad) {
        usuarioRepo.save(entidad);
    }

    @Override
    public void save(List<Usuario> listaEntidades) {
        usuarioRepo.saveAll(listaEntidades);
    }

    @Override
    public void delete(Long id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        usuarioRepo.deleteAllById(ids);
    }

    @Override
    public Usuario find(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }
}
