package br.com.epidemic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.epidemic.entity.Epidemic;

public interface EpidemicRepository extends JpaRepository<Epidemic, Long>{

}
