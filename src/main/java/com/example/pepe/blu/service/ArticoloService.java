package com.example.pepe.blu.service;

import com.example.pepe.blu.filters.FiltroArticoloRequest;
import com.example.pepe.blu.repository.ArticoloRepository;
import com.example.pepe.blu.dto.request.ArticoloRequest;
import com.example.pepe.blu.dto.ArticoloResponse;
import com.example.pepe.blu.entities.ArticoloEntity;
import com.example.pepe.blu.mapper.ArticoloMapper;
import com.example.pepe.blu.repository.CustomArticoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticoloService {

    @Autowired
    private ArticoloRepository articoloRepository;

    @Autowired
    private ArticoloMapper articoloMapper;
    @Autowired
    private CustomArticoloRepository customArticoloRepository;

    public List<ArticoloResponse> ricercaArticolo(FiltroArticoloRequest filtroArticoloRequest) {
        if (filtroArticoloRequest != null) {
            List<ArticoloResponse> articoloResponseList = articoloMapper.mapArticoloEntityListToArticoloResponseList(customArticoloRepository.findArticoloFiltro(filtroArticoloRequest));
            return articoloResponseList;
        }
        return new ArrayList<>();
    }

    public ArticoloResponse addArticolo(ArticoloRequest articoloRequest) {
        if (articoloRequest != null) {
            ArticoloEntity articoloEntity = articoloMapper.mapArticoloRequestToEntity(articoloRequest);
            articoloEntity.setDataAggiunta(LocalDateTime.now());
            ArticoloEntity articoloEntity1 = articoloRepository.save(articoloEntity);
            return articoloMapper.mapArticoloEntityToArticoloResponse(articoloEntity1);

        }
        return null;
    }

    public ArticoloResponse updateArticolo(ArticoloRequest articoloRequest, int idArticolo) {
        ArticoloEntity articoloEntity = articoloMapper.mapArticoloRequestToEntity(articoloRequest);
        if (articoloRepository.findById(idArticolo).isPresent()) {
            articoloEntity.setIdArticolo(idArticolo);
            articoloEntity.setDataAggiunta(LocalDateTime.now());
            ArticoloEntity articoloEntity1 = articoloRepository.save(articoloEntity);
            return articoloMapper.mapArticoloEntityToArticoloResponse(articoloEntity1);

        }
        return null;
    }

    public Boolean deleteArticolo(int id) {
        if (articoloRepository.findById(id).isPresent()) {
            articoloRepository.deleteById(id);
            if (articoloRepository.findById(id).isPresent()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public ArticoloResponse ricercaArticolo(int id) {
        Optional<ArticoloEntity> articoloEntity = articoloRepository.findById(id);
        if (articoloEntity.isPresent()) {
            return articoloMapper.mapArticoloEntityToArticoloResponse(articoloEntity.get());
        }
        return null;
    }

}
































