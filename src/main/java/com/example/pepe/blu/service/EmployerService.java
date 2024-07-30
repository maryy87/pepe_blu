package com.example.pepe.blu.service;

import com.example.pepe.blu.filters.FiltroEmployerRequest;
import com.example.pepe.blu.repository.CustomEmployerRepository;
import com.example.pepe.blu.repository.EmployerRepository;
import com.example.pepe.blu.dto.request.EmployerRequest;
import com.example.pepe.blu.dto.EmployerResponse;
import com.example.pepe.blu.entities.EmployerEntity;
import com.example.pepe.blu.mapper.EmployerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private EmployerMapper employerMapper;
    @Autowired
    private CustomEmployerRepository customEmployerRepository;

    public List<EmployerResponse> ricercaEmployer(FiltroEmployerRequest filtroEmployerRequest){
        if (filtroEmployerRequest != null) {
            List<EmployerResponse> employerResponseList=employerMapper.mapEmployerEntityListToResponseLIst(customEmployerRepository.findByFiltro(filtroEmployerRequest));
            return employerResponseList;
        }
        return new ArrayList<>();
    }

    public EmployerResponse addEmployer(EmployerRequest employerRequest) {
        EmployerEntity employerEntity = employerMapper.mapEmployerRequestToEntity(employerRequest);
        if (employerEntity != null) {
            EmployerEntity employer = employerRepository.save(employerEntity);
            return employerMapper.mapEmployerEntityToResponse(employer);
        }
        return null;
    }

    public EmployerResponse updateEmployer(EmployerRequest employerRequest, int id) {
        EmployerEntity employerEntity = employerMapper.mapEmployerRequestToEntity(employerRequest);
        if (employerRepository.findById(id).isPresent()) {
            employerEntity.setIdEmployer(id);
            EmployerEntity employer = employerRepository.save(employerEntity);
            return employerMapper.mapEmployerEntityToResponse(employer);
        }
        return null;
    }

    public Boolean deleteEmployer(int id) {
        if (employerRepository.findById(id).isPresent()) {
            employerRepository.deleteById(id);
            if (employerRepository.findById(id).isPresent()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public EmployerResponse ricercaEmployer(int id) {
        Optional<EmployerEntity> employerEntity = employerRepository.findById(id);
        if (employerEntity.isPresent()) {
            return employerMapper.mapEmployerEntityToResponse(employerEntity.get());
        }

        return null;
    }
}
