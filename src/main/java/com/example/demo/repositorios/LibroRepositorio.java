/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositorios;

import com.example.demo.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.*;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String>{
    @Modifying  
    
    @Query("UPDATE Libro l SET l.titulo = :titulo, l.anio = :anio, l.ejemplares = :ejemplares ,  WHERE l.id = :id")
    void modificarLibro(@Param ("id") Long id, @Param("titulo") String titulo, @Param("anio")
    Integer anio, @Param("ejemplares") Integer ejemplares);
    
    @Modifying
    @Query("UPDATE Libro l SET l.alta = false WHERE l.id = :id")
    void eliminarLibro(@Param("id") String id);
    
    @Query(" SELECT l FROM Libro WHERE l.alta = true")
    List<Libro> mostrarLibros();
    
    
}
