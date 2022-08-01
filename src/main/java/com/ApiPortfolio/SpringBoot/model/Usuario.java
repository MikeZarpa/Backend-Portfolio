package com.ApiPortfolio.SpringBoot.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String titulo;
    private String img_banner;
    private String img_perfil;
    private String resumenPerfil; 
    //mappedBy hace referencia a una columna de mí tabla.
    @OneToMany(mappedBy = "id_usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Habilidad> habilidades = new ArrayList<Habilidad>();
    @OneToMany(mappedBy = "id_usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Experiencia> experiencias = new ArrayList<Experiencia>();
    @OneToMany(mappedBy = "id_usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Proyecto> proyectos = new ArrayList<Proyecto>();
    //mappedBy hace referencia al nombre de la variable que usamos aquí en SpringBoot
    @OneToMany(mappedBy = "id_usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Educacion> educaciones = new ArrayList<Educacion>();

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String titulo, String img_banner, String img_perfil, String resumenPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.img_banner = img_banner;
        this.img_perfil = img_perfil;
        this.resumenPerfil = resumenPerfil;
    }

    public Usuario(Long id) {
        this.id = id;
    }
}
