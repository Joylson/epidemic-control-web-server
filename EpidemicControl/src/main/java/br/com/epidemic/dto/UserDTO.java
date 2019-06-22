package br.com.epidemic.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.modelmapper.ModelMapper;

import br.com.epidemic.entity.User;
import br.com.epidemic.enums.Perfil;
import lombok.Data;

@Data
public class UserDTO {
	private long id;
	@NotEmpty(message = "Campo Nome obrigatorio!!")
	@Length(max = 40, message = "Numero maximo de caracter 40!!")
	private String name;
	@NotEmpty(message = "Campo Login obrigatorio!!")
	@Length(max = 30, message = "Numero maximo de caracter 30!!")
	private String login;
	@NotEmpty(message = "Campo Senha obrigatorio!!")
	@Length(max = 30, message = "Numero maximo de caracter 30!!")
	private String password;
	@Length(max = 50, message = "Numero maximo de caracter 50!!")
	private String email;
	@CPF(message = "CPF Invalido!!")
	@NotNull(message = "Informe o CPF!!")
	private String cpf;
	@Length(max = 20, message = "Numero maximo de caracter 20!!")
	private String phone;

	@NotEmpty(message = "Informe um perfil!!")
	private Set<Perfil> perfis = new HashSet<>();

	public User toEntity() {
		ModelMapper map = new ModelMapper();
		return map.map(this, User.class);
	}
}
