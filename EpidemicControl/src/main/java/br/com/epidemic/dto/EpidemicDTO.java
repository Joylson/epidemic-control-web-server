package br.com.epidemic.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import br.com.epidemic.entity.Epidemic;
import lombok.Data;

@Data
public class EpidemicDTO {
	
	private long id;
	@Length(max = 20, message = "Numero maximo de caracter 20!!")
	@NotNull(message = "Nome obrigatorio!!")
	private String name;
	@Length(max = 20, message = "Numero maximo de caracter 1000!!")
	@NotNull(message = "Descrição obrigatorio!!")
	private String description;
	@Length(max = 20, message = "Numero maximo de caracter 20!!")
	@NotNull(message = "Origem obrigatorio!!")
	private String origen;
	@Length(max = 20, message = "Numero maximo de caracter 20!!")
	@NotNull(message = "Nome cientifico obrigatorio!!")
	private String scientificName;
	@Length(max = 1000, message = "Numero maximo de caracter 1000!!")
	private String symptoms;
	

	@NotNull(message = "Usuario obrigatorio!!")
	private UserDTO User;
	
	public Epidemic toEntity() {
		ModelMapper map = new ModelMapper();
		return map.map(this, Epidemic.class);
	}
}
