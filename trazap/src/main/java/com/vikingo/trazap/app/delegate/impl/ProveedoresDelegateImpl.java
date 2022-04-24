package com.vikingo.trazap.app.delegate.impl;

import com.vikingo.trazap.app.delegate.ProveedoresDelegate;
import com.vikingo.trazap.app.repository.model.Proveedores;
import com.vikingo.trazap.app.service.ProveedoresService;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("proveedoresDelegate")
public class ProveedoresDelegateImpl implements ProveedoresDelegate {

    @Autowired
    private ProveedoresService proveedoresService;

    @Override
    public ResponseServiceObject findAll() {
        return proveedoresService.findAll();
    }

    @Override
    public ResponseServiceObject save(Proveedores proveedores) {
        return proveedoresService.save(proveedores);
    }


}
