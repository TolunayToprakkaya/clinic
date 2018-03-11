package com.project.clinic.controllers.nurse;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.clinic.models.Nurse;
import com.project.clinic.repositories.DepartmentRepository;
import com.project.clinic.repositories.NurseRepository;
import com.project.clinic.services.NurseService;

@Controller
@RequestMapping(value = "/nurses")
public class NurseController {

	@Autowired
	private DepartmentRepository departmentRepository;	
	
	@Autowired
	private NurseRepository nurseRepository;
	
	@Autowired
	private NurseService nurseService;
	
	public void setNurseService(NurseService nurseService) {
		this.nurseService = nurseService;
	}
	
	@RequestMapping(value = {"", "/"})
	public String list(@RequestParam(name = "value", required = false) String value, Model model) {
		if(value != null) {
			model.addAttribute("activePage", "nurses");
			model.addAttribute("value", value);
			model.addAttribute("nurses", this.nurseRepository.findOneByName(value));
			return "nurses/list";
		}else {
			model.addAttribute("activePage", "nurses");
			model.addAttribute("departments", this.departmentRepository.findAll());
			model.addAttribute("nurses", this.nurseRepository.findAll());
			return "nurses/list";
		}
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Nurse nurse, Model model) {
		model.addAttribute("departments", this.departmentRepository.findAll());
		model.addAttribute("activePage", "nurses");
		return "nurses/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Nurse nurse, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("activePage", "nurses");
			return "nurses/add";
		}
		this.nurseService.save(nurse);
		return "redirect:/nurses";
	}
	
	@RequestMapping(value = "/view/{nurse_id}")
	public String view(@PathVariable Integer nurse_id, Model model) {
		model.addAttribute("nurse", this.nurseService.findOneById(nurse_id));
		model.addAttribute("activePage", "nurses");
		return "nurses/view";
	}
	
	@RequestMapping(value = "/edit/{nurse_id}")
	public String edit(@PathVariable Integer nurse_id, Model model) {
		model.addAttribute("nurse", this.nurseService.findOneById(nurse_id));
		model.addAttribute("departments", this.departmentRepository.findAll());
		model.addAttribute("activePage", "nurses");
		return "nurses/edit";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Nurse nurse) {
		this.nurseService.save(nurse);
		return "redirect:/nurses/view/" + nurse.getNurse_id();
	}
	
	@RequestMapping(value = "/delete/{nurse_id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer nurse_id) {
		this.nurseService.delete(nurse_id);
		return "redirect:/nurses";
	}
}
