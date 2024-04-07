package com.example.practicaexameni.presentation;

import com.example.practicaexameni.logic.Calificacion;
import com.example.practicaexameni.logic.Hotel;
import com.example.practicaexameni.logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@org.springframework.stereotype.Controller("hoteles")
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/")
    public String showView(Model model) {

        List<Hotel> hoteles = service.obtenerTop3();

        model.addAttribute("hoteles", hoteles);

        return "view";
    }

    @GetMapping("/buscar")
    public String buscarHoteles(String keyword, Model model) {
        List<Hotel> hotelesEncontrados = service.buscarHoteles(keyword);
        model.addAttribute("hoteles", hotelesEncontrados);
        return "view";
    }

    @GetMapping("/calificacion/{hotelId}")
    public String mostrarFormularioCalificacion(@PathVariable String hotelId, Model model) {
        Hotel hotel = service.obtenerHotelPorId(hotelId);
        model.addAttribute("hotel", hotel);

        return "calificacion";
    }

    @PostMapping("/guardar-calificacion")
    public String guardarCalificacion(Calificacion calificacionForm, @RequestParam("hotelId") String hotelId) {

        Hotel hotel = service.obtenerHotelPorId(hotelId);

        Calificacion nuevaCalificacion = new Calificacion();
        nuevaCalificacion.setNombre(calificacionForm.getNombre());
        nuevaCalificacion.setComentario(calificacionForm.getComentario());
        nuevaCalificacion.setPuntaje(calificacionForm.getPuntaje());

        service.agregarCalificacion(hotel, nuevaCalificacion);

        return "redirect:/";
    }


}
