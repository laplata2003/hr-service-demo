package ar.com.vault.hr.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.vault.hr.domain.Department;
import ar.com.vault.hr.dto.DepartmentDto;
import ar.com.vault.hr.service.DepartmentService;

/**
 * REST API for Departments handling.
 * 
 * @author Gaston Napoli
 *
 */
@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments/{id}")
    Department findDepartmentById(@PathVariable("id") Long id) {
        return departmentService.findById(id);
    }

    @GetMapping("/departments")
    List<Department> findAll() {
        return departmentService.findAll();
    }
    
    @PostMapping("/departments")
    Department createNewDepartment(@Valid @RequestBody DepartmentDto dto) {
        return departmentService.save(dto);
    }

}
