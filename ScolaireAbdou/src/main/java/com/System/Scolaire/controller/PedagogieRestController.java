package com.System.Scolaire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.System.Scolaire.model.Dto.PedagogieDto;
import com.System.Scolaire.service.PedagogieService;

@RestController
@RequestMapping("/Pedagogie")

public class PedagogieRestController {

    @Autowired
    private PedagogieService pedagogieService;

    @GetMapping("/get_AllPedagogie")
    public ResponseEntity<List<PedagogieDto>> getAllPedagogie() {

        return new ResponseEntity<>(pedagogieService.GetAllPedagogie(), HttpStatus.OK);
    }

    @GetMapping("/get_Pedagogie")
    public PedagogieDto getPedagogie(@RequestParam Integer Id) {

        return pedagogieService.GetPedagogieID(Id);
    }

    @GetMapping("/get_PedagogieWithTitle")
    public PedagogieDto getPedagogieWithTitle(@RequestParam String title) {

        return pedagogieService.GetPedagogieWithTitle(title);
    }

    @PostMapping("/save")
    public PedagogieDto Save(@RequestBody PedagogieDto pedagogieDto) {
        // System.out.println(studentDto);

        return pedagogieService.SavePedagogie(pedagogieDto);
    }

    @GetMapping("/Delete")
    public void Delete(@RequestParam Integer id) {
        pedagogieService.DeletePedagogie(id);
    }

    @PutMapping("/Update")
    public PedagogieDto Update(@RequestBody PedagogieDto pedagogieDto) {
        return pedagogieService.SavePedagogie(pedagogieDto);
    }
}
