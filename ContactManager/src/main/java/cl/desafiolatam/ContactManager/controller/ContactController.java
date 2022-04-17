package cl.desafiolatam.ContactManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.desafiolatam.ContactManager.model.Contacto;

@Controller
@RequestMapping(value = "/contactManager")
public class ContactController {
	

	@Autowired
	@Qualifier("listaContactos")
	private List<Contacto> listaContactos;
	
	@RequestMapping(value = "/getContactList", method = {RequestMethod.GET, RequestMethod.POST})
	public String getContactList(ModelMap model, @ModelAttribute("contacto") Contacto contacto) {
		if(listaContactos.size() > 0) {
			model.addAttribute("listaContactos", listaContactos);
		}	
		return "contactManager";
	}
	
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(ModelMap model, @ModelAttribute("contacto") Contacto contacto) {
		
		if(listaContactos.size() > 0) {
			contacto.setIdContacto(listaContactos.get(listaContactos.size() - 1).getIdContacto() + 1);
			listaContactos.add(contacto);
		} else {
			contacto.setIdContacto(1);
			listaContactos.add(contacto);
		}
		return "forward:/contactManager/getContactList";
	}
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.POST)
	public String deleteContact(ModelMap model, @ModelAttribute("contacto") Contacto contacto) {
		
		for(int i = 0; i < listaContactos.size(); i++) {
			if(listaContactos.get(i).getIdContacto() == contacto.getIdContacto()) {
				listaContactos.remove(i);
				
			}
		}
		
		return "forward:/contactManager/getContactList";
	}
	

}
