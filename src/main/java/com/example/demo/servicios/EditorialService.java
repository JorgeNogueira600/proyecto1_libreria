/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.servicios;

import com.example.demo.entidades.Autor;
import com.example.demo.entidades.Editorial;
import com.example.demo.repositorios.AutorRepositorio;
import com.example.demo.repositorios.EditorialRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class EditorialService {
    @Autowired
    private EditorialRepositorio editorialRepositorio;
    
    @Transactional
    public void crearEditorial(String nombre){        
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorialRepositorio.save(editorial);
    }
    
    @Transactional
    public Editorial buscarEditorial(String id){
        Optional<Editorial> editorialOptional = editorialRepositorio.findById(id);
        return editorialOptional.orElse(null);
    }
    
    @Transactional
    public List<Editorial> buscarEditoriales(){
        return editorialRepositorio.findAll();
    }
    
    @Transactional
    public void modificarEditoriales(String id, String nombre){
        editorialRepositorio.modificarEditorial(id, nombre);
    }
    
    @Transactional
    public void eliminarEditorial(String id){
        editorialRepositorio.eliminarEditorial(id);
    }
}
