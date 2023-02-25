package in.nareshit.raghu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.nareshit.raghu.entity.Specialization;


public interface SpecializationRepository  extends JpaRepository<Specialization, Long>{
	@Query("SELECT COUNT (specCode) FROM Specialization WHERE specCode=:specCode")
	Integer getSpecCodeCount(String specCode);
	
	@Query("SELECT COUNT (specCode) FROM Specialization WHERE specCode=:specCode AND id!=:id")
	Integer getSpecCodeForEdit(String specCode,Long id);
	
	@Query("SELECT Id,specName  FROM Specialization")
	List<Object[]> getSpectIdAndName();
	

}
