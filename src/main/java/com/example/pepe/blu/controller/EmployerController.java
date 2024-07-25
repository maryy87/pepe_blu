package com.example.pepe.blu.controller;

import com.example.pepe.blu.dto.request.EmployerRequest;
import com.example.pepe.blu.dto.request.FiltroEmployerRequest;
import com.example.pepe.blu.dto.response.EmployerResponse;
import com.example.pepe.blu.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @PostMapping("/ricercaEmployer")
    public ResponseEntity<List<EmployerResponse>> ricercaEmployer(@RequestBody FiltroEmployerRequest filtroEmployerRequest) {
        List<EmployerResponse> employerResponseList = employerService.ricercaEmployer(filtroEmployerRequest);
        if (employerResponseList != null) {
         return    ResponseEntity.ok(employerResponseList);

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/addEmployer")
    public ResponseEntity<EmployerResponse> addEmployer(@RequestBody EmployerRequest employerRequest) {
        EmployerResponse employerResponse = employerService.addEmployer(employerRequest);
        if (employerResponse != null) {
            return ResponseEntity.ok(employerResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/updateEmployer/{id}")
    public ResponseEntity<EmployerResponse> updateEmployer(@RequestBody EmployerRequest employerRequest, @PathVariable int id) {
        EmployerResponse employerResponse = employerService.updateEmployer(employerRequest, id);
        if (employerResponse != null) {
            return ResponseEntity.ok(employerResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteEmployer/{id}")
    public ResponseEntity<String> deleteEmployer(@PathVariable int id) {
        Boolean b = employerService.deleteEmployer(id);
        if (b) {
            return ResponseEntity.ok("employer rimosso");

        }
        return ResponseEntity.ofNullable("employer non registrato");
    }

    @GetMapping("/ricercaEmployer/{id}")
    public ResponseEntity<EmployerResponse> ricercaEmployer(@PathVariable int id) {
        EmployerResponse employerResponse = employerService.ricercaEmployer(id);
        if (employerResponse != null) {
            return ResponseEntity.ok(employerResponse);
        }
        return ResponseEntity.notFound().build();
    }

}
