package com.ApiPortfolio.SpringBoot.DTO;

import com.ApiPortfolio.SpringBoot.model.Proyecto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectoDTO {
    private List<Proyecto> datos;
    private Long id_usuario;

    public ProyectoDTO() {
    }
    
    public ProyectoDTO(List<Proyecto> proyectos, Long id_usuario) {
        this.datos = proyectos;
        this.id_usuario = id_usuario;
    }
    

    public List<Proyecto> obtenerDatosInicializandoUsuario(){
        for (int i = 0; i < datos.size(); i++) {
            datos.get(i).setId_usuarioById(id_usuario);
        }
        return datos;
    }
}
