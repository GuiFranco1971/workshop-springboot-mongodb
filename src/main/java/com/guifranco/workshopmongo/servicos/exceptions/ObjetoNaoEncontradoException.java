package com.guifranco.workshopmongo.servicos.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontradoException(String message) {
		super(message);
	}
	
}
