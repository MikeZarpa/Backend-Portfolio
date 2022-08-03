package com.ApiPortfolio.SpringBoot.Controller;

import com.ApiPortfolio.SpringBoot.model.Usuario;
import com.ApiPortfolio.SpringBoot.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerConsultar {
    @Autowired
    private IUsuarioService usuarioService;   
        
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
