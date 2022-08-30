package com.ApiPortfolio.SpringBoot.service;

import com.ApiPortfolio.SpringBoot.model.OnlyUsuario;
import com.ApiPortfolio.SpringBoot.repository.OnlyUsuarioRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OnlyUsuarioService implements IOnlyUsuarioService {

    @Autowired
    private OnlyUsuarioRepository onlyUsuarioRepo;
    
    @Override
    public void save(OnlyUsuario entidad) {
        onlyUsuarioRepo.save(entidad);
    }

    @Override
    public void save(List<OnlyUsuario> listaEntidades) {
        onlyUsuarioRepo.saveAll(listaEntidades);
    }

    @Override
    public void delete(Long id) {
        onlyUsuarioRepo.deleteById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        onlyUsuarioRepo.deleteAllById(ids);
    }

    @Override
    public OnlyUsuario find(Long id) {
        return onlyUsuarioRepo.findById(id).orElse(null);
    }
    
}
