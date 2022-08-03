
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
//No usamos @Getter puesto que no queremos que se devuelva el usuario
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario", referencedColumnName="id")
    private Usuario id_usuario;
    private String fecha;
    private String nombre;
    private String descripcion;
    private String link;
    private String img_logo;

    public Long getId() {
        return id;
    }
    public String getFecha() {
        return fecha;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getLink() {
        return link;
    }
    public String getImg_logo() {
        return img_logo;
    }    
    public void setId_usuarioById(Long id_usuario){
        this.id_usuario = new Usuario(id_usuario);
    }    
}
