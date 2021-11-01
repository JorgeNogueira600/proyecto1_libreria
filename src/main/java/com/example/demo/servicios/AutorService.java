/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.servicios;

import com.example.demo.entidades.Autor;
import com.example.demo.repositorios.AutorRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class AutorService {
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @Transactional
    public void crearAutor(String nombre){        
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autorRepositorio.save(autor);
    }
    
    @Transactional
    public Autor buscarAutor(String id){
        Optional<Autor> autorOptional = autorRepositorio.findById(id);
        return autorOptional.orElse(null);
    }
    
    @Transactional
    public List<Autor> buscarAutores(){
        return autorRepositorio.findAll();
    }
    
    @Transactional
    public void modificarAutor(String id, String nombre){
        autorRepositorio.modificarAutor(id, nombre);
    }
    
    @Transactional
    public void eliminarAutor(String id){
        autorRepositorio.eliminarAutor(id);
    }
}
