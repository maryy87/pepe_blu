package com.example.pepe.blu.repository;

import com.example.pepe.blu.dto.request.FiltroPiattoRequest;
import com.example.pepe.blu.dto.request.PiattoRequest;
import com.example.pepe.blu.entities.EmployerEntity;
import com.example.pepe.blu.entities.PiattoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomPiattoRepositoryImpl implements CustomPiattoRepository {

    final EntityManager entityManager;

    public CustomPiattoRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<PiattoEntity> findPiattoByFiltro(FiltroPiattoRequest filtroPiattoRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PiattoEntity> cq = cb.createQuery(PiattoEntity.class);
        Root<PiattoEntity> piattoEntityRoot = cq.from(PiattoEntity.class);
        List<Predicate> predicateList = new ArrayList<>();

        if (filtroPiattoRequest.getDescrizionePiatto() != null && !filtroPiattoRequest.getDescrizionePiatto().isEmpty()) {
            Predicate predicate = cb.like(piattoEntityRoot.get("descrizionePiatto"), "%" + filtroPiattoRequest.getDescrizionePiatto() + "%");
            predicateList.add(predicate);
        }

        if (filtroPiattoRequest.getNomePiatto() != null && !filtroPiattoRequest.getNomePiatto().isEmpty()) {
            Predicate predicate = cb.like(piattoEntityRoot.get("nomePiatto"), "%" + filtroPiattoRequest.getNomePiatto() + "%");
            predicateList.add(predicate);
        }
        if (filtroPiattoRequest.getPrezzoPiatto() != null) {
            Predicate predicate = cb.equal(piattoEntityRoot.get("prezzoPiatto"),  filtroPiattoRequest.getPrezzoPiatto());
            predicateList.add(predicate);
        }
        if (filtroPiattoRequest.getPrezzoPiattoMin() != null) {
            Predicate predicate = cb.greaterThanOrEqualTo(piattoEntityRoot.get("prezzoPiatto"), filtroPiattoRequest.getPrezzoPiattoMin());
            predicateList.add(predicate);
        }
        if (filtroPiattoRequest.getPrezzoPiattoMax() != null) {
            Predicate predicate = cb.lessThanOrEqualTo(piattoEntityRoot.get("prezzoPiatto"),  filtroPiattoRequest.getPrezzoPiattoMax());
            predicateList.add(predicate);
        }
        if (filtroPiattoRequest.getTipoPiatto() != null) {
            Predicate predicate = cb.equal(piattoEntityRoot.get("tipoPiatto"),  filtroPiattoRequest.getTipoPiatto().name());
            predicateList.add(predicate);
        }
        if (filtroPiattoRequest.getIntolleranze() != null) {
            Predicate predicate = cb.equal(piattoEntityRoot.get("intolleranze"),  filtroPiattoRequest.getIntolleranze().name());
            predicateList.add(predicate);
        }
        cq.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
















