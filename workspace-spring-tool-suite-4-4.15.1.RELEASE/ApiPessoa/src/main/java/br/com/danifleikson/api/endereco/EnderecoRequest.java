package br.com.danifleikson.api.endereco;

import br.com.danifleikson.api.endereco.domain.TipoEndereco;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Value;

@Value
@Data
public class EnderecoRequest {
	@NotBlank
	private String logradouro;
	@NotBlank
	private String cep;
	@NotBlank
	private String numero;
	@NotBlank
	private String cidade;
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;
	
	

}
