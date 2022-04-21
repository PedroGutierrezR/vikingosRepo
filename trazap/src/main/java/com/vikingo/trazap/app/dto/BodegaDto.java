package com.vikingo.trazap.app.dto;

import java.util.List;

import com.vikingo.trazap.app.repository.model.Bodega;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BodegaDto extends GenericDto {

	List<Bodega> listaBodegas;
	
	public BodegaDto(String mensaje, String codigo, List<Bodega> listaBodegas) {
		super(mensaje, codigo);
		this.listaBodegas = listaBodegas;
	}
	
}
