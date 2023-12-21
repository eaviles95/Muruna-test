package cl.muruna.back.exception;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@SuppressWarnings("serial")
public class EntityNotFoundExceptionId extends RuntimeException{
    static final String MESSAGE = "Entity %s(%d) not found";

    public EntityNotFoundExceptionId(Integer id, String entityName) {
        super(String.format(MESSAGE, entityName, id));
        log.error(String.format(MESSAGE, entityName, id));
    }

}
