package br.com.epidemic.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class SecurityConstants {
	
	@Value("${jwt.secret}") @Getter
	private String secret = "tokenJJ";
	@Value("${jwt.expiration}") @Getter
	private long ExpirationTime = 7_200_000; 
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
}
