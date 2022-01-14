package com.example.peliculas.controller;

import com.example.peliculas.model.Pelicula;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/pelicula")
public class PeliculasController {

    private final List<Pelicula> peliculaList = new ArrayList<Pelicula>();

    @GetMapping("/example")
    public String example(){
        return "Este es un ejemplo";
    }


    @GetMapping(path ="/get")
    public String getAll(){
        if(peliculaList.isEmpty()){
            return "No hay peliculas";
        }
        return peliculaList.toString();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id){
        for(Pelicula p : peliculaList){
            if(p.getId() == id){
                return p.toString();
            }
        }
        return "La ID pedida no existe";
    }

    @PostMapping("/post")
    public String create(@RequestBody Map<String,String> requestParam){

        String name = requestParam.get("name");
        String category = requestParam.get("category");
        Pelicula p = new Pelicula(name,category);
        peliculaList.add(p);
        p.setId(Long.parseLong(String.valueOf(peliculaList.size())));

        return "Se agrego una nueva pelicula con ID: " + peliculaList.size();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Pelicula peliculaUpdate){
        for(Pelicula p : peliculaList){
            if(p.getId() == id){
                p.setName(peliculaUpdate.getName());
                p.setCategory(peliculaUpdate.getCategory());
                return "Actualización con éxito";
            }
        }
        return "El ID no existe";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){

        if( id > peliculaList.size() || id == 0){
            return "El ID no existe";
        }
        peliculaList.remove(Math.toIntExact(id)-1);
        return "Eliminado con éxito";

    }

}
