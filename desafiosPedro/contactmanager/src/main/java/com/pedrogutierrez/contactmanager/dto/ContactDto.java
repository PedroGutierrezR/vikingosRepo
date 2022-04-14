package com.pedrogutierrez.contactmanager.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.pedrogutierrez.contactmanager.model.Contacto;

@Component
public class ContactDto {

	@Autowired
	@Qualifier("listaContactos")
	private List<Contacto> listaContactos;

	public ContactDto() {
		this.listaContactos = new ArrayList<Contacto>();
	}

	public List<Contacto> getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(List<Contacto> listaContactos) {
		this.listaContactos = listaContactos;
	}

}
