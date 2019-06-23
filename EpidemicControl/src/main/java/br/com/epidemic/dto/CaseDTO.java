package br.com.epidemic.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.epidemic.entity.Case;
import lombok.Data;

@Data
public class CaseDTO {
	private long id;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, locale = "pt-BR", timezone = "Brazil/East")
	@NotNull(message = "Necessario informar data de registro!!")
	private Date dateReg;
	@NotNull(message = "Necessario informar data de latitude!!")
	private double latitude;
	@NotNull(message = "Necessario informar data de longitude!!")
	private double longitude;	
	

	@NotNull(message = "Necessario informar data de registro!!")
	private EpidemicDTO epidemic;	
	
	public Case toEntity() {
		ModelMapper map = new ModelMapper();
		return map.map(this, Case.class);
	}

}
