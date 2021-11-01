/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositorios;

import com.example.demo.entidades.Autor;
import com.example.demo.entidades.Libro;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String>{
    @Modifying
    @Query("UPDATE Autor a SET a.nombre = :nombre WHERE a.id = :id")
    void modificarAutor(@Param("id") String id, @Param("nombre") String nombre);
    
    @Modifying
    @Query("UPDATE Autor a SET a.alta = false WHERE a.id = :id")
    void eliminarAutor(@Param("id") String id);
}
