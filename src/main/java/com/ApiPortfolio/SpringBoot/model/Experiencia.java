
package com.ApiPortfolio.SpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Setter;

@Entity
@Setter
//No usamos @Getter  puesto que no queremos que se devuelva el usuario
public class Experiencia implements IComponentes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario", referencedColumnName="id")
    private Usuario id_usuario;
    private String lugarNombre;
    private String puestoNombre;
    private String periodo;
    private String descripcion;    
    private String img_logo;

    public Long getId() {
        return id;
    }
    public String getImg_logo() {
        return img_logo;
    }public String getLugarNombre() {
        return lugarNombre;
    }public String getPuestoNombre() {
        return puestoNombre;
    }
    public String getPeriodo() {
        return periodo;
    }
    public String getDescripcion() {
        return descripcion;
    }    
    public void setId_usuarioById(Long id_usuario){
        this.id_usuario = new Usuario(id_usuario);
    }    
}
