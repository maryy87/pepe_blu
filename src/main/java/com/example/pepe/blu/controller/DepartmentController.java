package com.example.pepe.blu.controller;

import com.example.pepe.blu.dto.request.DepartmentRequest;
import com.example.pepe.blu.dto.request.FiltroDepartementRequest;
import com.example.pepe.blu.dto.response.DepartmentResponse;
import com.example.pepe.blu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/ricercaDepartment")
    public ResponseEntity<List<DepartmentResponse>> ricercaDepartment(@RequestBody FiltroDepartementRequest filtroDepartementRequest){

        List<DepartmentResponse> departmentResponseList=departmentService.ricercaDepartment(filtroDepartementRequest);
        if (departmentResponseList != null) {
            return ResponseEntity.ok(departmentResponseList);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentResponse> addDepartment(@RequestBody DepartmentRequest departmentRequest) {
        DepartmentResponse departmentResponse = departmentService.addDepartment(departmentRequest);
        if (departmentResponse != null) {
            return ResponseEntity.ok(departmentResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/updateDepartment/{id}")
    public ResponseEntity<DepartmentResponse> updateDepartment(@RequestBody DepartmentRequest departmentRequest, @PathVariable int id) {
        DepartmentResponse departmentResponse = departmentService.updateDepartment(departmentRequest, id);
        if (departmentResponse != null) {
            return ResponseEntity.ok(departmentResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id) {
        Boolean b = departmentService.deleteDepartment(id);
        if (b) {
            return ResponseEntity.ok("department rimosso");
        }
        return ResponseEntity.ofNullable("department non esiste");
    }

    @GetMapping("/ricercaDepartment/{id}")
    public ResponseEntity<DepartmentResponse> ricercaDepartment(@PathVariable int id) {
        DepartmentResponse departmentResponse = departmentService.ricercaDepartment(id);
        if (departmentResponse != null) {
            return ResponseEntity.ok(departmentResponse);
        }
        return ResponseEntity.notFound().build();
    }


}
