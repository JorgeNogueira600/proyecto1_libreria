/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.servicios;

import com.example.demo.entidades.Autor;
import com.example.demo.entidades.Editorial;
import com.example.demo.entidades.Libro;
import com.example.demo.repositorios.AutorRepositorio;
import com.example.demo.repositorios.EditorialRepositorio;
import com.example.demo.repositorios.LibroRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class LibroService {
    
    @Autowired
    private LibroRepositorio libroRepositorio;
    
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @Autowired
    private EditorialRepositorio editorialRepositorio;
    
    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Autor autor, Editorial editorial) {
        Libro libro = new Libro();

        libro.setISBN(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplares_prestados(ejemplaresPrestados);
        libro.setEjemplares_restantes(libro.getEjemplares() - libro.getEjemplares_prestados());
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libro.setAlta(true);

        libroRepositorio.save(libro);
    }
    
    @Transactional
    public void modificarLibro(Long isbn, String titulo, Integer anio, Integer ejemplares){
        libroRepositorio.modificarLibro(isbn, titulo, anio, ejemplares);
    }
    
    public List<Libro> mostrarLibros(){
        return libroRepositorio.findAll();
    }
    
}
