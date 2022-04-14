package com.pedrogutierrez.contactmanager;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pedrogutierrez.contactmanager.dto.ContactDto;
import com.pedrogutierrez.contactmanager.model.Contacto;
import com.pedrogutierrez.contactmanager.service.ContactService;

@SpringBootTest
class ContactManagerApplicationTests {

	@Autowired
	private ContactService contactService;
	@Autowired
	private ContactDto contactDto;
	@Autowired
	private Contacto contacto;
	
	@Test
	void contextLoads() {
	}

	@Test
	void getListContactTest() {
		assertThat(contactService.getContactList()).isEqualTo(contactDto);
	}
	
	@Test
	void addContactTest() {
		contacto.setIdContacto(1);
		contacto.setNombre("Pedro");
		contacto.setApellidoPaterno("Gutierrez");
		contacto.setApellidoMaterno("Rojas");
		contacto.setDireccion("Antonio Herreros");
		contacto.setTelefono(993939393);
		assertThat(contactService.addContact(contacto)).isIn(1);
	}
	
	@Test
	void deleteContactTest() {
		contacto.setIdContacto(2);
		contactDto.getListaContactos().add(contacto);
		assertThat(contactService.deleteContact(contacto)).isIn(1);
	}
	
}
