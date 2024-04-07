package com.example.practicaexameni.logic;

import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    @NotEmpty
    String id;
    @NotEmpty
    String nombre;
    List<Calificacion> calificaciones;

    public Hotel (String id, String nombre, List <Calificacion> calificaciones){
        this.id = id;
        this.nombre = nombre;
        this.calificaciones=calificaciones;
    }
    public Hotel (String id, String nombre){this(id, nombre, new ArrayList<>());}
    public Hotel (){this("","");}
    public Hotel clone(){
        return new Hotel(id, nombre, new ArrayList<>(calificaciones));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    //Promedio de las calificaciones
    //Promedio de las calificaciones
    public double calificacion(){
        if (calificaciones.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (Calificacion calificacion : calificaciones) {
            total += calificacion.getPuntaje();
        }
        return total / calificaciones.size();
    }

    public String calificacionesToString() {
        StringBuilder sb = new StringBuilder();
        for (Calificacion calificacion : calificaciones) {
            sb.append(calificacion.getNombre()).append(":(").append(calificacion.getPuntaje()).append("): ").append(calificacion.getComentario()).append("\n");
        }
        return sb.toString();
    }

}
