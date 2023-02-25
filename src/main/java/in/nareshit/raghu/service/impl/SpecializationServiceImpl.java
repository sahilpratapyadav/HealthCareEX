package in.nareshit.raghu.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.entity.Specialization;
import in.nareshit.raghu.repo.SpecializationRepository;
import in.nareshit.raghu.service.ISpecializationService;
import in.nareshit.raghu.util.MyCollectionUtil;
@Service
public class SpecializationServiceImpl implements ISpecializationService {
    
	@Autowired
	private SpecializationRepository repo;

	public Long saveSpecialization(Specialization spec) {
		// TODO Auto-generated method stub
		return repo.save(spec).getId();
	}

	public List<Specialization> getAllSpecialiazation() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void removeSpecialization(Long id) {
		// TODO Auto-generated method stub
		// repo.deleteById(id);
		repo.delete(getOneSpecialization(id));

	}

	public Specialization getOneSpecialization(Long id) {
		Optional<Specialization> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new SpecializationNotFoundException(id + "NOT FOUND");
		}
		
		/*return repo.findById(id).orElseThrow(
				()->new SpecializationNotFoundException("String"));
				*/

	}

	public void updateSpecialization(Specialization spec) {
		repo.save(spec);
	}

	public boolean isSpecCodeExit(String specCode) {
		/* Integer count=repo.getSpecCodeCount(specCode);
		boolean exits=count>0?true:false;
		return exit;*/
		return repo.getSpecCodeCount(specCode)>0;
	}

	public boolean isSpecCodeExitForEdit(String specCode, Long id) {
		
		return repo.getSpecCodeForEdit(specCode,id)>0;
	}

	public Map<Long, String> getSpecIdAndName() {
		List<Object[]> list=repo.getSpectIdAndName();
		Map<Long,String> map=MyCollectionUtil.convertToMap(list);
		return map;
	}

	public long getSpecializationCount() {
		// TODO Auto-generated method stub
		return repo.count();
	}

}


                                                                                                                                                                                                   
