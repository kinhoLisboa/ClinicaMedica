package br.com.danifleikson.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class TratadorDeErro {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity tratarErro404() {
		return ResponseEntity.notFound().build();
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
		
		var erro = ex.getFieldErrors();
		
		return ResponseEntity.badRequest().body(erro.stream().map(ErroValidacaoDTO::new).toList());
		
	}
	
	@ExceptionHandler(QuantidadeEnderecoPrincipalInválida.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErroValidacaoDTO erroQuantidadeEndereco(QuantidadeEnderecoPrincipalInválida ex) {
		
		return new ErroValidacaoDTO("endereco", ex.getMessage());
	}
	
	private record ErroValidacaoDTO(String campo, String mensagem) {

		private ErroValidacaoDTO(FieldError error) {

			this(error.getField(), error.getDefaultMessage());
		}

	}

}
	
	

	

