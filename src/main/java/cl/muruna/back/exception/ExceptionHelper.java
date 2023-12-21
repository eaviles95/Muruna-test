package cl.muruna.back.exception;

import cl.muruna.back.util.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHelper {
    
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorResponse> notFound(EntityNotFoundException ex){

        return new ResponseEntity<>(
            new ErrorResponse(ex.getMessage(), 404, "Not found") , HttpStatus.NOT_FOUND);
    }
}
