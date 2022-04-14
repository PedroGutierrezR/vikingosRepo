package com.pedrogutierrez.contactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.pedrogutierrez.contactmanager.model.Contacto;
import com.pedrogutierrez.contactmanager.service.ContactService;

@Controller
@RequestMapping(value = "/contactManager")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "/getContactList", method = {RequestMethod.GET, RequestMethod.POST})
	public String getContactList(ModelMap model, @ModelAttribute("contacto") Contacto contacto) {
		model.addAttribute("listaContactos", contactService.getContactList().getListaContactos());
		return "contactManager";
	}
	
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(ModelMap model, @ModelAttribute("contacto") Contacto contacto) {
		contactService.addContact(contacto);
		return "forward:/contactManager/getContactList";
	}
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.POST)
	public String deleteContact(ModelMap model, @ModelAttribute("contacto") Contacto contacto) {
		contactService.deleteContact(contacto);
		return "forward:/contactManager/getContactList";
	}
	
}
