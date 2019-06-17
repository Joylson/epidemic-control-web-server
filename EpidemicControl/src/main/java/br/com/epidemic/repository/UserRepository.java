package br.com.epidemic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.epidemic.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findByLogin(String login);
	
}
