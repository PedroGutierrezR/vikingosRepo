package cl.desafiolatam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import cl.desafiolatam.model.Contacto;
import cl.desafiolatam.service.ContactService;

@Service("ContactService")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("listaContactos")
	private List<Contacto> listaContactos;

	public ContactServiceImpl(List<Contacto> listaContactos) {
		super();
		this.listaContactos = listaContactos;
	}
	@Override
	public String getContactList(ModelMap model, @ModelAttribute("contacto") Contacto contacto) {
		if (listaContactos.size() > 0) {
			model.addAttribute("listaContactos", listaContactos);
		}
		return "listaContactos";
	}
	@Override
	public String addContact(Contacto contacto) {

		if (listaContactos.size() > 0) {
			contacto.setIdContacto(listaContactos.get(listaContactos.size() - 1).getIdContacto() + 1);
			listaContactos.add(contacto);
		} else {
			contacto.setIdContacto(1);
			listaContactos.add(contacto);
		}
		return "listaContactos";
	}
	@Override
	public String deleteContact(Contacto contacto) {

		for (int i = 0; i < listaContactos.size(); i++) {
			if (listaContactos.get(i).getIdContacto() == contacto.getIdContacto()) {
				listaContactos.remove(i);

			}
		}

		return "listaContactos";
	}	
}