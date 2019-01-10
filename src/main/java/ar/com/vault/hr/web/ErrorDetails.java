package ar.com.vault.hr.web;

import java.util.Date;

import lombok.Data;

/**
 * Custom error response structure.
 * 
 * @author Gaston Napoli
 *
 */
@Data
public class ErrorDetails {

    private final Date timestamp;
    
    private final String error;
    
}
