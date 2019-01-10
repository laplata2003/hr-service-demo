package ar.com.vault.hr.service;

import java.util.List;

import ar.com.vault.hr.domain.Department;
import ar.com.vault.hr.dto.DepartmentDto;

public interface DepartmentService {

    Department save(DepartmentDto dto);
    
    Department findById(Long id);
    
    List<Department> findAll();
    
}
