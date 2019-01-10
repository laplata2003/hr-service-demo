package ar.com.vault.hr.exception;

public class DepartmentNotFoundException extends EntityNotFoundException {

    /**
     * 
     */
    private static final long serialVersionUID = 5341940690319464079L;

    public DepartmentNotFoundException(long departmentId) {
        super("Departamento " + departmentId + " no encontrado.");
    }
    
}
