package com.example.pepe.blu.repository;

import com.example.pepe.blu.filters.FiltroPaymentRequest;
import com.example.pepe.blu.entities.EmployerEntity;
import com.example.pepe.blu.entities.PaymentEmployerEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomPaymentRepositoryImpl implements CustomPaymentRepository {


    final EntityManager entityManager;

    public CustomPaymentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PaymentEmployerEntity> findPaymentBYFiltro(FiltroPaymentRequest filtroPaymentRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PaymentEmployerEntity> cq = cb.createQuery(PaymentEmployerEntity.class);
        Root<PaymentEmployerEntity> paymentEmployerEntityRoot = cq.from(PaymentEmployerEntity.class);
        List<Predicate> predicateList = new ArrayList<>();

        if (filtroPaymentRequest.getDataDelPAgamento() != null) {
            Predicate predicate = cb.equal(paymentEmployerEntityRoot.get("dataDelPAgamento"), filtroPaymentRequest.getDataDelPAgamento());
            predicateList.add(predicate);
        }
        if (filtroPaymentRequest.getImportoNetto() != null) {
            Predicate predicate = cb.equal(paymentEmployerEntityRoot.get("importoNetto"), filtroPaymentRequest.getImportoNetto());
            predicateList.add(predicate);
        }
        if (filtroPaymentRequest.getImportoNettoMax() != null) {
            Predicate predicate = cb.lessThanOrEqualTo(paymentEmployerEntityRoot.get("importoNetto"), filtroPaymentRequest.getImportoNettoMax());
            predicateList.add(predicate);
        }
        if (filtroPaymentRequest.getImportoNettoMin() != null) {
            Predicate predicate = cb.greaterThanOrEqualTo(paymentEmployerEntityRoot.get("importoNetto"), filtroPaymentRequest.getImportoNettoMin());
            predicateList.add(predicate);
        }
        if (filtroPaymentRequest.getMetodoDiPagamento() != null && !filtroPaymentRequest.getMetodoDiPagamento().isEmpty()) {
            Predicate predicate = cb.like(paymentEmployerEntityRoot.get("metodoDiPagamento"), "%" + filtroPaymentRequest.getMetodoDiPagamento() + "%");
            predicateList.add(predicate);
        }
        if (filtroPaymentRequest.getIdEmployer() != null) {
            Join<PaymentEmployerEntity, EmployerEntity> employerEntityJoin = paymentEmployerEntityRoot.join("numeroDelTavolo");
            Predicate predicate = cb.equal(employerEntityJoin.get("idEmployer"), filtroPaymentRequest.getIdEmployer());
            predicateList.add(predicate);
        }
        cq.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}















