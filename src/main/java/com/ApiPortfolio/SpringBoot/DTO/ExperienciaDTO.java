package com.ApiPortfolio.SpringBoot.DTO;

import com.ApiPortfolio.SpringBoot.model.Experiencia;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienciaDTO {
    private List<Experiencia> experiencias;
    private Long id_usuario;

    public ExperienciaDTO() {
    }

    public ExperienciaDTO(List<Experiencia> experiencias, Long id_usuario) {
        this.experiencias = experiencias;
        this.id_usuario = id_usuario;
    }
    

    public List<Experiencia> obtenerDatosInicializandoUsuario(){
        for (int i = 0; i < experiencias.size(); i++) {
            experiencias.get(i).setId_usuarioById(id_usuario);
        }
        return experiencias;
    }
}
