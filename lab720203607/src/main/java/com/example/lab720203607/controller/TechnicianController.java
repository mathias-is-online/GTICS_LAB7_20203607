package com.example.lab720203607.controller;


import com.example.lab720203607.entity.Technician;
import com.example.lab720203607.repository.TechnicianRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tecnicos")
public class TechnicianController {

    final TechnicianRepository technicianRepository;


    public TechnicianController(TechnicianRepository technicianRepository){
        this.technicianRepository = technicianRepository;
    }



    @GetMapping(value = {"", "/list","/"})
    public String listatecnicos(Model model) {

        List<Technician> listatecnicos = technicianRepository.findAll();

        model.addAttribute("listatecnicos", listatecnicos);
        return "tecnicos/lista";
    }

    @GetMapping("/new")
    public String nuevotecnico(Model model, @ModelAttribute("tecnico") Technician tecnico) {
        return "tecnicos/editarFrm";
    }



    @GetMapping("/edit")
    public String editartecnico(@ModelAttribute("tecnico") Technician tecnico,
                               Model model, @RequestParam("id") int id){


        Optional<Technician> optionalTechnician = technicianRepository.findById(id);

        if (optionalTechnician.isPresent()) {
            tecnico = optionalTechnician.get();
            model.addAttribute("tecnico", tecnico);
            return "tecnicos/editarFrm";
        } else {
            return "redirect:/tecnicos";
        }

    }



    @PostMapping("/save")
    public String guardartecnico(RedirectAttributes attr, Model model,
                                @ModelAttribute("tecnico") @Valid Technician tecnico, BindingResult bindingResult){

        if (!bindingResult.hasErrors()) { //si no hay errores

            if (tecnico.getTechnicianID() == 0) {
                attr.addFlashAttribute("msg", "Tecnico "+ tecnico.getFirstName() + " "+tecnico.getLastName()+  " creado exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Tecnico " + tecnico.getFirstName() + " "+tecnico.getLastName()+   " actualizado exitosamente");
            }

            technicianRepository.save(tecnico);
            return "redirect:/tecnicos";


        }else{ //hay almenos 1 error
            model.addAttribute("tecnico", tecnico);
            return "tecnicos/editarFrm";

        }
    }


    @GetMapping("/delete")
    public String borrartecnico(@RequestParam("id") int id){
        Optional<Technician> opt = technicianRepository.findById(id);
        if (opt.isPresent()) {
            technicianRepository.deleteById(id);
        }
        return "redirect:/tecnicos";
    }


}
