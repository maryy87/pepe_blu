package com.example.pepe.blu.repository;

import com.example.pepe.blu.dto.request.FiltroArticoloRequest;
import com.example.pepe.blu.entities.ArticoloEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomArticoloRepositoryImpl implements CustomArticoloRepository {


    final EntityManager entityManager;

    @Autowired
    public CustomArticoloRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<ArticoloEntity> findArticoloFiltro(FiltroArticoloRequest filtroArticoloRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ArticoloEntity> cq = cb.createQuery(ArticoloEntity.class);
        Root<ArticoloEntity> articoloEntityRoot = cq.from(ArticoloEntity.class);
        List<Predicate> predicateList = new ArrayList<>();


        if (filtroArticoloRequest.getArticolo() != null && !filtroArticoloRequest.getArticolo().isEmpty()) {
            Predicate predicate = cb.like(articoloEntityRoot.get("articolo"), "%" + filtroArticoloRequest.getArticolo() + "%");
            predicateList.add(predicate);
        }
        if (filtroArticoloRequest.getCategoriaArticolo() != null && !filtroArticoloRequest.getCategoriaArticolo().isEmpty()) {
            Predicate predicate = cb.like(articoloEntityRoot.get("categoriaArticolo"), "%" + filtroArticoloRequest.getCategoriaArticolo() + "%");
            predicateList.add(predicate);
        }
        if (filtroArticoloRequest.getDescizioneArticolo() != null && !filtroArticoloRequest.getDescizioneArticolo().isEmpty()) {
            Predicate predicate = cb.like(articoloEntityRoot.get("descizioneArticolo"), "%" + filtroArticoloRequest.getDescizioneArticolo() + "%");
            predicateList.add(predicate);
        }
        if (filtroArticoloRequest.getPrezzoArticolo() != null) {
            Predicate predicate = cb.equal(articoloEntityRoot.get("prezzoArticolo"), filtroArticoloRequest.getPrezzoArticolo());
            predicateList.add(predicate);
        }
        if (filtroArticoloRequest.getPrezzoArticoloMax() != null) {
            Predicate predicate = cb.lessThanOrEqualTo(articoloEntityRoot.get("prezzoArticolo"), filtroArticoloRequest.getPrezzoArticoloMax());
            predicateList.add(predicate);
        }
        if (filtroArticoloRequest.getPrezzoArticoloMin() != null) {
            Predicate predicate = cb.greaterThanOrEqualTo(articoloEntityRoot.get("prezzoArticolo"), filtroArticoloRequest.getPrezzoArticoloMin());
            predicateList.add(predicate);
        }

        if (filtroArticoloRequest.getDataAggiunta() != null) {
            Predicate predicate = cb.equal(articoloEntityRoot.get("dataAggiunta"), filtroArticoloRequest.getDataAggiunta());
            predicateList.add(predicate);
        }
        if (filtroArticoloRequest.getFornitore() != null && !filtroArticoloRequest.getFornitore().isEmpty()) {
            Predicate predicate = cb.like(articoloEntityRoot.get("fornitore"), "%" + filtroArticoloRequest.getFornitore() + "%");
            predicateList.add(predicate);
        }

        cq.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
