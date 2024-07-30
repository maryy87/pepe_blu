package com.example.pepe.blu.repository;

import com.example.pepe.blu.filters.FiltroTavoloRequest;
import com.example.pepe.blu.entities.TavoloEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomTavoloRepositoryImpl implements CustomTavoloRepository {

    final EntityManager entityManager;

    public CustomTavoloRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<TavoloEntity> findTavoloByFiltro(FiltroTavoloRequest filtroTavoloRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TavoloEntity> cq = cb.createQuery(TavoloEntity.class);
        Root<TavoloEntity> tavoloEntityRoot = cq.from(TavoloEntity.class);
        List<Predicate> predicateList = new ArrayList<>();

        if (filtroTavoloRequest.getPosizioneDelTavolo() != null && !filtroTavoloRequest.getPosizioneDelTavolo().isEmpty()) {
            Predicate predicate = cb.like(tavoloEntityRoot.get("posizioneDelTavolo"), "%" + filtroTavoloRequest.getPosizioneDelTavolo() + "%");
            predicateList.add(predicate);
        }
        if (filtroTavoloRequest.getNumeriDiPosti() != null) {
            Predicate predicate = cb.equal(tavoloEntityRoot.get("numeriDiPosti"), filtroTavoloRequest.getNumeriDiPosti());
            predicateList.add(predicate);
        }
        if (filtroTavoloRequest.getNumeriDiPostiMin() != null) {
            Predicate predicate = cb.greaterThanOrEqualTo(tavoloEntityRoot.get("numeriDiPosti"), filtroTavoloRequest.getNumeriDiPostiMin());
            predicateList.add(predicate);
        }
        if (filtroTavoloRequest.getNumeriDiPostiMax() != null) {
            Predicate predicate = cb.lessThanOrEqualTo(tavoloEntityRoot.get("numeriDiPosti"), filtroTavoloRequest.getNumeriDiPostiMax());
            predicateList.add(predicate);
        }
        cq.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();

    }
}






















