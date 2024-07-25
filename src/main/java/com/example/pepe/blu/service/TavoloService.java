package com.example.pepe.blu.service;

import com.example.pepe.blu.dto.request.FiltroTavoloRequest;
import com.example.pepe.blu.repository.CustomTavoloRepository;
import com.example.pepe.blu.repository.TavoloRepository;
import com.example.pepe.blu.dto.request.TavoloRequest;
import com.example.pepe.blu.dto.response.TavoloResponse;
import com.example.pepe.blu.entities.TavoloEntity;
import com.example.pepe.blu.mapper.TavoloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TavoloService {

    @Autowired
    private TavoloRepository tavoloRepository;
    @Autowired
    private TavoloMapper tavoloMapper;
    @Autowired
    private CustomTavoloRepository customTavoloRepository;


    public List<TavoloResponse> findTavoloByFiltro(FiltroTavoloRequest filtroTavoloRequest) {
        if (filtroTavoloRequest != null) {
            List<TavoloResponse> tavoloResponses=tavoloMapper.mapTavoloEntitListyToResponseList(customTavoloRepository.findTavoloByFiltro(filtroTavoloRequest));
            return tavoloResponses;
        }
        return new ArrayList<>();
    }


    public TavoloResponse addTavolo(TavoloRequest tavoloRequest){
        if (tavoloRequest != null) {
            TavoloEntity tavoloEntity=tavoloMapper.mapTavoloRequestToEntity(tavoloRequest);
            TavoloEntity tavolo=tavoloRepository.save(tavoloEntity);
            return tavoloMapper.mapTavoloEntityToResponse(tavolo);
        }
        return null;
    }

    public TavoloResponse updateTavolo(TavoloRequest tavoloRequest,int id){
        if (tavoloRepository.findById(id).isPresent()) {
            TavoloEntity tavoloEntity=tavoloMapper.mapTavoloRequestToEntity(tavoloRequest);
            tavoloEntity.setNumeroDelTavolo(id);
            TavoloEntity tavolo=tavoloRepository.save(tavoloEntity);
            return tavoloMapper.mapTavoloEntityToResponse(tavolo);
        }
        return null;
    }
    public Boolean deleteTavolo(int id){
        if (tavoloRepository.findById(id).isPresent()){
            tavoloRepository.deleteById(id);
            if (tavoloRepository.findById(id).isPresent()){
                return false;
            }
            return true;
        }
        return false;
    }

    public TavoloResponse ricercaTavolo(int id){
        Optional<TavoloEntity> tavoloEntity=tavoloRepository.findById(id);
        if (tavoloEntity.isPresent()) {
            return tavoloMapper.mapTavoloEntityToResponse(tavoloEntity.get());
        }
        return null;
    }
}
