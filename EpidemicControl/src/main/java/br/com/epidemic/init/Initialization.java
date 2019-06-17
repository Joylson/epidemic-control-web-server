package br.com.epidemic.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.epidemic.entity.User;
import br.com.epidemic.enums.Perfil;
import br.com.epidemic.repository.UserRepository;

@Configuration
public class Initialization implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setEmail("joylsont@gmail.com");
		user.setLogin("joylson");
		user.setName("Joylson");
		user.setPassword(bCryptPasswordEncoder.encode("123456"));
		user.setPerfis(Perfil.PROGRAMADOR);
		
	}

}
