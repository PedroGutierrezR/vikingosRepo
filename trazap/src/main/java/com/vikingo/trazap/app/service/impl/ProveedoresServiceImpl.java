package com.vikingo.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.vikingo.trazap.app.repository.ProveedoresRepository;
import com.vikingo.trazap.app.repository.model.Proveedores;
import com.vikingo.trazap.app.service.ProveedoresService;
import com.vikingo.trazap.app.service.response.ResponseServiceMessage;
import com.vikingo.trazap.app.service.response.ResponseServiceMessageType;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("proveedoresService")
public class ProveedoresServiceImpl implements ProveedoresService {

    @Autowired
    private ProveedoresRepository proveedoresRepository;
    @Autowired
    private ResponseServiceObject responseServiceObject;
    @Autowired
    private ResponseServiceMessage responseServiceMessage;

    @Override
    public ResponseServiceObject findAll() {
        List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
        List<Proveedores> proveedoresList = new ArrayList<Proveedores>();

        Iterable<Proveedores> iterableProveedores = proveedoresRepository.findAll();

        iterableProveedores.forEach(proveedoresList::add);

        responseServiceMessage.setTimestamp(new Date());
        responseServiceMessage.setCode("200");
        responseServiceMessage.setType(ResponseServiceMessageType.OK);
        responseServiceMessage.setMessage("Servicio ha finalizado correctamente");

        messageList.add(responseServiceMessage);

        responseServiceObject.setBody(proveedoresList);
        responseServiceObject.setMessageList(messageList);

        return responseServiceObject;

    }

    @Override
    public ResponseServiceObject save(Proveedores proveedores) {
        List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();

        responseServiceObject.setBody(proveedoresRepository.save(proveedores));

        responseServiceMessage.setTimestamp(new Date());
        responseServiceMessage.setCode("201");// 201 = create ok
        responseServiceMessage.setType(ResponseServiceMessageType.OK);
        responseServiceMessage.setMessage("Servicio ha finalizado correctamente");

        messageList.add(responseServiceMessage);

        responseServiceObject.setMessageList(messageList);

        return responseServiceObject;
    }
}