package ar.com.vault.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.vault.hr.domain.Department;
import ar.com.vault.hr.domain.Location;
import ar.com.vault.hr.dto.DepartmentDto;
import ar.com.vault.hr.exception.DepartmentNotFoundException;
import ar.com.vault.hr.exception.LocationNotFoundException;
import ar.com.vault.hr.repository.DepartmentRepository;
import ar.com.vault.hr.repository.LocationRepository;

/**
 * 
 * @author Gaston Napoli
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    
    private LocationRepository locationRepository;
    
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, LocationRepository locationRepository) {

        this.departmentRepository = departmentRepository;
        this.locationRepository = locationRepository;
        
    }

    @Override
    public Department save(DepartmentDto dto) {
        
        Long id = dto.getLocationId();
        Location location = locationRepository.findById(id).orElseThrow(() -> new LocationNotFoundException(id));        
        Department newDepartment = Department.of(dto.getName(), location);
        
        return departmentRepository.save(newDepartment);
        
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

}
