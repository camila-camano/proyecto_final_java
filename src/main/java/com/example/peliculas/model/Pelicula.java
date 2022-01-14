package com.example.peliculas.model;



public class Pelicula {

    private Long id;
    private String name;
    private String category;

    public Pelicula(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
