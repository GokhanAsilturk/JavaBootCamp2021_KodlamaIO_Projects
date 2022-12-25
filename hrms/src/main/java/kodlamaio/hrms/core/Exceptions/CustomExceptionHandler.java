package kodlamaio.hrms.core.Exceptions;

import kodlamaio.hrms.core.utilities.results.ErrorResults.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})

    public ResponseEntity<?> IllegalArgumentExceptionHandler(IllegalArgumentException illegalArgumentException, WebRequest request) {
        return new ResponseEntity(new ErrorResult(illegalArgumentException.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
