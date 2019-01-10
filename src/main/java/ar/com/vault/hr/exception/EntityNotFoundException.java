package ar.com.vault.hr.exception;

public abstract class EntityNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -5243488639776909002L;


    public EntityNotFoundException(String message) {
        super(message);
    }
    
}
