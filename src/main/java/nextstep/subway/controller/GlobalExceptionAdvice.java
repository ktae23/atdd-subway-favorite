package nextstep.subway.controller;

import nextstep.common.ForbiddenException;
import nextstep.common.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Void> notFound(Exception ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(value = {IllegalStateException.class, IllegalArgumentException.class})
    public ResponseEntity<Void> badRequest(Exception ex) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = {ForbiddenException.class})
    public ResponseEntity<Void> forbidden(Exception ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
