package com.ApiPortfolio.SpringBoot.security.entity;

import com.sun.istack.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//Esta clase es UsuarioSegurity, funciona sobre la misma tabla usuario
//Pero agrega manejo de email, password y nombre de usuario.
@Entity
@Getter @Setter
@Table(name="usuario")
public class UsuarioS {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique=true)
    private String nombreUsuario;
    @NotNull
    @Column(unique=true)
    private String email;
    @NotNull
    private String password;
    
    public UsuarioS() {
    }

    public UsuarioS(String nombre, String nombreUsuario, String email, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }
    
}
