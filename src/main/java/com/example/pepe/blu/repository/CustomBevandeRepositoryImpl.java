package com.example.pepe.blu.repository;

import com.example.pepe.blu.dto.request.FiltroBevandeRequest;
import com.example.pepe.blu.entities.BevandeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomBevandeRepositoryImpl implements CustomBevandeRepository {

    final EntityManager entityManager;

    public CustomBevandeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<BevandeEntity> findBevandeFiltro(FiltroBevandeRequest filtroBevandeRequest) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BevandeEntity> cq = cb.createQuery(BevandeEntity.class);
        Root<BevandeEntity> bevandeEntityRoot = cq.from(BevandeEntity.class);
        List<Predicate> predicateList = new ArrayList<>();

        if (filtroBevandeRequest.getNomeBevande() != null && !filtroBevandeRequest.getNomeBevande().isEmpty()) {
            Predicate predicate = cb.like(bevandeEntityRoot.get("nomeBevande"), "%" + filtroBevandeRequest.getNomeBevande() + "%");
            predicateList.add(predicate);
        }

        if (filtroBevandeRequest.getDisponibile() != null) {
            Predicate predicate = cb.equal(bevandeEntityRoot.get("disponibile"), filtroBevandeRequest.getDisponibile());
            predicateList.add(predicate);
        }

        if (filtroBevandeRequest.getPrezzoBevande() != null) {
            Predicate predicate = cb.equal(bevandeEntityRoot.get("prezzoBevande"), filtroBevandeRequest.getPrezzoBevande());
            predicateList.add(predicate);
        }
        if (filtroBevandeRequest.getPrezzoBevandeMax() != null) {
            Predicate predicate = cb.lessThanOrEqualTo(bevandeEntityRoot.get("prezzoBevande"), filtroBevandeRequest.getPrezzoBevandeMax());
            predicateList.add(predicate);
        }

        if (filtroBevandeRequest.getPrezzoBevandeMin() != null) {
            Predicate predicate = cb.greaterThanOrEqualTo(bevandeEntityRoot.get("prezzoBevande"), filtroBevandeRequest.getPrezzoBevandeMin());
            predicateList.add(predicate);
        }
        if (filtroBevandeRequest.getTipoBevande() != null) {
            Predicate predicate = cb.equal(bevandeEntityRoot.get("tipoBevande"), filtroBevandeRequest.getTipoBevande().name());
            predicateList.add(predicate);
        }
        cq.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
