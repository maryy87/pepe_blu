package com.example.pepe.blu.controller;

import com.example.pepe.blu.filters.FiltroPiattoRequest;
import com.example.pepe.blu.dto.request.PiattoRequest;
import com.example.pepe.blu.dto.PiattoResponse;
import com.example.pepe.blu.service.PiattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/piatto")
public class PiattoController {

    @Autowired
    private PiattoService piattoService;

    @PostMapping("/ricercaGlobalePiatto")
    public ResponseEntity<List<PiattoResponse>> ricercaGlobalePiatto(@RequestBody FiltroPiattoRequest filtroPiattoRequest) {
        List<PiattoResponse> piattoResponseList=piattoService.ricercaGlobalePiatto(filtroPiattoRequest);
        if (piattoResponseList != null) {
            return ResponseEntity.ok(piattoResponseList);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/addPiatto")
    public ResponseEntity<PiattoResponse> addPiatto(@RequestBody PiattoRequest piattoRequest) {
        PiattoResponse piattoResponse = piattoService.addPiatto(piattoRequest);
        if (piattoResponse != null) {
            return ResponseEntity.ok(piattoResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/updatePiatto/{id}")
    public ResponseEntity<PiattoResponse> updatePiatto(@RequestBody PiattoRequest piattoRequest, @PathVariable int id) {
        PiattoResponse piattoResponse = piattoService.updatePiatto(piattoRequest, id);
        if (piattoResponse != null) {
            return ResponseEntity.ok(piattoResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletePiatto/{id}")
    public ResponseEntity<String> deletePiatto(@PathVariable int id) {
        Boolean b = piattoService.deletePiatto(id);
        if (b) {
            return ResponseEntity.ok("piatto rimosso");
        }
        return ResponseEntity.ofNullable("piatto non esiste ");
    }

    @GetMapping("/ricercaPiatto/{id}")
    public ResponseEntity<PiattoResponse> ricercaPiatto(@PathVariable int id) {
        PiattoResponse piattoResponse = piattoService.ricercaPiatto(id);
        if (piattoResponse != null) {
            return ResponseEntity.ok(piattoResponse);
        }
        return ResponseEntity.notFound().build();
    }

}
