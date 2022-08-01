package com.ApiPortfolio.SpringBoot.DTO;

import com.ApiPortfolio.SpringBoot.model.Educacion;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducacionDTO {
    private List<Educacion> educaciones;
    private Long id_usuario;

    public EducacionDTO() {
    }

    public EducacionDTO(List<Educacion> educaciones, Long id_usuario) {
        this.educaciones = educaciones;
        this.id_usuario = id_usuario;
    }
    

    public List<Educacion> obtenerDatosInicializandoUsuario(){
        for (int i = 0; i < educaciones.size(); i++) {
            educaciones.get(i).setId_usuarioById(id_usuario);
        }
        return educaciones;
    }
}
