package com.ApiPortfolio.SpringBoot.DTO;

import com.ApiPortfolio.SpringBoot.model.Habilidad;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HabilidadDTO {
    
    private List<Habilidad> datos;
    private Long id_usuario;

    public HabilidadDTO() {
    }

    public HabilidadDTO(List<Habilidad> habilidades, Long id_usuario) {
        this.datos = habilidades;
        this.id_usuario = id_usuario;
    }
    

    public List<Habilidad> obtenerDatosInicializandoUsuario(){
        for (int i = 0; i < datos.size(); i++) {
            datos.get(i).setId_usuarioById(id_usuario);
        }
        return datos;
    }

}
