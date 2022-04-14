package com.pedrogutierrez.contactmanager.service;

import com.pedrogutierrez.contactmanager.dto.ContactDto;
import com.pedrogutierrez.contactmanager.model.Contacto;

public interface ContactService {

	public ContactDto getContactList();
	public int addContact(Contacto contacto);
	public int deleteContact (Contacto contacto);
	
}
