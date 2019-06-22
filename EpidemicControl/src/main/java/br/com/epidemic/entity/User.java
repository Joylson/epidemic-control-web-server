package br.com.epidemic.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.epidemic.dto.UserDTO;
import br.com.epidemic.enums.Perfil;
import lombok.Data;


interface ListAdd <E>{
	boolean add(E e);
}


@Entity
@Table(name = "user")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name", length = 40, nullable = false)
	private String name;
	@Column(name = "login", length = 30, nullable = false, unique = true)
	private String login;
	@JsonIgnore
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "email", length = 50)
	private String email;

	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.ORDINAL)
	@CollectionTable(name = "perfil")
	private  Set<Perfil> perfis = new HashSet<>();
	
	public void addPerfil(Perfil p) {
		this.perfis.add(p);
	}	

	public UserDTO toDTO() {
		ModelMapper map = new ModelMapper();
		return map.map(this, UserDTO.class);
	}
}
