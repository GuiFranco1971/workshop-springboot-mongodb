package com.guifranco.workshopmongo.recursos.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.guifranco.workshopmongo.servicos.exceptions.ObjetoNaoEncontradoException;

@ControllerAdvice
public class RecursoExceptionHandler {

	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjetoNaoEncontradoException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError erro = new StandardError(System.currentTimeMillis(),
											  status.value(),
											  "Não Encontrado",
											  e.getMessage(),
											  request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
}
