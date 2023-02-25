package in.nareshit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nareshit.raghu.entity.Specialization;
import in.nareshit.raghu.service.ISpecializationService;
import in.nareshit.raghu.service.impl.SpecializationNotFoundException;

/**
 * @author sahiyada
 *
 */
/**
 * @author sahiyada
 *
 */
@Controller
@RequestMapping("/spec")
public class SpecializationController {
	
	@Autowired
	private ISpecializationService service;
	
	//1 Show Register page
	@GetMapping("/register")
	public String displayRegister() {
		return "SpecializationRegister";
		
	}
	
	@PostMapping("/save")
	public String saveForm(@ModelAttribute Specialization specialiazation,Model model) {
		Long id=service.saveSpecialization(specialiazation);
		String message="Record ("+id+") is created";
		model.addAttribute("message", message);
		
		return "SpecializationRegister";
		
	}
	// 3 display all Specializations 
	@GetMapping("/all")
	public String viewAll(Model model,@RequestParam(value ="message" ,required=false) String message) {
		List<Specialization> list=service.getAllSpecialiazation();
		model.addAttribute("message", message);
		return "SpecializationData";
		
	}
	
	//4 delete by id
	@GetMapping("/delete")
	public String deleteData(@RequestParam Long id,RedirectAttributes attributes) {
		try {
			service.removeSpecialization(id);
			attributes.addAttribute("message"," Record ("+id+") is removed");
		} catch (SpecializationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addAttribute("message",e.getMessage());
		}
		return "redirect:all";
		
	}
	
	//5  edit page
	@GetMapping("/edit")
	public String showEditPage(@RequestParam Long id,Model model,RedirectAttributes attributes) {
		String page=null;
		try {
			Specialization spec=service.getOneSpecialization(id);
			model.addAttribute("specialization",spec);
			page="SpecializationEdit";
		}catch(SpecializationNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect :all";
		}
		return page;
		
	}
	
	//6  update form data and redirect all
	
	public String updateData(@ModelAttribute Specialization specialization, RedirectAttributes attributes) {
		service.updateSpecialization(specialization);
		attributes.addAttribute("message", "Record ("+ specialization.getId()+") is update"); 
		return "redirect :all";
		
	}
	

}
