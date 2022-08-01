package com.ApiPortfolio.SpringBoot.Controller;

import com.ApiPortfolio.SpringBoot.DTO.EducacionDTO;
import com.ApiPortfolio.SpringBoot.DTO.ExperienciaDTO;
import com.ApiPortfolio.SpringBoot.DTO.HabilidadDTO;
import com.ApiPortfolio.SpringBoot.DTO.Perfil;
import com.ApiPortfolio.SpringBoot.DTO.ProyectoDTO;
import com.ApiPortfolio.SpringBoot.model.Habilidad;
import com.ApiPortfolio.SpringBoot.model.Usuario;
import com.ApiPortfolio.SpringBoot.service.IEducacionService;
import com.ApiPortfolio.SpringBoot.service.IExperienciaService;
import com.ApiPortfolio.SpringBoot.service.IHabilidadService;
import com.ApiPortfolio.SpringBoot.service.IProyectoService;
import com.ApiPortfolio.SpringBoot.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerConsultar {
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
    
        
    @GetMapping("/Usuarios")
    @ResponseBody
    public List<Usuario> getUsuarios(){
        return usuarioService.getAll();
    }
    
    @GetMapping("/Usuarios/")
    @ResponseBody
    public Usuario getUsuario(@RequestParam Long id){
        return usuarioService.find(id);
    }
    
    
    

}
