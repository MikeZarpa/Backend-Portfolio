package com.ApiPortfolio.SpringBoot.Controller;

import com.ApiPortfolio.SpringBoot.DTO.DatosDTO;
import com.ApiPortfolio.SpringBoot.model.Educacion;
import com.ApiPortfolio.SpringBoot.model.Experiencia;
import com.ApiPortfolio.SpringBoot.model.Habilidad;
import com.ApiPortfolio.SpringBoot.model.OnlyUsuario;
import com.ApiPortfolio.SpringBoot.model.Proyecto;
import com.ApiPortfolio.SpringBoot.model.Usuario;
import com.ApiPortfolio.SpringBoot.security.dto.Mensaje;
import com.ApiPortfolio.SpringBoot.service.IEducacionService;
import com.ApiPortfolio.SpringBoot.service.IExperienciaService;
import com.ApiPortfolio.SpringBoot.service.IHabilidadService;
import com.ApiPortfolio.SpringBoot.service.IOnlyUsuarioService;
import com.ApiPortfolio.SpringBoot.service.IProyectoService;
import com.ApiPortfolio.SpringBoot.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
public class ControllerAlta {
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/save/*").allowedOrigins("*").allowedMethods("POST");
                registry.addMapping("/delete/*").allowedOrigins("*").allowedMethods("DELETE");
                registry.addMapping("/Usuarios").allowedOrigins("*").allowedMethods("GET");
                registry.addMapping("/Usuarios/*").allowedOrigins("*").allowedMethods("GET");
                registry.addMapping("/auth/*").allowedOrigins("*").allowedMethods("POST");
            }
        };
    }
    
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IHabilidadService habilidadService;
    @Autowired
    private IExperienciaService experienciaService;
    @Autowired
    private IProyectoService proyectoService;    
    @Autowired
    private IEducacionService educacionService;
    @Autowired
    private IOnlyUsuarioService onlyUsuarioService;
    
    @PostMapping("/save/Usuario")
    public ResponseEntity<?> altaUsuario(@RequestBody Usuario usuario){
        try{  
            usuarioService.save(usuario);
        }
        catch(Exception e){
            return new ResponseEntity(new Mensaje("Error en los datos."),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new Mensaje("Usuario Salvado."),HttpStatus.CREATED);
    }
        @PostMapping("/save/OnlyUsuario")
    public ResponseEntity<?> altaOnlyUsuario(@RequestBody OnlyUsuario usuario){
        try{
            onlyUsuarioService.save(usuario);
        }
        catch(Exception e){
            return new ResponseEntity(new Mensaje("Error en los datos."),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new Mensaje("Usuario Salvado."),HttpStatus.CREATED);
        
    }

    @PostMapping("/save/Habilidad")    
    public ResponseEntity<?> altaHabilidad(@RequestBody DatosDTO<Habilidad> datosDTO){
        try{            
            habilidadService.save(datosDTO.obtenerDatosInicializandoUsuario());
        }
        catch(DataIntegrityViolationException e){
            return new ResponseEntity(new Mensaje("Error en los datos."),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new Mensaje("Habilidad Salvada."),HttpStatus.CREATED);        
    }
    
    @PostMapping("/save/Experiencia")
    public ResponseEntity<?> altaExperiencia(@RequestBody DatosDTO<Experiencia> datosDTO){
        try{            
            experienciaService.save(datosDTO.obtenerDatosInicializandoUsuario());
        }
        catch(DataIntegrityViolationException e){
            return new ResponseEntity(new Mensaje("Error en los datos."),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new Mensaje("Experiencia Salvada."),HttpStatus.CREATED);     
    }
    
    @PostMapping("/save/Proyecto")
    public ResponseEntity<?> altaProyecto(@RequestBody DatosDTO<Proyecto> datosDTO){
        try{            
            proyectoService.save(datosDTO.obtenerDatosInicializandoUsuario());
        }
        catch(DataIntegrityViolationException e){
            return new ResponseEntity(new Mensaje("Error en los datos."),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new Mensaje("Proyecto Salvado."),HttpStatus.CREATED);        
    }
   
    @PostMapping("/save/Educacion")
    public ResponseEntity<?> altaEducacion(@RequestBody DatosDTO<Educacion> datosDTO){
        try{            
            educacionService.save(datosDTO.obtenerDatosInicializandoUsuario());
        }
        catch(DataIntegrityViolationException e){
            return new ResponseEntity(new Mensaje("Error en los datos."),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new Mensaje("Educación Salvada."),HttpStatus.CREATED);
    }
}
