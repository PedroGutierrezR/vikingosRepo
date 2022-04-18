package cl.desafiolatam.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import cl.desafiolatam.model.Contacto;

public interface ContactService {

	List<Contacto> listaContactos();
	 
	void addContact(Contacto contacto);

	void deleteContact(int id);

	void getContactList(Contacto contacto);

}
