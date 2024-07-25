package com.example.pepe.blu.service;

import com.example.pepe.blu.dto.request.FiltroPrenotazioneRequest;
import com.example.pepe.blu.dto.request.TavoloRequest;
import com.example.pepe.blu.dto.response.TavoloResponse;
import com.example.pepe.blu.mapper.TavoloMapper;
import com.example.pepe.blu.repository.CustomPrenotazioneRepository;
import com.example.pepe.blu.repository.PrenotazioneRepository;
import com.example.pepe.blu.dto.request.PrenotazioneRequest;
import com.example.pepe.blu.dto.response.PrenotazioneResponse;
import com.example.pepe.blu.entities.PrenotazioneEntity;
import com.example.pepe.blu.mapper.PrenotazioneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private PrenotazioneMapper prenotazioneMapper;
    @Autowired
    private CustomPrenotazioneRepository customPrenotazioneRepository;
    @Autowired
    private TavoloService tavoloService;
    @Autowired
    private TavoloMapper tavoloMapper;

    public List<PrenotazioneResponse> ricercaGlobalePrenotazione(FiltroPrenotazioneRequest filtroPrenotazioneRequest) {
        if (filtroPrenotazioneRequest != null) {
            List<PrenotazioneResponse> prenotazioneResponseList = prenotazioneMapper.mapPrenotazioneEntityListToResponseList(customPrenotazioneRepository.findByFiltro(filtroPrenotazioneRequest));
            return prenotazioneResponseList;
        }
        return new ArrayList<>();
    }

    public PrenotazioneResponse addPrenotazione(PrenotazioneRequest prenotazioneRequest) {
        FiltroPrenotazioneRequest filtroPrenotazioneRequest=new FiltroPrenotazioneRequest();
        LocalDateTime orarioRequest = prenotazioneRequest.getOrario();
        LocalDateTime orarioMinimo= orarioRequest.minusHours(1);
        LocalDateTime orarioMaximo= orarioRequest.plusHours(1);
        filtroPrenotazioneRequest.setOrarioMin(orarioMinimo);
        filtroPrenotazioneRequest.setOrarioMax(orarioMaximo);
        filtroPrenotazioneRequest.setNumeroDelTavolo(prenotazioneRequest.getNumeroDelTavolo());
        List<PrenotazioneResponse> prenotazioneResponseList = ricercaGlobalePrenotazione(filtroPrenotazioneRequest);
        if (prenotazioneResponseList.isEmpty()) {
            PrenotazioneEntity prenotazioneEntity = prenotazioneMapper.mapPrenotazioneRequestToEntity(prenotazioneRequest);
            prenotazioneEntity.setDataPrenotazione(LocalDateTime.now());
            PrenotazioneEntity prenotazioneEntity1 = prenotazioneRepository.save(prenotazioneEntity);
            return prenotazioneMapper.mapPrenotazioneEntityToResponse(prenotazioneEntity1);
        }
        return null;
    }

    public PrenotazioneResponse updatePrenotazione(PrenotazioneRequest prenotazioneRequest, int id) {
        if (prenotazioneRepository.findById(id).isPresent()) {
            PrenotazioneEntity prenotazioneEntity = prenotazioneMapper.mapPrenotazioneRequestToEntity(prenotazioneRequest);
            prenotazioneEntity.setIdPrenotazione(id);
            prenotazioneEntity.setDataPrenotazione(LocalDateTime.now());
            PrenotazioneEntity prenotazioneEntity1 = prenotazioneRepository.save(prenotazioneEntity);
            return prenotazioneMapper.mapPrenotazioneEntityToResponse(prenotazioneEntity1);
        }
        return null;
    }

    public Boolean deletePrenotazione(int id) {
        if (prenotazioneRepository.findById(id).isPresent()) {
            prenotazioneRepository.deleteById(id);
            if (prenotazioneRepository.findById(id).isPresent()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public PrenotazioneResponse ricercaPrenotazione(int id) {
        Optional<PrenotazioneEntity> prenotazioneEntity = prenotazioneRepository.findById(id);
        if (prenotazioneEntity.isPresent()) {
            return prenotazioneMapper.mapPrenotazioneEntityToResponse(prenotazioneEntity.get());
        }
        return null;
    }

}
