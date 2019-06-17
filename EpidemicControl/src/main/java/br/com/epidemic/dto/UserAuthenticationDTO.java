package br.com.epidemic.dto;

import br.com.epidemic.dto.UserAuthenticationDTO;
import lombok.Data;

@Data
public class UserAuthenticationDTO {

	private String login;
	private String password;

}
