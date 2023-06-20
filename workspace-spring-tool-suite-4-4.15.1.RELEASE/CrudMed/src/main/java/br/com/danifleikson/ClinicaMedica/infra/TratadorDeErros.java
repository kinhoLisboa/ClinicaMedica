package br.com.danifleikson.ClinicaMedica.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity tratarErro404() {

		return ResponseEntity.notFound().build();

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {

		var erro = ex.getFieldErrors();

		return ResponseEntity.badRequest().body(erro.stream().map(ErroValidacaoDTO::new).toList());
	}

	private record ErroValidacaoDTO(String campo, String mensagem) {

		private ErroValidacaoDTO(FieldError error) {

			this(error.getField(), error.getDefaultMessage());
		}

	}

}
