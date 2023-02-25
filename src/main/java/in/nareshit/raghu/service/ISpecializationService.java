package in.nareshit.raghu.service;

import java.util.List;
import java.util.Map;

import in.nareshit.raghu.entity.Specialization;
import in.nareshit.raghu.service.impl.SpecializationNotFoundException;

public interface ISpecializationService {
	
	public Long saveSpecialization(Specialization spec);

	public List<Specialization> getAllSpecialiazation();

	public void removeSpecialization(Long id);

	public Specialization getOneSpecialization(Long id);
	public void updateSpecialization(Specialization spec);

	public boolean isSpecCodeExit(String specCode);

	public boolean isSpecCodeExitForEdit(String specCode, Long id);

	Map<Long, String> getSpecIdAndName();

	long getSpecializationCount();

}
