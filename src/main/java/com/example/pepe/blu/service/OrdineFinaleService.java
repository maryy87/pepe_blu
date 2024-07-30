package com.example.pepe.blu.service;

import com.example.pepe.blu.filters.FiltroOrdineRequest;
import com.example.pepe.blu.dto.request.OrdineFinaleRequest;
import com.example.pepe.blu.dto.BevandeResponse;
import com.example.pepe.blu.dto.OrdineFinaleResponse;
import com.example.pepe.blu.dto.PiattoResponse;
import com.example.pepe.blu.entities.OrdineFinaleEntity;
import com.example.pepe.blu.mapper.OrdineFinaleMapper;
import com.example.pepe.blu.repository.CustomOrdineRepository;
import com.example.pepe.blu.repository.OrdineFinaleRepository;
import com.example.pepe.blu.repository.OrdineRepository;
import com.example.pepe.blu.entities.OrdineEntity;
import com.example.pepe.blu.util.Periodo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdineFinaleService {

    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private OrdineFinaleRepository ordineFinaleRepository;
    @Autowired
    private OrdineFinaleMapper ordineFinaleMapper;
    @Autowired
    private CustomOrdineRepository customOrdineRepository;
    @Autowired
    private BevandeService bevandeService;
    @Autowired
    private PiattoService piattoService;


    public Double prezzoTotaleDiUnOrdine(Periodo periodo) {
        FiltroOrdineRequest filtroOrdineRequest = new FiltroOrdineRequest();

        LocalDateTime dataOrdine = LocalDateTime.now();

        LocalDateTime dataOrdineMin = LocalDate.now().atStartOfDay();
switch (periodo){
    case ANNO -> dataOrdineMin = dataOrdine.minusYears(1);
    case MESE ->  dataOrdineMin = dataOrdine.minusMonths(1);
}

        filtroOrdineRequest.setDataOrdineMin(dataOrdineMin);

        filtroOrdineRequest.setDataOrdineMax(dataOrdine);

        List<OrdineFinaleResponse> ordineFinaleResponseList = ricercaOrdine(filtroOrdineRequest);

        Double prezzo = 0.0;

        if (!ordineFinaleResponseList.isEmpty()) {
            for (OrdineFinaleResponse ordineFinaleResponse : ordineFinaleResponseList) {
                if (ordineFinaleResponse != null && ordineFinaleResponse.getPrezzoOrdine() != null) {
                    prezzo += ordineFinaleResponse.getPrezzoOrdine();
                }
            }
            return prezzo;
        }
        return null;
    }

    public List<OrdineFinaleResponse> ricercaOrdine(FiltroOrdineRequest filtroOrdineRequest) {
        if (filtroOrdineRequest != null) {
            List<OrdineFinaleEntity> ordineFinaleEntityList = customOrdineRepository.findOrdineByFiltro(filtroOrdineRequest);
            List<OrdineFinaleResponse> ordineFinaleResponseList = ordineFinaleMapper.mapOrdineFinaleEntirtyListToOrdineFinaleResponseList(ordineFinaleEntityList);
            return ordineFinaleResponseList;
        }
        return new ArrayList<>();
    }

    @Transactional
    public OrdineFinaleResponse addOrdine(OrdineFinaleRequest ordineFinaleRequest, int idOrdine) {
        if (ordineFinaleRequest != null && ordineFinaleRequest.getIdOrdine() == null) {
            OrdineFinaleEntity ordineFinaleEntity = ordineFinaleMapper.mapOrdineFinaleRequestToOrdineFinaleEntity(ordineFinaleRequest);
            OrdineEntity ordine = new OrdineEntity();
            ordine.setIdOrdine(idOrdine);
            ordineFinaleEntity.setIdOrdine(ordine);
            ordineFinaleEntity.setDataOrdine(LocalDateTime.now());
            int idBevande = ordineFinaleRequest.getIdBevande();
            BevandeResponse bevandeResponse = bevandeService.ricercaBevnade(idBevande);
            int idPiatto = ordineFinaleRequest.getIdPiatto();
            PiattoResponse piattoResponse = piattoService.ricercaPiatto(idPiatto);
            double prezzoOrdine = bevandeResponse.getPrezzoBevande() + piattoResponse.getPrezzoPiatto();
            ordineFinaleEntity.setPrezzoOrdine(prezzoOrdine);
            OrdineFinaleEntity ordineFinaleEntity1 = ordineFinaleRepository.save(ordineFinaleEntity);
            return ordineFinaleMapper.mapOrdineFinaleEntirtyToOrdineFinaleResponse(ordineFinaleEntity1);
        }
        return null;
    }

    @Transactional
    public OrdineFinaleResponse addNuovoOrdine(OrdineFinaleRequest ordineFinaleRequest) {
        if (ordineFinaleRequest != null && ordineFinaleRequest.getIdOrdine() == null) {
            OrdineFinaleEntity ordineFinaleEntity = ordineFinaleMapper.mapOrdineFinaleRequestToOrdineFinaleEntity(ordineFinaleRequest);
            OrdineEntity ordine1 = ordineRepository.saveOrdine();
            ordineFinaleEntity.setIdOrdine(ordine1);
            ordineFinaleEntity.setDataOrdine(LocalDateTime.now());
            int idBevande = ordineFinaleRequest.getIdBevande();
            BevandeResponse bevandeResponse = bevandeService.ricercaBevnade(idBevande);
            int idPiatto = ordineFinaleRequest.getIdPiatto();
            PiattoResponse piattoResponse = piattoService.ricercaPiatto(idPiatto);
            double prezzoOrdine = bevandeResponse.getPrezzoBevande() + piattoResponse.getPrezzoPiatto();
            ordineFinaleEntity.setPrezzoOrdine(prezzoOrdine);
            OrdineFinaleEntity ordineFinaleEntity1 = ordineFinaleRepository.save(ordineFinaleEntity);
            return ordineFinaleMapper.mapOrdineFinaleEntirtyToOrdineFinaleResponse(ordineFinaleEntity1);
        }
        return null;
    }

    public OrdineFinaleResponse updateOrdine(OrdineFinaleRequest ordineFinaleRequest, int id) {
        if (ordineFinaleRepository.findById(id).isPresent()) {
            OrdineFinaleEntity ordineFinaleEntity = ordineFinaleMapper.mapOrdineFinaleRequestToOrdineFinaleEntity(ordineFinaleRequest);
            ordineFinaleEntity.setIdOrdineFinale(id);
            OrdineFinaleEntity ordineFinaleEntity1 = ordineFinaleRepository.save(ordineFinaleEntity);
            return ordineFinaleMapper.mapOrdineFinaleEntirtyToOrdineFinaleResponse(ordineFinaleEntity1);
        }
        return null;
    }

    public Boolean deleteOrdine(int id) {
        if (ordineFinaleRepository.findById(id).isPresent()) {
            ordineFinaleRepository.deleteById(id);
            if (ordineFinaleRepository.findById(id).isPresent()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public OrdineFinaleResponse ricercaOrdine(int id) {
        Optional<OrdineFinaleEntity> ordineFinaleEntity = ordineFinaleRepository.findById(id);
        if (ordineFinaleEntity.isPresent()) {
            return ordineFinaleMapper.mapOrdineFinaleEntirtyToOrdineFinaleResponse(ordineFinaleEntity.get());
        }
        return null;
    }

}
