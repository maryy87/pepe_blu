package com.example.pepe.blu.service;

import com.example.pepe.blu.filters.FiltroPiattoRequest;
import com.example.pepe.blu.repository.CustomPiattoRepository;
import com.example.pepe.blu.repository.PiattoRepository;
import com.example.pepe.blu.dto.request.PiattoRequest;
import com.example.pepe.blu.dto.PiattoResponse;
import com.example.pepe.blu.entities.PiattoEntity;
import com.example.pepe.blu.mapper.PiattoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PiattoService {

    @Autowired
    private PiattoRepository piattoRepository;
    @Autowired
    private PiattoMapper piattoMapper;
    @Autowired
    private CustomPiattoRepository customPiattoRepository;

    public List<PiattoResponse> ricercaGlobalePiatto(FiltroPiattoRequest filtroPiattoRequest) {
        if (filtroPiattoRequest != null) {
            List<PiattoEntity> piattoEntityList = customPiattoRepository.findPiattoByFiltro(filtroPiattoRequest);
            List<PiattoResponse> piattoResponsesList = piattoMapper.mapPiattoEntityListToResponseList(piattoEntityList);
            return piattoResponsesList;
        }
        return new ArrayList<>();
    }

    public PiattoResponse addPiatto(PiattoRequest piattoRequest) {
        if (piattoRequest != null) {
            PiattoEntity piattoEntity = piattoRepository.save(piattoMapper.mapPiattoRequestToEntity(piattoRequest));
            return piattoMapper.mapPiattoEntityToResponse(piattoEntity);
        }
        return null;
    }


    public PiattoResponse updatePiatto(PiattoRequest piattoRequest, int id) {
        if (piattoRepository.findById(id).isPresent()) {
            PiattoEntity piattoEntity = piattoMapper.mapPiattoRequestToEntity(piattoRequest);
            piattoEntity.setIdPiatto(id);
            PiattoEntity piatto = piattoRepository.save(piattoEntity);
            return piattoMapper.mapPiattoEntityToResponse(piatto);
        }
        return null;
    }


    public Boolean deletePiatto(int id) {
        if (piattoRepository.findById(id).isPresent()) {
            piattoRepository.deleteById(id);
            if (piattoRepository.findById(id).isPresent()) {
                return false;
            }
            return true;
        }
        return false;
    }


    public PiattoResponse ricercaPiatto(int id) {
        Optional<PiattoEntity> piattoEntity = piattoRepository.findById(id);
        if (piattoEntity.isPresent()) {
            return piattoMapper.mapPiattoEntityToResponse(piattoEntity.get());
        }
        return null;
    }
}
