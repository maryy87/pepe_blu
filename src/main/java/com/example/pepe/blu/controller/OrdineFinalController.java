package com.example.pepe.blu.controller;

import com.example.pepe.blu.filters.FiltroOrdineRequest;
import com.example.pepe.blu.dto.request.OrdineFinaleRequest;
import com.example.pepe.blu.dto.OrdineFinaleResponse;
import com.example.pepe.blu.service.OrdineFinaleService;
import com.example.pepe.blu.util.Periodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordine")
public class OrdineFinalController {

    @Autowired
    private OrdineFinaleService ordineFinaleService;



    @GetMapping("/prezzoTotaleDiUnOrdine")
    public ResponseEntity prezzoTotaleDiUnOrdine(@RequestParam Periodo periodo) {
        Double prezzo= ordineFinaleService.prezzoTotaleDiUnOrdine(periodo);
        if (prezzo != null) {
            return ResponseEntity.ok(prezzo);
        }
        return ResponseEntity.ofNullable("non ci sono ordine in questo anno");
    }


    @PostMapping("/ricercaOrdineFinale")
    public ResponseEntity<List<OrdineFinaleResponse>> ricercaOrdineFinale(@RequestBody FiltroOrdineRequest filtroOrdineRequest) {
        List<OrdineFinaleResponse> ordineFinaleResponseList=ordineFinaleService.ricercaOrdine(filtroOrdineRequest);
        if (ordineFinaleResponseList != null) {
            return ResponseEntity.ok(ordineFinaleResponseList);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/addOrdine/{idOrdine}")
    public ResponseEntity<OrdineFinaleResponse> addOrdine(@RequestBody OrdineFinaleRequest ordineFinaleRequest,@PathVariable int idOrdine) {
        OrdineFinaleResponse ordineFinaleResponse = ordineFinaleService.addOrdine(ordineFinaleRequest, idOrdine);
        if (ordineFinaleResponse != null) {
            return ResponseEntity.ok(ordineFinaleResponse);
        }
        return null;
    }

    @PostMapping("/addNuovoOrdine")
    public ResponseEntity<OrdineFinaleResponse> addNuovoOrdine(@RequestBody OrdineFinaleRequest ordineFinaleRequest) {
        OrdineFinaleResponse ordineFinaleResponse = ordineFinaleService.addNuovoOrdine(ordineFinaleRequest);
        if (ordineFinaleResponse != null) {
            return ResponseEntity.ok(ordineFinaleResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/updateOrdine/{id}")
    public ResponseEntity<OrdineFinaleResponse> updateOrdine(@RequestBody OrdineFinaleRequest ordineFinaleRequest, @PathVariable int id) {
     OrdineFinaleResponse ordineFinaleResponse = ordineFinaleService.updateOrdine(ordineFinaleRequest, id);
        if (ordineFinaleResponse != null) {
            return ResponseEntity.ok(ordineFinaleResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteOrdine/{id}")
    public ResponseEntity<String> deleteOrdine(@PathVariable int id) {
        Boolean b = ordineFinaleService.deleteOrdine(id);
        if (b) {
            return ResponseEntity.ok("ordine cancellato");
        }
        return ResponseEntity.ofNullable("ordine non esiste");
    }

    @GetMapping("/ricercaOrdine/{id}")
    public ResponseEntity<OrdineFinaleResponse> ricercaOrdine(@PathVariable int id) {
        OrdineFinaleResponse ordineFinaleResponse = ordineFinaleService.ricercaOrdine(id);
        if (ordineFinaleResponse != null) {
            return ResponseEntity.ok(ordineFinaleResponse);
        }
        return ResponseEntity.notFound().build();
    }
}
