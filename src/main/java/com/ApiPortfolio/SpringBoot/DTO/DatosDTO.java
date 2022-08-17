package com.ApiPortfolio.SpringBoot.DTO;

import com.ApiPortfolio.SpringBoot.model.IComponentes;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DatosDTO<t extends IComponentes> {    
    private Long id_usuario;
    private List<t> datos;
    
    public DatosDTO() {
    }

    public DatosDTO(List<t> datos, Long id_usuario) {
        this.datos = datos;
        this.id_usuario = id_usuario;
    }
    

    public List<t> obtenerDatosInicializandoUsuario(){
        for (int i = 0; i < datos.size(); i++) {
            datos.get(i).setId_usuarioById(id_usuario);
        }
        return datos;
    }
}
