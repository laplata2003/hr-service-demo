package ar.com.vault.hr.exception;

public class LocationNotFoundException extends EntityNotFoundException {

    /**
     * 
     */
    private static final long serialVersionUID = 1508198561182218620L;

    public LocationNotFoundException(long locationId) {
        super("Ubicacion " + locationId + " no encontrads.");
    }

}
