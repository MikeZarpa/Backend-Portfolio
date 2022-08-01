/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ApiPortfolio.SpringBoot.service;

import com.ApiPortfolio.SpringBoot.model.Usuario;
import java.util.List;


public interface IUsuarioService extends IFuncionesBasicas<Usuario>{
    public List<Usuario> getAll();
}
