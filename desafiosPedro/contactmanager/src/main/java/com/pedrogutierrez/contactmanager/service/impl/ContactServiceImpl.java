package com.pedrogutierrez.contactmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pedrogutierrez.contactmanager.dto.ContactDto;
import com.pedrogutierrez.contactmanager.model.Contacto;
import com.pedrogutierrez.contactmanager.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDto contactDto;

	@Override
	public ContactDto getContactList() {
		return contactDto;
	}

	@Override
	public int addContact(Contacto contacto) {

		if (contactDto.getListaContactos().size() > 0) {
			contacto.setIdContacto(
					contactDto.getListaContactos().get(contactDto.getListaContactos().size() - 1).getIdContacto() + 1);
			contactDto.getListaContactos().add(contacto);
			return 1;
		} else if(contactDto.getListaContactos().size() == 0){
			contacto.setIdContacto(1);
			contactDto.getListaContactos().add(contacto);
			return 1;
		}

		return 0;
		
	}

	@Override
	public int deleteContact(Contacto contacto) {

		for (int i = 0; i < contactDto.getListaContactos().size(); i++) {
			
			if (contactDto.getListaContactos().get(i).getIdContacto() == contacto.getIdContacto()) {
				contactDto.getListaContactos().remove(i);
				return 1;
			}
		}
		return 0;
	}

}
