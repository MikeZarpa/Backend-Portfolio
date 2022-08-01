package com.ApiPortfolio.SpringBoot.service;

import com.ApiPortfolio.SpringBoot.model.Experiencia;
import com.ApiPortfolio.SpringBoot.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepo;
    @Override
    public void save(Experiencia entidad) {
        experienciaRepo.save(entidad);
    }

    @Override
    public void save(List<Experiencia> listaEntidades) {
        experienciaRepo.saveAll(listaEntidades);
    }

    @Override
    public void delete(Long id) {
        experienciaRepo.deleteById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        experienciaRepo.deleteAllById(ids);
    }

    @Override
    public Experiencia find(Long id) {
        return experienciaRepo.findById(id).orElse(null);
    }
    
}
