package com.ApiPortfolio.SpringBoot.service;

import com.ApiPortfolio.SpringBoot.model.Habilidad;
import com.ApiPortfolio.SpringBoot.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService {

    @Autowired
    private HabilidadRepository habilidadRepo;

    @Override
    public void save(Habilidad entidad) {
        habilidadRepo.save(entidad);
    }

    @Override
    public void save(List<Habilidad> listaEntidades) {
        habilidadRepo.saveAll(listaEntidades);
    }

    @Override
    public void delete(Long id) {
        habilidadRepo.deleteById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        habilidadRepo.deleteAllById(ids);
    }

    @Override
    public Habilidad find(Long id) {
        return habilidadRepo.findById(id).orElse(null);
    }
}
