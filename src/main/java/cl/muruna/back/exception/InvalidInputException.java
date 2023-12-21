package cl.muruna.back.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("serial")
public class InvalidInputException extends RuntimeException{
    
    static final String MESSAGE = "Invalid Input Exception";

    public InvalidInputException(String inputType){
        super(MESSAGE);
        log.error(MESSAGE, inputType);
    }
}
