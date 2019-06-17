package br.com.epidemic.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.epidemic.entity.User;
import br.com.epidemic.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByLogin(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));		
		
		return new UserDetailsImpl(user.getId(), user.getLogin() , user.getPassword(), user.getPerfis());
	}

}
