package com.example.pepe.blu.controller;

import com.example.pepe.blu.dto.request.FiltroTavoloRequest;
import com.example.pepe.blu.dto.request.TavoloRequest;
import com.example.pepe.blu.dto.response.TavoloResponse;
import com.example.pepe.blu.service.TavoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tavolo")
public class TavoloController {

    @Autowired
    private TavoloService tavoloService;

    @PostMapping("/findTavoloByFiltro")
    public ResponseEntity<List<TavoloResponse>> findTavoloByFiltro(@RequestBody FiltroTavoloRequest filtroTavoloRequest) {
       List<TavoloResponse> tavoloResponseList=tavoloService.findTavoloByFiltro(filtroTavoloRequest);
        if (tavoloResponseList != null) {
            return ResponseEntity.ok(tavoloResponseList);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/addTavolo")
    public ResponseEntity<TavoloResponse> addTavolo(@RequestBody TavoloRequest tavoloRequest) {
        TavoloResponse tavoloResponse = tavoloService.addTavolo(tavoloRequest);
        if (tavoloResponse != null) {
            return ResponseEntity.ok(tavoloResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/updateTavolo/{id}")
    public ResponseEntity<TavoloResponse> updateTavolo(@RequestBody TavoloRequest tavoloRequest, @PathVariable int id) {
        TavoloResponse tavoloResponse = tavoloService.updateTavolo(tavoloRequest, id);
        if (tavoloResponse != null) {
            return ResponseEntity.ok(tavoloResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteTavolo/{id}")
    public ResponseEntity<String> deleteTavolo(@PathVariable int id) {
        Boolean b = tavoloService.deleteTavolo(id);
        if (b) {
            return ResponseEntity.ok("tavolo rimosso");
        }
        return ResponseEntity.ofNullable("tavolo non registrato");
    }

    @GetMapping("/ricercaTavolo/{id}")
    public ResponseEntity<TavoloResponse> ricercaTavolo(@PathVariable int id) {
        TavoloResponse tavoloResponse = tavoloService.ricercaTavolo(id);
        if (tavoloResponse != null) {
            return ResponseEntity.ok(tavoloResponse);
        }
        return ResponseEntity.notFound().build();
    }
}
