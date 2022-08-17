
package com.ApiPortfolio.SpringBoot.model;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Setter;

@Entity
@Setter
//No usamos @Getter puesto que no queremos que se devuelva el usuario
public class Habilidad implements IComponentes {
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
    public String getNombre() {
        return nombre;
    }
    public int getPorcentaje() {
        return porcentaje;
    }
    public String getTipo() {
        return tipo;
    }
    public void setId_usuarioById(Long id_usuario){
        this.id_usuario = new Usuario(id_usuario);
    }
    /*public boolean esValido(){
        return !(nombre.isEmpty()||tipo.isEmpty()|| (porcentaje<=0) );
    }*/
}
