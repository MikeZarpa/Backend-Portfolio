package com.ApiPortfolio.SpringBoot.Controller;

import com.ApiPortfolio.SpringBoot.model.Usuario;
import com.ApiPortfolio.SpringBoot.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return new ResponseEntity(usuarioService.getAll(),HttpStatus.CREATED);
    }
    
    @GetMapping("/Usuarios/")
    @ResponseBody
    public ResponseEntity<Usuario> getUsuario(@RequestParam Long id){
        return new ResponseEntity(usuarioService.find(id),HttpStatus.OK);
    }
}
