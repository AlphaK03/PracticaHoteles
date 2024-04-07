package com.example.practicaexameni.logic;

import com.example.practicaexameni.data.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service("service")
public class Service {
    @Autowired
    private HotelRepository hotelRepository;
    public Iterable<Hotel> hotelFindAll(){
        return hotelRepository.findAll();
    }

    public List<Hotel> obtenerHoteles() {
        return hotelRepository.getHoteles();
    }

    public List<Hotel> obtenerTop3() {
        return hotelRepository.findTop3();
    }

    public List<Hotel> buscarHoteles(String keyword) {
        return hotelRepository.findByName(keyword);
    }

    public Hotel obtenerHotelPorId(String hotelId) {
        return hotelRepository.findById(hotelId);
    }

    public void agregarCalificacion(Hotel hotel, Calificacion nuevaCalificacion) {
        hotelRepository.addCalificacion(hotel.getId(), nuevaCalificacion);
    }
}
