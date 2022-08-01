package com.ApiPortfolio.SpringBoot.Controller;

import com.ApiPortfolio.SpringBoot.DTO.EducacionDTO;
import com.ApiPortfolio.SpringBoot.DTO.ExperienciaDTO;
import com.ApiPortfolio.SpringBoot.DTO.HabilidadDTO;
import com.ApiPortfolio.SpringBoot.DTO.ProyectoDTO;
import com.ApiPortfolio.SpringBoot.model.Usuario;
import com.ApiPortfolio.SpringBoot.service.IEducacionService;
import com.ApiPortfolio.SpringBoot.service.IExperienciaService;
import com.ApiPortfolio.SpringBoot.service.IHabilidadService;
import com.ApiPortfolio.SpringBoot.service.IProyectoService;
import com.ApiPortfolio.SpringBoot.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAlta {
    
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
    
        @PostMapping("/new/Usuario")
    public void altaUsuario(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
    }

    @PostMapping("/new/Habilidad")    
    public String altaHabilidad(@RequestBody HabilidadDTO habilidadDTO){
        try{            
            habilidadService.save(habilidadDTO.obtenerDatosInicializandoUsuario());
        }
        catch(DataIntegrityViolationException e){
            return "Ocurrió un error, ten encuenta que no puedes usar más de 255 caracteres o que el id de usuario debe ser valido.";
        }
        return("Nueva habilidad creada");         
    }
    
    @PostMapping("/new/Experiencia")
    public String altaExperiencia(@RequestBody ExperienciaDTO experienciaDTO){
        try{            
            experienciaService.save(experienciaDTO.obtenerDatosInicializandoUsuario());
        }
        catch(DataIntegrityViolationException e){
            return "Ocurrió un error, ten encuenta que no puedes usar más de 255 caracteres o que el id de usuario debe ser valido.";
        }
        return("Nueva experiencia creada");         
    }
    
    @PostMapping("/new/Proyecto")
    public String altaProyecto(@RequestBody ProyectoDTO proyectoDTO){
        try{            
            proyectoService.save(proyectoDTO.obtenerDatosInicializandoUsuario());
        }
        catch(DataIntegrityViolationException e){
            return "Ocurrió un error, ten encuenta que no puedes usar más de 255 caracteres o que el id de usuario debe ser valido.";
        }

        return("Nuevo proyecto creado");         
    }
   
    @PostMapping("/new/Educacion")
    public String altaEducacion(@RequestBody EducacionDTO educacionDTO){
        try{            
            educacionService.save(educacionDTO.obtenerDatosInicializandoUsuario());
        }
        catch(DataIntegrityViolationException e){
            return "Ocurrió un error, ten encuenta que no puedes usar más de 255 caracteres o que el id de usuario debe ser valido.";
        }
        return("Nueva educacion creada");  
    }
}
