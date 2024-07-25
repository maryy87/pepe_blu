package com.example.pepe.blu.repository;

import com.example.pepe.blu.dto.request.FiltroOrdineRequest;
import com.example.pepe.blu.dto.request.OrdineFinaleRequest;
import com.example.pepe.blu.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomOrdineRepositoryImpl implements CustomOrdineRepository {

    final EntityManager entityManager;

    public CustomOrdineRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<OrdineFinaleEntity> findOrdineByFiltro(FiltroOrdineRequest filtroOrdineRequest) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrdineFinaleEntity> cq = cb.createQuery(OrdineFinaleEntity.class);
        Root<OrdineFinaleEntity> ordineFinaleEntityRoot = cq.from(OrdineFinaleEntity.class);
        List<Predicate> predicateList = new ArrayList<>();

        if (filtroOrdineRequest.getIdOrdine() != null) {
            Join<OrdineFinaleEntity,OrdineEntity> ordineEntityJoin=ordineFinaleEntityRoot.join("idOrdine");
            Predicate predicate=cb.equal(ordineEntityJoin.get("idOrdine"),filtroOrdineRequest.getIdOrdine());
            predicateList.add(predicate);
        }
        if (filtroOrdineRequest.getIdBevande() != null) {
            Join<OrdineFinaleEntity, BevandeEntity> bevandeEntityJoin=ordineFinaleEntityRoot.join("idBevande");
            Predicate predicate=cb.equal(bevandeEntityJoin.get("idBevande"),filtroOrdineRequest.getIdBevande());
            predicateList.add(predicate);
        }
        if (filtroOrdineRequest.getIdEmployer()!= null) {
            Join<OrdineFinaleEntity, EmployerEntity> employerEntityJoin=ordineFinaleEntityRoot.join("idEmployer");
            Predicate predicate=cb.equal(employerEntityJoin.get("idEmployer"),filtroOrdineRequest.getIdEmployer());
            predicateList.add(predicate);
        }
        if (filtroOrdineRequest.getIdPiatto()!= null) {
            Join<OrdineFinaleEntity, PiattoEntity> piattoEntityJoin=ordineFinaleEntityRoot.join("idPiatto");
            Predicate predicate=cb.equal(piattoEntityJoin.get("idPiatto"),filtroOrdineRequest.getIdPiatto());
            predicateList.add(predicate);
        }
        if (filtroOrdineRequest.getNumeroDelTavolo()!= null) {
            Join<OrdineFinaleEntity, TavoloEntity> piattoEntityJoin=ordineFinaleEntityRoot.join("numeroDelTavolo");
            Predicate predicate=cb.equal(piattoEntityJoin.get("numeroDelTavolo"),filtroOrdineRequest.getNumeroDelTavolo());
            predicateList.add(predicate);
        }
        if (filtroOrdineRequest.getDataOrdine() != null) {
            Predicate predicate=cb.equal(ordineFinaleEntityRoot.get("dataOrdine"),filtroOrdineRequest.getDataOrdine());
            predicateList.add(predicate);
        }
        if (filtroOrdineRequest.getDataOrdineMin() != null) {
            Predicate predicate=cb.greaterThanOrEqualTo(ordineFinaleEntityRoot.get("dataOrdine"),filtroOrdineRequest.getDataOrdineMin());
            predicateList.add(predicate);
        }
        if (filtroOrdineRequest.getDataOrdineMax() != null) {
            Predicate predicate=cb.lessThanOrEqualTo(ordineFinaleEntityRoot.get("dataOrdine"),filtroOrdineRequest.getDataOrdineMax());
            predicateList.add(predicate);
        }
        if (filtroOrdineRequest.getPrezzoOrdine() != null) {
            Predicate predicate=cb.equal(ordineFinaleEntityRoot.get("prezzoOrdine"),filtroOrdineRequest.getPrezzoOrdine());
            predicateList.add(predicate);
        }
        if (filtroOrdineRequest.getPrezzoOrdineMin() != null) {
            Predicate predicate=cb.greaterThanOrEqualTo(ordineFinaleEntityRoot.get("prezzoOrdine"),filtroOrdineRequest.getPrezzoOrdineMin());
            predicateList.add(predicate);
        }
        if (filtroOrdineRequest.getPrezzoOrdineMax() != null) {
            Predicate predicate=cb.lessThanOrEqualTo(ordineFinaleEntityRoot.get("prezzoOrdine"),filtroOrdineRequest.getPrezzoOrdineMax());
            predicateList.add(predicate);
        }

        cq.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
