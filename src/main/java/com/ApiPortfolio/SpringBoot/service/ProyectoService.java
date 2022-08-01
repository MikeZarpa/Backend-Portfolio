package com.ApiPortfolio.SpringBoot.service;

import com.ApiPortfolio.SpringBoot.model.Proyecto;
import com.ApiPortfolio.SpringBoot.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    private ProyectoRepository proyectoRepo;
    
    @Override
    public void save(Proyecto entidad) {
        proyectoRepo.save(entidad);
    }

    @Override
    public void save(List<Proyecto> listaEntidades) {
        proyectoRepo.saveAll(listaEntidades);
    }

    @Override
    public void delete(Long id) {
        proyectoRepo.deleteById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        proyectoRepo.deleteAllById(ids);
    }

    @Override
    public Proyecto find(Long id) {
        return proyectoRepo.findById(id).orElse(null);
    }
    
}
