package com.ApiPortfolio.SpringBoot.Controller;

import com.ApiPortfolio.SpringBoot.repository.EducacionRepository;
import com.ApiPortfolio.SpringBoot.repository.ExperienciaRepository;
import com.ApiPortfolio.SpringBoot.repository.HabilidadRepository;
import com.ApiPortfolio.SpringBoot.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerBaja {
    
    @Autowired
    private UsuarioRepository usuarioRepo;
    @Autowired
    private HabilidadRepository habilidadRepo;
    @Autowired
    private ExperienciaRepository experienciaRepo;
    @Autowired
    private EducacionRepository educacionRepo;
    @Autowired
    private ProyectoRepository proyectoRepo;
    
    @DeleteMapping("/delete/Usuario")
    public void borrarUsuario(Long id){
        usuarioRepo.deleteById(id);
    }
    
    @DeleteMapping("/delete/Habilidad")
    public void borrarHabilidad(Long id){
        habilidadRepo.deleteById(id);
    }
    
    @DeleteMapping("/delete/Experiencia")
    public void borrarExperiencia(Long id){
        experienciaRepo.deleteById(id);
    }
    
    @DeleteMapping("/delete/Proyecto")
    public void borrarProyecto(Long id){
        proyectoRepo.deleteById(id);
    }
    
    @DeleteMapping("/delete/Educacion")
    public void borrarEducacion(Long id){
        educacionRepo.deleteById(id);
    }
    
}
