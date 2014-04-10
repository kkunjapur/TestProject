package kk.webtestspring.domain.controllers;

import kk.webtestspring.domain.beans.Patient;
import kk.webtestspring.domain.services.NewPatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/newPatient")
public class PatientController {
	
	@Autowired
	NewPatientService newPatientService;
	
	@RequestMapping(value="/createNewPatient", method=RequestMethod.GET)
	public ModelAndView newPatientForm(){
		ModelAndView model = new ModelAndView("newPatient","command", new Patient());
		return model;		
	}
	
	@RequestMapping(value="/displayNewPatient", method=RequestMethod.POST)	
	public ModelAndView displayNewPatientDetails(@ModelAttribute Patient patient){
		
		newPatientService.addPatient(patient);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayNewPatient");
		modelAndView.addObject("patient", patient);
		return modelAndView;
	}

	/**
	 * Returns a list of patients to be displayed
	 * @return modelAndView - having a list of 'Patient' objects
	 */
	@RequestMapping(value="/displayPatients", method=RequestMethod.GET)
	public ModelAndView displayAllPatients(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayPatients");
		return modelAndView;
	}
}
