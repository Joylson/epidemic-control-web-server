package br.com.epidemic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.epidemic.entity.User;
import br.com.epidemic.repository.UserRepository;
import br.com.epidemic.service.exception.BusinessException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User save(User user) {
		repository.findByLogin(user.getLogin()).ifPresent(u -> {
			throw new BusinessException("Login ja cadastrado favor informa um novo!!");
		});
		
		repository.findByCpf(user.getCpf()).ifPresent(u -> {
			throw new BusinessException("CPF ja cadastrado favor informar um novo!!");
		});

		user.setId(0);
		User u = repository.save(user);
		return u;
	}

	public User update(User user) {
		if (user.getId() == 0) {
			throw new NullPointerException("Necessario informar ID!!");
		}

		repository.findById(user.getId())
				.orElseThrow(() -> new NullPointerException("Usuario não encontrado pra edição!!"));

		return repository.save(user);
	}

	public User findById(long id) {
		return repository.findById(id).orElseThrow(() -> new NullPointerException("Usuario não encontrado!!"));
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public void delete(long id) {
		User u = repository.
				findById(id).orElseThrow(() -> new NullPointerException("Usuario não encontrado!!"));
		
		repository.delete(u);
	}
}
