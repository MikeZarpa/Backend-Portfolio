package com.ApiPortfolio.SpringBoot.Controller;

import com.ApiPortfolio.SpringBoot.repository.EducacionRepository;
import com.ApiPortfolio.SpringBoot.repository.ExperienciaRepository;
import com.ApiPortfolio.SpringBoot.repository.HabilidadRepository;
import com.ApiPortfolio.SpringBoot.repository.ProyectoRepository;
import com.ApiPortfolio.SpringBoot.repository.UsuarioRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public void borrarUsuario(@RequestBody Long id){
        usuarioRepo.deleteById(id);
    }    

    @DeleteMapping("/delete/Habilidad")
    public void borrarHabilidad(@RequestBody ArrayList<Long> ids){
        habilidadRepo.deleteAllById(ids);
    }
    
    @DeleteMapping("/delete/Experiencia")
    public void borrarExperiencia(@RequestBody ArrayList<Long> ids){
        experienciaRepo.deleteAllById(ids);
    }
    
    @DeleteMapping("/delete/Proyecto")
    public void borrarProyecto(@RequestBody ArrayList<Long> ids){
        proyectoRepo.deleteAllById(ids);
    }
    
    @DeleteMapping("/delete/Educacion")
    public void borrarEducacion(@RequestBody ArrayList<Long> ids){
        educacionRepo.deleteAllById(ids);
    }    
}
