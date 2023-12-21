package cl.muruna.back.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("serial")
public class GenericException extends RuntimeException{

    public GenericException(String message) {
        super(message);
        log.error(message);
    }
    
}
