package com.example.pepe.blu.repository;

import com.example.pepe.blu.entities.OrdineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineRepository extends JpaRepository<OrdineEntity,Integer>{

@Query(nativeQuery = true,value = " insert into ordine VALUES()  returning *")
    public OrdineEntity saveOrdine();

}
