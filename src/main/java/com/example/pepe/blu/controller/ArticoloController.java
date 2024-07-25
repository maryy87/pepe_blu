package com.example.pepe.blu.controller;

import com.example.pepe.blu.dto.request.ArticoloRequest;
import com.example.pepe.blu.dto.request.FiltroArticoloRequest;
import com.example.pepe.blu.dto.response.ArticoloResponse;
import com.example.pepe.blu.entities.ArticoloEntity;
import com.example.pepe.blu.service.ArticoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Articolo")
public class ArticoloController {

    @Autowired
    private ArticoloService articoloService;

    @PostMapping("/ricercaArticolo")
    public ResponseEntity<List<ArticoloResponse>> ricercaArticolo(@RequestBody FiltroArticoloRequest filtroArticoloRequest) {
        List<ArticoloResponse> articoloResponseList=articoloService.ricercaArticolo(filtroArticoloRequest);
        if (articoloResponseList != null) {
            return ResponseEntity.ok(articoloResponseList);
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/addArticolo")
    public ResponseEntity<ArticoloResponse> addArticolo(@RequestBody ArticoloRequest articoloRequest) {
        ArticoloResponse articoloResponse = articoloService.addArticolo(articoloRequest);
        if (articoloResponse != null) {
            return ResponseEntity.ok(articoloResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/updateArticolo/{idArticolo}")
    public ResponseEntity<ArticoloResponse> updateArticolo(@RequestBody ArticoloRequest articoloRequest,@PathVariable int idArticolo) {
        ArticoloResponse articoloResponse = articoloService.updateArticolo(articoloRequest, idArticolo);
        if (articoloResponse != null) {
            return ResponseEntity.ok(articoloResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteArticolo/{id}")
    public ResponseEntity<String> deleteArticolo(@PathVariable int id) {
        Boolean b = articoloService.deleteArticolo(id);
        if (b) {
            return ResponseEntity.ok("articolo rimosso con successo");
        }
        return ResponseEntity.ofNullable("articolo non esiste");
    }

    @GetMapping("/ricercaArticolo/{id}")
    public ResponseEntity<ArticoloResponse> ricercaArticolo(@PathVariable int id) {
        ArticoloResponse articoloResponse = articoloService.ricercaArticolo(id);
        if (articoloResponse != null) {
            return ResponseEntity.ok(articoloResponse);
        }
        return ResponseEntity.notFound().build();
    }

}
