package com.ApiPortfolio.SpringBoot.DTO;

import com.ApiPortfolio.SpringBoot.model.Educacion;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducacionDTO {
    private List<Educacion> datos;
    private Long id_usuario;

    public EducacionDTO() {
    }

    public EducacionDTO(List<Educacion> educaciones, Long id_usuario) {
        this.datos = educaciones;
        this.id_usuario = id_usuario;
    }
    

    public List<Educacion> obtenerDatosInicializandoUsuario(){
        for (int i = 0; i < datos.size(); i++) {
            datos.get(i).setId_usuarioById(id_usuario);
        }
        return datos;
    }
}
