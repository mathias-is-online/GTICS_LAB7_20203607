package com.example.lab720203607.controller;


import com.example.lab720203607.dto.EquiposxPais;
import com.example.lab720203607.repository.LocationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/estadisticas")
public class EstadisticasController {

    final LocationRepository locationRepository;

    public EstadisticasController(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    @GetMapping(value = {"", "/list","/"})
    public String estats(Model model){


        List<EquiposxPais> listapaises = locationRepository.equiposxpais();

        model.addAttribute("listapaises", listapaises);
        return "stats/paisesxsitio";
    }

}
