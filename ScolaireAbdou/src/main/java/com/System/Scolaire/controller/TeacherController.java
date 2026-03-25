package com.System.Scolaire.controller;

import com.System.Scolaire.model.Dto.TeacherDto;
import com.System.Scolaire.service.TeacherService;
import com.System.Scolaire.repository.DepartmentRepo;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private DepartmentRepo departmentRepo; // ✅ For dropdown

    // ✅ Show all teachers
    @GetMapping("/TeacherList")
    public String showTeacherList(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachersWithDetails());
        return "Teacher/TeacherList";
    }

    // ✅ Show teacher details
    @GetMapping("/TeacherShow/{id}")
    public String showTeacherDetails(@PathVariable("id") Integer id,
            Model model,
            RedirectAttributes redirectAttributes) {
        TeacherDto teacher = teacherService.getTeacherById(id);

        if (teacher == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Teacher not found!");
            return "redirect:/Teacher/TeacherList";
        }

        model.addAttribute("teacher", teacher);
        return "Teacher/TeacherShow";
    }

    // ✅ Show add form
    @GetMapping("/TeacherAdd")
    public String showAddForm(Model model) {
        model.addAttribute("teacher", new TeacherDto());
        model.addAttribute("department", departmentRepo.findAll()); // ✅ Dropdown
        return "Teacher/TeacherAdd";
    }

    // ✅ Save teacher
    @PostMapping("/TeacherAdd")
    public String saveTeacher(
            @Valid @ModelAttribute("teacher") TeacherDto teacherDto,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("department", departmentRepo.findAll()); // ✅ Re-load dropdown
            return "Teacher/TeacherAdd";
        }

        teacherService.saveTeacher(teacherDto);
        redirectAttributes.addFlashAttribute("successMessage", "Teacher added successfully!");

        return "redirect:/TeacherList";
    }

    // ✅ Show edit form
    @GetMapping("/TeacherEdit/{id}")
    public String showEditForm(@PathVariable("id") Integer id,
            Model model,
            RedirectAttributes redirectAttributes) {
        TeacherDto teacher = teacherService.getTeacherById(id);

        if (teacher == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Teacher not found!");
            return "redirect:/TeacherList";
        }

        model.addAttribute("teacher", teacher);
        model.addAttribute("department", departmentRepo.findAll()); // ✅ Dropdown
        return "Teacher/TeacherEdit";
    }

    // ✅ Update teacher
    @PostMapping("/TeacherEdit")
    public String updateTeacher(
            @Valid @ModelAttribute("teacher") TeacherDto teacherDto,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("department", departmentRepo.findAll()); // ✅ Re-load dropdown
            return "Teacher/TeacherEdit";
        }

        teacherService.updateTeacher(teacherDto);
        redirectAttributes.addFlashAttribute("successMessage", "Teacher updated successfully!");

        return "redirect:/TeacherList";
    }

    // ✅ Delete teacher
    @GetMapping("/TeacherDelete/{id}")
    public String deleteTeacher(@PathVariable("id") Integer id,
            RedirectAttributes redirectAttributes) {
        TeacherDto teacher = teacherService.getTeacherById(id);

        if (teacher == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Teacher not found!");
        } else {
            teacherService.deleteTeacher(id);
            redirectAttributes.addFlashAttribute("successMessage", "Teacher deleted successfully!");
        }

        return "redirect:/TeacherList";
    }

    // ✅ Filter by Specialite
    @GetMapping("/TeacherList/Department/{departmentId}")
    public String showTeachersBySpecialite(@PathVariable("DepartmentID") Integer departmentID,
            Model model) {
        model.addAttribute("teachers", teacherService.getTeachersByDepartment(departmentID));
        model.addAttribute("selectedSpecialite", departmentID);
        model.addAttribute("specialites", departmentRepo.findAll());
        return "Teacher/TeacherList";
    }
}