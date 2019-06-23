package br.com.epidemic.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.epidemic.dto.CaseDTO;
import lombok.Data;

@Entity
@Table(name = "epidemic_case")
@Data
public class Case {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "date_reg", nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, locale = "pt-BR", timezone = "Brazil/East")
	private Date dateReg;
	@Column(name = "latitude", nullable = false)
	private double latitude;
	@Column(name = "longitude", nullable = false)
	private double longitude;	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "epidemic_id")
	private Epidemic epidemic;	
	
	
	public CaseDTO toDTO() {
		ModelMapper map = new ModelMapper();
		return map.map(this, CaseDTO.class);
	}

}
