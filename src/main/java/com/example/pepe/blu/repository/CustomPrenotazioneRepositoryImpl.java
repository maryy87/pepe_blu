package com.example.pepe.blu.repository;

import com.example.pepe.blu.dto.request.FiltroPiattoRequest;
import com.example.pepe.blu.dto.request.FiltroPrenotazioneRequest;
import com.example.pepe.blu.dto.request.PrenotazioneRequest;
import com.example.pepe.blu.entities.EmployerEntity;
import com.example.pepe.blu.entities.PrenotazioneEntity;
import com.example.pepe.blu.entities.TavoloEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomPrenotazioneRepositoryImpl implements CustomPrenotazioneRepository{

    final EntityManager entityManager;

    public CustomPrenotazioneRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PrenotazioneEntity> findByFiltro(FiltroPrenotazioneRequest filtroPrenotazioneRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PrenotazioneEntity> cq = cb.createQuery(PrenotazioneEntity.class);
        Root<PrenotazioneEntity> prenotazioneEntityRoot = cq.from(PrenotazioneEntity.class);
        List<Predicate> predicateList = new ArrayList<>();

        if (filtroPrenotazioneRequest.getNomeCliente() != null && !filtroPrenotazioneRequest.getNomeCliente().isEmpty()) {
            Predicate predicate=cb.like(prenotazioneEntityRoot.get("nomeCliente"),"%"+filtroPrenotazioneRequest.getNomeCliente()+"%");
            predicateList.add(predicate);
        }
        if (filtroPrenotazioneRequest.getCognomeCliente() != null && !filtroPrenotazioneRequest.getCognomeCliente().isEmpty()) {
            Predicate predicate=cb.like(prenotazioneEntityRoot.get("cognomeCliente"),"%"+filtroPrenotazioneRequest.getCognomeCliente()+"%");
            predicateList.add(predicate);
        }
        if (filtroPrenotazioneRequest.getDataPrenotazione() != null ) {
            Predicate predicate=cb.equal(prenotazioneEntityRoot.get("dataPrenotazione"),filtroPrenotazioneRequest.getDataPrenotazione());
            predicateList.add(predicate);
        }
        if (filtroPrenotazioneRequest.getOrario() != null ) {
            Predicate predicate=cb.equal(prenotazioneEntityRoot.get("orario"),filtroPrenotazioneRequest.getOrario());
            predicateList.add(predicate);
        }
        if (filtroPrenotazioneRequest.getOrarioMin() != null ) {
            Predicate predicate=cb.greaterThanOrEqualTo(prenotazioneEntityRoot.get("orario"),filtroPrenotazioneRequest.getOrarioMin());
            predicateList.add(predicate);
        }
        if (filtroPrenotazioneRequest.getOrarioMax() != null ) {
            Predicate predicate=cb.lessThanOrEqualTo(prenotazioneEntityRoot.get("orario"),filtroPrenotazioneRequest.getOrarioMax());
            predicateList.add(predicate);
        }
        if (filtroPrenotazioneRequest.getNumerodiTel() != null ) {
            Predicate predicate=cb.equal(prenotazioneEntityRoot.get("numerodiTel"),filtroPrenotazioneRequest.getNumerodiTel());
            predicateList.add(predicate);
        }
        if (filtroPrenotazioneRequest.getNumeroDelTavolo() != null ) {
            Join<PrenotazioneEntity, TavoloEntity> prenotazioneEntityTavoloEntityJoin=prenotazioneEntityRoot.join("tavoloEntity");
            Predicate predicate=cb.equal(prenotazioneEntityTavoloEntityJoin.get("numeroDelTavolo"),filtroPrenotazioneRequest.getNumeroDelTavolo());
            predicateList.add(predicate);
        }
        if (filtroPrenotazioneRequest.getStatoPrenotazione()!= null ) {
            Predicate predicate=cb.equal(prenotazioneEntityRoot.get("statoPrenotazione"),filtroPrenotazioneRequest.getStatoPrenotazione().name());
            predicateList.add(predicate);
        }
        if (filtroPrenotazioneRequest.getNumeroDiPersone()!= null ) {
            Predicate predicate=cb.equal(prenotazioneEntityRoot.get("numeroDiPersone"),filtroPrenotazioneRequest.getNumeroDiPersone());
            predicateList.add(predicate);
        }
        cq.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}














