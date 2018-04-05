package fr.hardis.formation.poe.fpgapi.api;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ResponseStatus(HttpStatus.CONFLICT) // 409
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> handleConflict(ConstraintViolationException e) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage("Il manque un param"), HttpStatus.CONFLICT);
	}
	

	@ResponseStatus(HttpStatus.CONFLICT) // 409
	@ExceptionHandler(UserExistException.class)
	public ResponseEntity<ErrorMessage> handleConflictUEE(UserExistException e) {
		 return new ResponseEntity<ErrorMessage>(new ErrorMessage("user exist"), HttpStatus.CONFLICT);
	}
	

}
