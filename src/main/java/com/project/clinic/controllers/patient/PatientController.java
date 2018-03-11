package com.project.clinic.controllers.patient;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.clinic.models.Patient;
/*
import com.project.clinic.repositories.DoctorRepository;
import com.project.clinic.repositories.NurseRepository;
import com.project.clinic.repositories.PatientRepository;
*/
import com.project.clinic.services.DoctorService;
import com.project.clinic.services.NurseService;
import com.project.clinic.services.PatientService;

@Controller
@RequestMapping(value = "/patients")
public class PatientController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private NurseService nurseService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@RequestMapping(value = {"", "/"})
	public String list(@RequestParam(name = "value", required = false) String value, Model model) {
		if(value != null) {
			model.addAttribute("activePage", "patients");
			model.addAttribute("value", value);
			model.addAttribute("patients", this.patientService.findOneByName(value));
			return "patients/list";
		}else {
			model.addAttribute("activePage", "patients");
			model.addAttribute("patients", this.patientService.findAll());
			return "patients/list";
		}		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Patient patient, Model model) {
		model.addAttribute("doctors", this.doctorService.findAll());
		model.addAttribute("nurses", this.nurseService.findAll());
		model.addAttribute("activePage", "patients");
		return "patients/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Patient patient, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("activePage", "patients");
			return "patients/add";
		}
		this.patientService.save(patient);
		return "redirect:/patients";
	}
	
	@RequestMapping(value = "/view/{patient_id}")
	public String view(@PathVariable Integer patient_id, Model model) {
		model.addAttribute("patient", this.patientService.findOneById(patient_id));
		model.addAttribute("activePage", "patients");
		return "patients/view";
	}
	
	@RequestMapping(value = "/edit/{patient_id}")
	public String edit(@PathVariable Integer patient_id, Model model) {
		model.addAttribute("patient", this.patientService.findOneById(patient_id));
		model.addAttribute("activePage", "patients");
		return "patients/edit";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Patient patient) {
		this.patientService.save(patient);
		return "redirect:/patients/view/" + patient.getPatient_id();
	}
	
	@RequestMapping(value = "/delete/{patient_id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer patient_id) {
		this.patientService.delete(patient_id);
		return "redirect:/patients";
	}	
}
