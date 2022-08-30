
package com.ApiPortfolio.SpringBoot.security.entity;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//Se necesita una clase similar a UsuarioSegurity que implemente UserDetails
//Esto es para los servicios de Jwt, permite el manejo de autorizaciones.
//Pero como no filtramos por autorizaciones, devolvemos null en la lista de Autorizaciones.
public class UsuarioPrincipal implements UserDetails {

    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;

    public UsuarioPrincipal() {
    }

    public UsuarioPrincipal(String nombre, String nombreUsuario, String email, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }
    
    
    public static UsuarioPrincipal build(UsuarioS usuario){
        UsuarioPrincipal usPr = new UsuarioPrincipal();
        usPr.nombre=usuario.getNombre();
        usPr.email=usuario.getEmail();
        usPr.nombreUsuario=usuario.getNombreUsuario();
        usPr.password=usuario.getPassword();
        return usPr;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
