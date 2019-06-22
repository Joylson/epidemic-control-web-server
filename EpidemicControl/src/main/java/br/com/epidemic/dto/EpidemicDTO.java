package br.com.epidemic.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import br.com.epidemic.entity.Epidemic;
import br.com.epidemic.entity.User;
import lombok.Data;

@Data
public class EpidemicDTO {
	
	private long id;
	@Length(max = 20, message = "Numero maximo de caracter 20!!")
	@NotNull(message = "Nome obrigatorio!!")
	private String nome;
	@Length(max = 20, message = "Numero maximo de caracter 1000!!")
	@NotNull(message = "Descrição obrigatorio!!")
	private String discretion;
	@Length(max = 20, message = "Numero maximo de caracter 20!!")
	@NotNull(message = "Origem obrigatorio!!")
	private String origen;
	@Length(max = 20, message = "Numero maximo de caracter 20!!")
	@NotNull(message = "Nome cientifico obrigatorio!!")
	private String scientificName;
	

	@NotNull(message = "Usuario obrigatorio!!")
	private User User;
	@NotEmpty(message = "Sintomas obrigatorio")
	private Set<String> symptoms = new HashSet<>();
	
	public Epidemic toEntity() {
		ModelMapper map = new ModelMapper();
		return map.map(this, Epidemic.class);
	}
}
