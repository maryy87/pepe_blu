package com.example.pepe.blu.repository;

import com.example.pepe.blu.dto.request.FiltroDepartementRequest;
import com.example.pepe.blu.entities.BevandeEntity;
import com.example.pepe.blu.entities.DepartmentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomDepartmentRepositoryImpl implements CustomDepartmentRepository{

    final EntityManager entityManager;

    public CustomDepartmentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<DepartmentEntity> findDepartmentByFiltro(FiltroDepartementRequest filtroDepartementRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DepartmentEntity> cq = cb.createQuery(DepartmentEntity.class);
        Root<DepartmentEntity> departmentEntityRoot = cq.from(DepartmentEntity.class);
        List<Predicate> predicateList = new ArrayList<>();

        if (filtroDepartementRequest.getBudgetDepartment() != null) {
            Predicate predicate=cb.equal(departmentEntityRoot.get("budgetDepartment"),filtroDepartementRequest.getBudgetDepartment());
            predicateList.add(predicate);
        }
        if (filtroDepartementRequest.getBudgetDepartmentMax() != null) {
            Predicate predicate=cb.lessThanOrEqualTo(departmentEntityRoot.get("budgetDepartment"),filtroDepartementRequest.getBudgetDepartmentMax());
            predicateList.add(predicate);
        }
        if (filtroDepartementRequest.getBudgetDepartmentMin() != null) {
            Predicate predicate=cb.greaterThanOrEqualTo(departmentEntityRoot.get("budgetDepartment"),filtroDepartementRequest.getBudgetDepartmentMin());
            predicateList.add(predicate);
        }
        if (filtroDepartementRequest.getNumeroDipendenti()!= null) {
            Predicate predicate=cb.equal(departmentEntityRoot.get("numeroDipendenti"),filtroDepartementRequest.getNumeroDipendenti());
            predicateList.add(predicate);
        }
        if (filtroDepartementRequest.getNumeroDipendentiMax()!= null) {
            Predicate predicate=cb.lessThanOrEqualTo(departmentEntityRoot.get("numeroDipendenti"),filtroDepartementRequest.getNumeroDipendentiMax());
            predicateList.add(predicate);
        }
        if (filtroDepartementRequest.getNumeroDipendentiMin()!= null) {
            Predicate predicate=cb.greaterThanOrEqualTo(departmentEntityRoot.get("numeroDipendenti"),filtroDepartementRequest.getNumeroDipendentiMin());
            predicateList.add(predicate);
        }
        if (filtroDepartementRequest.getNomeDepartment() != null && !filtroDepartementRequest.getNomeDepartment().isEmpty()) {
            Predicate predicate=cb.like(departmentEntityRoot.get("nomeDepartment"),"%"+ filtroDepartementRequest.getNomeDepartment() +"%");
            predicateList.add(predicate);
        }

        cq.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
