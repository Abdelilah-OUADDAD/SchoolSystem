package com.System.Scolaire.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.System.Scolaire.Mapper.PedagogieComponent;
import com.System.Scolaire.model.Dto.PedagogieDto;
import com.System.Scolaire.model.entity.Pedagogie;
import com.System.Scolaire.repository.PedagogieRepo;
import com.System.Scolaire.service.AnneeScolaireService;
import com.System.Scolaire.service.PedagogieService;
import com.System.Scolaire.service.SubjectService;
import com.System.Scolaire.service.TeacherService;

@Controller
public class PedagogieController {

    @Autowired
    private PedagogieService pedService;
    @Autowired
    private PedagogieRepo pedagogieRepo;
    @Autowired
    private PedagogieComponent pedComponent;
    @Autowired
    private TeacherService teachService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private AnneeScolaireService anneeService;

    // Controller for Show List of Pedagogie
    @GetMapping("/PedagogieList")
    public String getPedagogieList(Model model) {
        List<Pedagogie> p = pedService.GetAllPedagogie().stream().map(pedComponent::toEntity)
                .collect(Collectors.toList());
        model.addAttribute("pedagogies", p);

        return "Pedagogie/PedagogieList";
    }

    // Controller for Show a Pedagogie
    @GetMapping("/PedagogieShow/{id}")
    public String showPedagogie(@PathVariable Integer id, Model model) {

        Pedagogie p = pedagogieRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        model.addAttribute("pedagogie", p);

        return "Pedagogie/PedagogieShow";
    }

    // Controller for GET Add
    @GetMapping("/PedagogieAdd")
    public String showAddForm(Model model) {
        model.addAttribute("teachers", teachService.getAllTeachers());
        model.addAttribute("subjects", subjectService.GetAllSubject());
        model.addAttribute("annees", anneeService.getAllAnneeScolaire());
        return "Pedagogie/PedagogieAdd";
    }

    // Controller for Post Add
    @PostMapping("/PedagogieAdd")
    public String savePedagogie(@ModelAttribute PedagogieDto dto, Model model, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("teachers", teachService.getAllTeachers());
            model.addAttribute("subjects", subjectService.GetAllSubject());
            model.addAttribute("annees", anneeService.getAllAnneeScolaire());
            return "Pedagogie/PedagogieAdd";
        }
        dto.setCreated_at(LocalDateTime.now());
        pedService.SavePedagogie(dto);

        return "redirect:/PedagogieList";
    }

    // Controller for Get Edit
    @GetMapping("/PedagogieEdit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        // Pedagogie p = pedagogieRepo.findById(id)
        // .orElseThrow(() -> new RuntimeException("Not found"));

        model.addAttribute("pedagogie", pedService.GetPedagogieID(id));
        model.addAttribute("teachers", teachService.getAllTeachers());
        model.addAttribute("subjects", subjectService.GetAllSubject());
        model.addAttribute("annees", anneeService.getAllAnneeScolaire());

        return "Pedagogie/PedagogieEdit";
    }

    // Controller for Post Edit
    @PostMapping("/PedagogieEdit")
    public String updatePedagogie(@ModelAttribute PedagogieDto dto, Model model, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("teachers", teachService.getAllTeachers());
            model.addAttribute("subjects", subjectService.GetAllSubject());
            model.addAttribute("annees", anneeService.getAllAnneeScolaire());
            return "Pedagogie/PedagogieEdit";
        }
        pedService.SavePedagogie(dto);

        return "redirect:/PedagogieList";
    }

    // Controller for Delete
    @GetMapping("/PedagogieDelete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        pedService.DeletePedagogie(id);
        return "redirect:/PedagogieList";
    }
}
