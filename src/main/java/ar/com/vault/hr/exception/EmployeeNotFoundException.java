package ar.com.vault.hr.exception;

public class EmployeeNotFoundException extends EntityNotFoundException {

    /**
     * 
     */
    private static final long serialVersionUID = 241060260445304053L;

    public EmployeeNotFoundException(long employeeId) {
        super("Empleado " + employeeId + " no encontrado.");
    }

}
