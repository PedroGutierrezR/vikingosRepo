package com.vikingo.trazap.app.ui.api.rest;

import com.vikingo.trazap.app.delegate.ProveedoresDelegate;
import com.vikingo.trazap.app.repository.model.Proveedores;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresDelegate proveedoresDelegate;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseServiceObject> getProveedores() {
        return new ResponseEntity<ResponseServiceObject>(proveedoresDelegate.findAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseServiceObject> createProveedores(@RequestBody Proveedores proveedores) {
        return new ResponseEntity<ResponseServiceObject>(proveedoresDelegate.save(proveedores), HttpStatus.OK);
    }

}