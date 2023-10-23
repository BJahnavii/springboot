package com.infinite.MunicipalVizag.controller;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infinite.MunicipalVizag.service.LoginServiceimpl;
import com.infinite.MunicipalVizag.service.MunicipalServiceimpl;
import com.infnite.MunicipalVizag.model.Municipal;


 

@Controller
public class MunicipalContoller {
	@Autowired
	MunicipalServiceimpl MunicipalServiceImpl;

	@Autowired
	LoginServiceimpl LoginServiceImpl;

	/*@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllComplains";
	}*/

	@RequestMapping(value = "/getAllComplains", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAllComplains(Model m) {
		m.addAttribute("municipal",new Municipal());
		m.addAttribute("listOfComplains", MunicipalServiceimpl.getAllComplains());
		return "complaindetails";
	}

	@RequestMapping(value = "/addComplains", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addComplains(@ModelAttribute("municipal") Municipal municipal) {
		if (municipal.getId() == 0) {
			MunicipalServiceimpl.addMunicipal(municipal);
		} else {
			MunicipalServiceimpl.updateMunicipal(municipal);;
		}
		return "redirect:/getAllComplains";
	}

	@RequestMapping(value = "/updateComplains/{id}")
	public String updateComplains(@PathVariable("id") int id, Model model) {
		model.addAttribute("municipal", this.MunicipalServiceimpl.getMunicipal(id));
		model.addAttribute("listOfComplains", this.MunicipalServiceimpl.getAllComplains());
		return "complaindetails";
	}

	@RequestMapping(value = "/deleteComplains/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteComplains(@PathVariable("id") int id) {
		MunicipalServiceimpl.deleteMunicipal(id);;
		return "redirect:/getAllComplains";
	}


 

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public String goToHomePage(@RequestParam String username) {

		int result = LoginServiceimpl.loginDeatils(username);
		if(result != 0){
			return "redirect:/getAllComplains";
		}
		return null;
	}

}