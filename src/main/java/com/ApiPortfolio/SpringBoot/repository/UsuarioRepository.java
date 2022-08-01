/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ApiPortfolio.SpringBoot.repository;
import com.ApiPortfolio.SpringBoot.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    //Funcion en desuso
    @Query("SELECT t FROM Usuario t WHERE t.titulo = ?1")
    Optional<Usuario> findByTitulo(String titulo);
}
