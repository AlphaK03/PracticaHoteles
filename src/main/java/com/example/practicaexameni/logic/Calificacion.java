package com.example.practicaexameni.logic;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

public class Calificacion {
    @NotEmpty
    String nombre;
    String comentario;
    @NotEmpty
    int puntaje;
    @NotNull
    @Min(1)
    public Calificacion (String nombre, String comentario, int puntaje){
        this.nombre = nombre;
        this.comentario = comentario;
        this.puntaje = puntaje;
    }
    public Calificacion (){this("Anónimo", "",0);}
    public Calificacion clone (){
        return new Calificacion(nombre, comentario, puntaje);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
