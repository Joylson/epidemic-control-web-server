package br.com.epidemic.config.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.epidemic.enums.Perfil;
import lombok.Getter;
import lombok.Setter;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private long id;
	private String login;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(long id, String login, String password, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao()))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
