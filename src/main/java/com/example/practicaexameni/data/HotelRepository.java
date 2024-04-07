package com.example.practicaexameni.data;

import com.example.practicaexameni.logic.Calificacion;
import com.example.practicaexameni.logic.Hotel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component ("hotelRepository")
public class HotelRepository {
    List<Hotel> hoteles;

    public void setHoteles(List<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    public List<Hotel> getHoteles() {
        return hoteles;
    }

    public void save (Hotel hotel){
        hoteles.add(hotel.clone());
    }
    public void addCalificacion (String id, Calificacion calificacion){
        Hotel hotel = hoteles.stream()
                .filter(h-> h.getId().equals(id))
                .findFirst().get();
        hotel.getCalificaciones().add(calificacion.clone());
    }
    public Hotel findById(String id){
        Hotel hotel = hoteles.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst().get();
        return hotel.clone();
    }
    public List<Hotel> findAll(){
        return hoteles;
    }
    public List<Hotel> findTop3(){
        return hoteles.stream()
                .sorted((h1,h2)->Double.compare(h2.calificacion(),h1.calificacion()))
                .limit(3)
                .collect(Collectors.toList());
    }
    public List<Hotel> findByName (String name){
        return hoteles.stream()
                .filter(h-> h.getNombre().contains(name))
                .sorted ((h1,h2)->Double.compare(h2.calificacion(), h1.calificacion()))
                .collect(Collectors.toList());
    }
    public HotelRepository (){
        hoteles= new ArrayList<Hotel>();
        Hotel h;
        h = new Hotel("111", "Las Hortencias");
        h.getCalificaciones().add(new Calificacion("Juan", "Nel",1));
        h.getCalificaciones().add(new Calificacion("Maria", "Maso",3));
        hoteles.add(h);

        h = new Hotel("222", "Cocles");
        h.getCalificaciones().add(new Calificacion("Pedro", "Fantastico", 5));
        hoteles.add(h);

        h = new Hotel("333", "Fox");
        h.getCalificaciones().add(new Calificacion("Bayron", "Pésimo Servicio", 1));
        hoteles.add(h);

        h = new Hotel("444", "Valencia");
        h.getCalificaciones().add(new Calificacion("Abigail", "Aceptable", 4));
        hoteles.add(h);
    }
}
