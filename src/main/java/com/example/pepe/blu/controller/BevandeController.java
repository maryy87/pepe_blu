package com.example.pepe.blu.controller;

import com.example.pepe.blu.dto.request.BevandeRequest;
import com.example.pepe.blu.dto.request.FiltroBevandeRequest;
import com.example.pepe.blu.dto.response.BevandeResponse;
import com.example.pepe.blu.service.BevandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bevande")
public class BevandeController {






    @Autowired
    private BevandeService bevandeService;

    @PostMapping("/ricercaBevande")
    public ResponseEntity<List<BevandeResponse>> ricercaBevande(@RequestBody FiltroBevandeRequest filtroBevandeRequest){
        List<BevandeResponse> bevandeResponseList=bevandeService.ricercaBevande(filtroBevandeRequest);
        if (bevandeResponseList != null) {
            return ResponseEntity.ok(bevandeResponseList);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/addBevande")
    public ResponseEntity<BevandeResponse> addBevande(@RequestBody BevandeRequest bevandeRequest) {
        BevandeResponse bevandeResponse = bevandeService.addBevandeNonOrdinato(bevandeRequest);
        if (bevandeResponse != null) {
            return ResponseEntity.ok(bevandeResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/updateBevande/{id}")
    public ResponseEntity<BevandeResponse> updateBevande(@RequestBody BevandeRequest bevandeRequest, @PathVariable int id) {
        BevandeResponse bevandeResponse = bevandeService.updateBevande(bevandeRequest, id);
        if (bevandeResponse != null) {
            return ResponseEntity.ok(bevandeResponse);
        }
        return ResponseEntity.notFound().build();
    }



    @DeleteMapping("/deleteBevande/{id}")
    public ResponseEntity<String> deleteBevande(@PathVariable int id) {
        Boolean b = bevandeService.deleteBevande(id);
        if (b) {
            return ResponseEntity.ok("bevande rimosso");
        }
        return ResponseEntity.ofNullable("bevande non esiste");
    }


    //pepe branch

    @GetMapping("/ricercaBevnade/{id}")
    public ResponseEntity<BevandeResponse> ricercaBevnade(@PathVariable int id) {
        BevandeResponse bevandeResponse = bevandeService.ricercaBevnade(id);
        if (bevandeResponse != null) {
            return ResponseEntity.ok(bevandeResponse);
        }
        return ResponseEntity.notFound().build();
    }
}
