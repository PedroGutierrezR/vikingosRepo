package com.vikingo.trazap.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.vikingo.trazap.app.repository.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

}
