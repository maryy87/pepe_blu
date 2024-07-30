package com.example.pepe.blu.repository;

import com.example.pepe.blu.filters.FiltroEmployerRequest;
import com.example.pepe.blu.entities.DepartmentEntity;
import com.example.pepe.blu.entities.EmployerEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomEmployerRepositoryImpl implements CustomEmployerRepository {

    final EntityManager entityManager;

    public CustomEmployerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<EmployerEntity> findByFiltro(FiltroEmployerRequest filtroEmployerRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployerEntity> cq = cb.createQuery(EmployerEntity.class);
        Root<EmployerEntity> employerEntityRoot = cq.from(EmployerEntity.class);
        List<Predicate> predicateList = new ArrayList<>();

        if (filtroEmployerRequest.getCognomeEmployer() != null && !filtroEmployerRequest.getCognomeEmployer().isEmpty()) {
            Predicate predicate = cb.like(employerEntityRoot.get("cognomeEmployer"), "%" + filtroEmployerRequest.getCognomeEmployer() + "%");
            predicateList.add(predicate);
        }
        if (filtroEmployerRequest.getNomeEmployer() != null && !filtroEmployerRequest.getNomeEmployer().isEmpty()) {
            Predicate predicate = cb.like(employerEntityRoot.get("nomeEmployer"), "%" + filtroEmployerRequest.getNomeEmployer() + "%");
            predicateList.add(predicate);
        }
        if (filtroEmployerRequest.getStato() != null && !filtroEmployerRequest.getStato().isEmpty()) {
            Predicate predicate = cb.like(employerEntityRoot.get("stato"), "%" + filtroEmployerRequest.getStato() + "%");
            predicateList.add(predicate);
        }

        if (filtroEmployerRequest.getRuolo() != null) {
            Predicate predicate = cb.equal(employerEntityRoot.get("ruolo"), filtroEmployerRequest.getRuolo().name());
            predicateList.add(predicate);
        }
        if (filtroEmployerRequest.getNomeDipartimento() != null) {
            Join<EmployerEntity, DepartmentEntity> departmentJoin = employerEntityRoot.join("departmentEntity");

            Predicate predicate = cb.equal(departmentJoin.get("nomeDepartment"), filtroEmployerRequest.getNomeDipartimento());

            predicateList.add(predicate);
        }
        cq.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }

}
