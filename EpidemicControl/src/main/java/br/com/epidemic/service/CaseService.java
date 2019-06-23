package br.com.epidemic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.epidemic.entity.Case;
import br.com.epidemic.repository.CaseRepository;
import br.com.epidemic.service.exception.BusinessException;


@Service
public class CaseService {
	@Autowired
	private CaseRepository repository;

	public Case save(Case Case) {
		Case.setId(0);
		Case ep = repository.save(Case);
		return ep;
	}

	public Case update(Case Case) {
		if (Case.getId() == 0) {
			throw new NullPointerException("Necessario informar ID!!");
		}

		repository.findById(Case.getId())
				.orElseThrow(() -> new NullPointerException("Caso não encontrado pra edição!!"));
		return repository.save(Case);
	}

	public Case findById(long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NullPointerException("Caso não encontrada!!"));
	}

	public List<Case> findAll() {
		return repository.findAll();
	}
	
	public void delete(long id) {
		Case ep = repository.
				findById(id).orElseThrow(() -> new NullPointerException("Caso não encontrado!!"));
		
		repository.delete(ep);
	}
	
	public List<Case> findByArea(double[] latitude, double[] longitude){
		if(latitude.length != 2) {
			throw new BusinessException("Informe latitude corretamente!!");
		}
		if(longitude.length != 2) {
			throw new BusinessException("Informe longitude corretamente!!");
		}
		
		return repository.findByArea(latitude[0], latitude[1], longitude[0], longitude[1]);
	}
	
	public List<Case> findByAreaEpidemic(double[] latitude, double[] longitude, long id){
		if(latitude.length != 2) {
			throw new BusinessException("Informe latitude corretamente!!");
		}
		if(longitude.length != 2) {
			throw new BusinessException("Informe longitude corretamente!!");
		}
		
		return repository.findByAreaEpidemic(latitude[0], latitude[1], longitude[0], longitude[1], id);
	}
	
	public List<Case> findByEpidemicId(long id) {
		List<Case> cases = repository.findByEpidemicId(id);
		return cases;		
	}
}
