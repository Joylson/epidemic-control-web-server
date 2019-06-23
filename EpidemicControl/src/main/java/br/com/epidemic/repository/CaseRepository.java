package br.com.epidemic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.epidemic.entity.Case;

public interface CaseRepository extends JpaRepository<Case, Long> {

	@Query("select c from Case c where c.latitude between :lat1 and :lat2 and c.longitude between :lon1 and :lon2")
	public List<Case> findByArea(@Param("lat1") double lat1, @Param("lat2") double lat2, @Param("lon1") double lon1,
			@Param("lon2") double lon2);
	
	public List<Case> findByEpidemicId(long id);
	
	@Query("select c from Case c where c.latitude between :lat1 and :lat2 and c.longitude between :lon1 and :lon2 and c.epidemic.id = :id")
	public List<Case> findByAreaEpidemic(@Param("lat1") double lat1, @Param("lat2") double lat2, @Param("lon1") double lon1,
			@Param("lon2") double lon2, @Param("id") long id);
}
