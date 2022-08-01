/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiPortfolio.SpringBoot.DTO;

import com.ApiPortfolio.SpringBoot.model.Habilidad;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Immutable;

/**
 *
 * @author MikeZarpa
 */
//@Entity
@Getter @Setter
@Immutable
@Table(name="usuario")
public class Perfil {
    @Id
    private Long id;
    private String nombre;
    private String titulo;
    private String img_banner;
    private String img_perfil;
    private String resumenPerfil;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_habilidad", referencedColumnName="id_usuario")
    private List<Habilidad> habilidades = new ArrayList<Habilidad>();  
    
}
