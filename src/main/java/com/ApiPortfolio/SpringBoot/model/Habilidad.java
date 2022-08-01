
package com.ApiPortfolio.SpringBoot.model;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario", nullable=false,foreignKey = @ForeignKey(name = "fk_usuario_habilidad"))
    private Usuario id_usuario;
    private String nombre="";
    private int porcentaje=-1;
    private String tipo="";
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId_usuarioById(Long id_usuario){
        this.id_usuario = new Usuario(id_usuario);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Long idUsuario(){
        return this.id_usuario.getId();
        
    }
    public boolean esValido(){
        return !(nombre.isEmpty()||tipo.isEmpty()|| (porcentaje<=0) );
    }
}