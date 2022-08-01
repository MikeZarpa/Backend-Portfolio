package com.ApiPortfolio.SpringBoot.service;

import com.ApiPortfolio.SpringBoot.model.Educacion;
import com.ApiPortfolio.SpringBoot.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    @Autowired
    private EducacionRepository educacionRepo;
    
    @Override
    public void save(Educacion entidad) {
        educacionRepo.save(entidad);
    }

    @Override
    public void save(List<Educacion> listaEntidades) {
        educacionRepo.saveAll(listaEntidades);
    }

    @Override
    public void delete(Long id) {
        educacionRepo.deleteById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        educacionRepo.deleteAllById(ids);
    }

    @Override
    public Educacion find(Long id) {
        return educacionRepo.findById(id).orElse(null);
    }
    
}
