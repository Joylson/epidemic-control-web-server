package br.com.epidemic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.epidemic.dto.EpidemicDTO;
import lombok.Data;

@Entity
@Table(name = "epidemic_epidemic")
@Data
public class Epidemic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nome", length = 50, nullable = false)
	private String name;
	@Column(name = "discretion", length = 1000, nullable = false)
	private String description;
	@Column(name = "origen", length = 20, nullable = false)
	private String origen;
	@Column(name = "scientific_name", nullable = false)
	private String scientificName;
	@Column(name = "symptoms", length = 1000)
	private String symptoms;

	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;	
	public EpidemicDTO toDTO() {
		ModelMapper map = new ModelMapper();
		return map.map(this, EpidemicDTO.class);
	}
}
