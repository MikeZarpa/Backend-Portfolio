package com.ApiPortfolio.SpringBoot.service;

import java.util.List;

public interface IFuncionesBasicas<t> {
    public void save(t entidad);
    //Crea o guarda cambios de una lista
    public void save(List<t> listaEntidades);
    //Borra según el Id;
    public void delete(Long id);
    //Borra según una lista de Ids
    public void delete(List<Long>ids);
    //Recupera una entidad según la Id
    public t find(Long id);
}
