package com.ApiPortfolio.SpringBoot.Controller;

import com.ApiPortfolio.SpringBoot.repository.EducacionRepository;
import com.ApiPortfolio.SpringBoot.repository.ExperienciaRepository;
import com.ApiPortfolio.SpringBoot.repository.HabilidadRepository;
import com.ApiPortfolio.SpringBoot.repository.ProyectoRepository;
import com.ApiPortfolio.SpringBoot.repository.UsuarioRepository;
import com.ApiPortfolio.SpringBoot.security.dto.Mensaje;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> borrarUsuario(@RequestBody Long id){
        usuarioRepo.deleteById(id);
        return new ResponseEntity(new Mensaje("Usuario Borrado."),HttpStatus.OK);
    }    

    @DeleteMapping("/delete/Habilidad")
    public ResponseEntity<?> borrarHabilidad(@RequestBody ArrayList<Long> ids){
        habilidadRepo.deleteAllById(ids);
        return new ResponseEntity(new Mensaje("Habilidad Borrada."),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/Experiencia")
    public ResponseEntity<?> borrarExperiencia(@RequestBody ArrayList<Long> ids){
        experienciaRepo.deleteAllById(ids);
        return new ResponseEntity(new Mensaje("Experiencia Borrada."),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/Proyecto")
    public ResponseEntity<?> borrarProyecto(@RequestBody ArrayList<Long> ids){
        proyectoRepo.deleteAllById(ids);
        return new ResponseEntity(new Mensaje("Proyecto Borrado."),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/Educacion")
    public ResponseEntity<?> borrarEducacion(@RequestBody ArrayList<Long> ids){
        educacionRepo.deleteAllById(ids);
        return new ResponseEntity(new Mensaje("Educación Borrada."),HttpStatus.OK);
    }    
}
