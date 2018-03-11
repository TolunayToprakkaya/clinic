package com.project.clinic.controllers.doctor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.clinic.models.Doctor;
import com.project.clinic.repositories.DepartmentRepository;
import com.project.clinic.repositories.DoctorRepository;
import com.project.clinic.services.DoctorService;

@Controller
@RequestMapping("/doctors")
public class DoctorController{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DoctorRepository doctorRepository;	
	
	@Autowired
	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	@RequestMapping(value = {"", "/"})
	public String list(@RequestParam(name = "value", required = false) String value, @RequestParam(defaultValue="0") int page, Model model) {
		if(value != null) {
			model.addAttribute("activePage", "doctors");
			model.addAttribute("value", value);
			model.addAttribute("doctors", this.doctorRepository.findOneByName(value));
			return "doctors/list";
		}else {
			model.addAttribute("activePage", "doctors");
			model.addAttribute("departments", this.departmentRepository.findAll(new PageRequest(page, 4)));
			model.addAttribute("doctors", this.doctorRepository.findAll(new PageRequest(page, 4)));
			model.addAttribute("currentPage", page);
			return "doctors/list";
		}
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Doctor doctor, Model model) {
		model.addAttribute("departments", this.departmentRepository.findAll());
		model.addAttribute("activePage", "doctors");
		return "doctors/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Doctor doctor, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("activePage", "doctors");
			return "doctors/add";
		}
		this.doctorService.save(doctor);
		return "redirect:/doctors";
	}
	
	@RequestMapping(value = "/view/{doctor_id}")
	public String view(@PathVariable Integer doctor_id, Model model) {
		model.addAttribute("doctor", this.doctorService.findOneById(doctor_id));
		model.addAttribute("activePage", "doctors");
		return "doctors/view";
	}
	
	@RequestMapping(value = "/edit/{doctor_id}")
	public String edit(@PathVariable Integer doctor_id, Model model) {
		model.addAttribute("doctor", this.doctorService.findOneById(doctor_id));
		model.addAttribute("departments", this.departmentRepository.findAll());
		model.addAttribute("activePage", "doctors");
		return "doctors/edit";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Doctor doctor) {
		this.doctorService.save(doctor);
		return "redirect:/doctors/view/" + doctor.getDoctor_id();
	}
	
	@RequestMapping(value = "/delete/{doctor_id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer doctor_id) {
		this.doctorService.delete(doctor_id);
		return "redirect:/doctors";
	}
}
