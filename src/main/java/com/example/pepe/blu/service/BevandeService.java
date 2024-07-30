package com.example.pepe.blu.service;

import com.example.pepe.blu.filters.FiltroBevandeRequest;
import com.example.pepe.blu.repository.BevandeRepository;
import com.example.pepe.blu.dto.request.BevandeRequest;
import com.example.pepe.blu.dto.BevandeResponse;
import com.example.pepe.blu.entities.BevandeEntity;
import com.example.pepe.blu.mapper.BevandeMapper;
import com.example.pepe.blu.repository.CustomBevandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BevandeService {

    @Autowired
    private BevandeRepository bevandeRepository;

    @Autowired
    private BevandeMapper bevandeMapper;
    @Autowired
    private CustomBevandeRepository customBevandeRepository;

    public List<BevandeResponse> ricercaBevande(FiltroBevandeRequest filtroBevandeRequest) {
        if (filtroBevandeRequest != null) {
            List<BevandeResponse> bevandeResponseList = bevandeMapper.mapBevandeEntityListToResponseList(customBevandeRepository.findBevandeFiltro(filtroBevandeRequest));
            return bevandeResponseList;
        }
        return new ArrayList<>();
    }

    public BevandeResponse addBevandeNonOrdinato(BevandeRequest bevandeRequest) {
        BevandeEntity bevandeEntity = bevandeMapper.mapBevandeRequestToEntity(bevandeRequest);
        if (bevandeEntity != null) {
            BevandeEntity bevandeEntity1 = bevandeRepository.save(bevandeEntity);
            return bevandeMapper.mapBevandeEntityToResponse(bevandeEntity1);
        }
        return null;
    }

    public BevandeResponse updateBevande(BevandeRequest bevandeRequest, int id) {
        if (bevandeRepository.findById(id).isPresent()) {
            BevandeEntity bevandeEntity = bevandeMapper.mapBevandeRequestToEntity(bevandeRequest);
            bevandeEntity.setIdBevande(id);
            BevandeEntity bevandeEntity1 = bevandeRepository.save(bevandeEntity);
            return bevandeMapper.mapBevandeEntityToResponse(bevandeEntity1);
        }
        return null;
    }

    public Boolean deleteBevande(int id) {
        if (bevandeRepository.findById(id).isPresent()) {
            bevandeRepository.deleteById(id);
            if (bevandeRepository.findById(id).isPresent()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public BevandeResponse ricercaBevnade(int id) {
        Optional<BevandeEntity> bevandeEntity = bevandeRepository.findById(id);
        if (bevandeEntity.isPresent()) {
            return bevandeMapper.mapBevandeEntityToResponse(bevandeEntity.get());
        }
        return null;
    }
}
