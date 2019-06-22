package br.com.epidemic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.epidemic.entity.Epidemic;
import br.com.epidemic.repository.EpidemicRepository;

@Service
public class EpidemicService {

	@Autowired
	private EpidemicRepository repository;

	public Epidemic save(Epidemic epidemic) {
		epidemic.setId(0);
		Epidemic ep = repository.save(epidemic);
		return ep;
	}

	public Epidemic update(Epidemic epidemic) {
		if (epidemic.getId() == 0) {
			throw new NullPointerException("Necessario informar ID!!");
		}

		repository.findById(epidemic.getId())
				.orElseThrow(() -> new NullPointerException("Epidemia não encontrado pra edição!!"));
		return repository.save(epidemic);
	}

	public Epidemic findById(long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NullPointerException("Epidemia não encontrada!!"));
	}

	public List<Epidemic> findAll() {
		return repository.findAll();
	}
	
	public void delete(long id) {
		Epidemic ep = repository.
				findById(id).orElseThrow(() -> new NullPointerException("Epidemia não encontrado!!"));
		
		repository.delete(ep);
	}
}
