package com.example.pepe.blu.controller;

import com.example.pepe.blu.dto.request.FiltroPrenotazioneRequest;
import com.example.pepe.blu.dto.request.PrenotazioneRequest;
import com.example.pepe.blu.dto.response.PrenotazioneResponse;
import com.example.pepe.blu.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping("/ricercaGlobalePrenotazione")
    public ResponseEntity<List<PrenotazioneResponse>> ricercaGlobalePrenotazione(@RequestBody FiltroPrenotazioneRequest filtroPrenotazioneRequest) {
       List<PrenotazioneResponse> prenotazioneResponseList=prenotazioneService.ricercaGlobalePrenotazione(filtroPrenotazioneRequest);
        if (prenotazioneResponseList != null) {
            return ResponseEntity.ok(prenotazioneResponseList);
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/addPrenotazione")
    public ResponseEntity addPrenotazione(@RequestBody PrenotazioneRequest prenotazioneRequest) {
        PrenotazioneResponse prenotazioneResponse = prenotazioneService.addPrenotazione(prenotazioneRequest);
        if (prenotazioneResponse != null) {
            return ResponseEntity.ok(prenotazioneResponse);
        }
        return ResponseEntity.ofNullable("il tavolo non è disponibile");
    }

    @PutMapping("/updatePrenotazione/{id}")
    public ResponseEntity<PrenotazioneResponse> updatePrenotazione(@RequestBody PrenotazioneRequest prenotazioneRequest, @PathVariable int id) {
        PrenotazioneResponse prenotazioneResponse = prenotazioneService.updatePrenotazione(prenotazioneRequest, id);
        if (prenotazioneResponse != null) {
            return ResponseEntity.ok(prenotazioneResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletePrenotazione/{id}")
    public ResponseEntity<String> deletePrenotazione(@PathVariable int id) {
        Boolean b = prenotazioneService.deletePrenotazione(id);
        if (b) {
            return ResponseEntity.ok("prenotazione rimossa");
        }
        return ResponseEntity.ofNullable("la prenotazione non esiste");
    }

    @GetMapping("/ricercaPrenotazione/{id}")
    public ResponseEntity<PrenotazioneResponse> ricercaPrenotazione(@PathVariable int id) {
        PrenotazioneResponse prenotazioneResponse = prenotazioneService.ricercaPrenotazione(id);
        if (prenotazioneResponse != null) {
            return ResponseEntity.ok(prenotazioneResponse);
        }
        return ResponseEntity.notFound().build();
    }
}
