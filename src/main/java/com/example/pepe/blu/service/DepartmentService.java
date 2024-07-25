package com.example.pepe.blu.service;

import com.example.pepe.blu.dto.request.FiltroDepartementRequest;
import com.example.pepe.blu.repository.CustomDepartmentRepository;
import com.example.pepe.blu.repository.DepartmentRepository;
import com.example.pepe.blu.dto.request.DepartmentRequest;
import com.example.pepe.blu.dto.response.DepartmentResponse;
import com.example.pepe.blu.entities.DepartmentEntity;
import com.example.pepe.blu.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private CustomDepartmentRepository customDepartmentRepository;

    public List<DepartmentResponse> ricercaDepartment(FiltroDepartementRequest filtroDepartementRequest){
        if (filtroDepartementRequest != null) {
            List<DepartmentResponse> departmentResponseList=departmentMapper.mapDepartmentEntityListToResponseList(customDepartmentRepository.findDepartmentByFiltro(filtroDepartementRequest));
            return departmentResponseList;
        }
        return new ArrayList<>();
    }

    public DepartmentResponse addDepartment(DepartmentRequest departmentRequest) {
        DepartmentEntity department = departmentMapper.mapDepartmentRequestToEntity(departmentRequest);
        if (department != null) {
            DepartmentEntity departmentEntity = departmentRepository.save(department);
            return departmentMapper.mapDepartmentEntityToResponse(departmentEntity);
        }
        return null;
    }

    public DepartmentResponse updateDepartment(DepartmentRequest departmentRequest, int id) {
        DepartmentEntity department = departmentMapper.mapDepartmentRequestToEntity(departmentRequest);
        if (departmentRepository.findById(id).isPresent()) {
            department.setIdDepartment(id);
            DepartmentEntity departmentEntity = departmentRepository.save(department);
            return departmentMapper.mapDepartmentEntityToResponse(departmentEntity);
        }
        return null;
    }

    public Boolean deleteDepartment(int id) {
        if (departmentRepository.findById(id).isPresent()) {
            departmentRepository.deleteById(id);
            if (departmentRepository.findById(id).isPresent()) {
                return false;
            }
            return true;
        }
        return false;
    }


    public DepartmentResponse ricercaDepartment( int id) {
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(id);
        if (departmentEntity.isPresent()) {
            return departmentMapper.mapDepartmentEntityToResponse(departmentEntity.get());
        }
        return null;
    }


}
