package com.vikingo.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikingo.trazap.app.exceptions.ServiceException;
import com.vikingo.trazap.app.repository.TrazabilidadRepository;
import com.vikingo.trazap.app.repository.model.Trazabilidad;
import com.vikingo.trazap.app.service.TrazabilidadService;
import com.vikingo.trazap.app.service.request.TrazabilidadRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceMessage;
import com.vikingo.trazap.app.service.response.ResponseServiceMessageType;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;
import com.vikingo.trazap.app.service.response.producto.TrazabilidadResponse;

@Service("trazabilidadService")
public class TrazabilidadServiceImpl implements TrazabilidadService {

	@Autowired
	private TrazabilidadRepository trazabilidadRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;

	@Override
	public ResponseServiceObject findAll() {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();

		List<Trazabilidad> trazabilidades = new ArrayList<Trazabilidad>();
		Iterable<Trazabilidad> iterableTrazabilidades = trazabilidadRepository.findAll();

		iterableTrazabilidades.forEach(trazabilidades::add);

		List<TrazabilidadResponse> response = new ArrayList<TrazabilidadResponse>();

		for (Trazabilidad trazabilidad : trazabilidades) {
			TrazabilidadResponse trazabilidadResponse = new TrazabilidadResponse();
			trazabilidadResponse.setIdTrazabilidad(trazabilidad.getIdTrazabilidad());
			trazabilidadResponse.setFechaInicioPreparacion(trazabilidad.getFechaInicioPreparacion());
			trazabilidadResponse.setFechaFinPreparacion(trazabilidad.getFechaFinPreparacion());
			trazabilidadResponse.setFechaEstimadaEnvio(trazabilidad.getFechaEstimadaEnvio());
			trazabilidadResponse.setFechaEnvio(trazabilidad.getFechaEnvio());
			trazabilidadResponse.setCodigoTrazabilidad(trazabilidad.getCodigoTrazabilidad());
			trazabilidadResponse.setPedidos(trazabilidad.getPedidos());
			trazabilidadResponse.setEstadoTrazabilidad(trazabilidad.getEstadoTrazabilidad());
			response.add(trazabilidadResponse);

		}

		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");

		messageList.add(responseServiceMessage);

		responseServiceObject.setBody(response);
		responseServiceObject.setMessageList(messageList);

		return responseServiceObject;

	}

	@Override
	public ResponseServiceObject save(TrazabilidadRequest trazabilidadRequest) {

		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		Trazabilidad trazabilidad = new Trazabilidad();
		trazabilidad.setCodigoTrazabilidad(trazabilidadRequest.getCodigoTrazabilidad());
		trazabilidad.setFechaEnvio(trazabilidadRequest.getFechaEnvio());
		trazabilidad.setFechaEstimadaEnvio(trazabilidadRequest.getFechaEstimadaEnvio());
		trazabilidad.setFechaFinPreparacion(trazabilidadRequest.getFechaFinPreparacion());
		trazabilidad.setFechaInicioPreparacion(trazabilidadRequest.getFechaInicioPreparacion());

		trazabilidadRepository.save(trazabilidad);

		//Trazabilidad
		List<Trazabilidad> trazabilidades = new ArrayList<Trazabilidad>();
		Iterable<Trazabilidad> iterableTrazabilidades = trazabilidadRepository.findAll();
		iterableTrazabilidades.forEach(trazabilidades::add);
		// set a trazabilidadResponse
		List<TrazabilidadResponse> response = new ArrayList<TrazabilidadResponse>();
		for (Trazabilidad iTrazabilidad : trazabilidades) {
			TrazabilidadResponse trazabilidadResponse = new TrazabilidadResponse();
			trazabilidadResponse.setIdTrazabilidad(iTrazabilidad.getIdTrazabilidad());
			trazabilidadResponse.setFechaInicioPreparacion(iTrazabilidad.getFechaInicioPreparacion());
			trazabilidadResponse.setFechaFinPreparacion(iTrazabilidad.getFechaFinPreparacion());
			trazabilidadResponse.setFechaEstimadaEnvio(iTrazabilidad.getFechaEstimadaEnvio());
			trazabilidadResponse.setFechaEnvio(iTrazabilidad.getFechaEnvio());
			trazabilidadResponse.setCodigoTrazabilidad(iTrazabilidad.getCodigoTrazabilidad());
			response.add(trazabilidadResponse);
		}

		responseServiceObject.setBody(response);

		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");

		messageList.add(responseServiceMessage);

		responseServiceObject.setMessageList(messageList);

		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(int idTrazabilidad, TrazabilidadRequest trazabilidadRequest) {
	
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();

		Trazabilidad trazabilidad = new Trazabilidad();
		trazabilidad.setIdTrazabilidad(idTrazabilidad);
		trazabilidad.setCodigoTrazabilidad(trazabilidadRequest.getCodigoTrazabilidad());
		trazabilidad.setFechaEnvio(trazabilidadRequest.getFechaEnvio());
		trazabilidad.setFechaEstimadaEnvio(trazabilidadRequest.getFechaEstimadaEnvio());
		trazabilidad.setFechaFinPreparacion(trazabilidadRequest.getFechaFinPreparacion());
		trazabilidad.setFechaInicioPreparacion(trazabilidadRequest.getFechaInicioPreparacion());
		
		trazabilidadRepository.save(trazabilidad);

		//Trazabilidad
		List<Trazabilidad> trazabilidades = new ArrayList<Trazabilidad>();
		Iterable<Trazabilidad> iterableTrazabilidades = trazabilidadRepository.findAll();
		iterableTrazabilidades.forEach(trazabilidades::add);
		// set a trazabilidadResponse
		List<TrazabilidadResponse> response = new ArrayList<TrazabilidadResponse>();
		for (Trazabilidad iTrazabilidad : trazabilidades) {
			TrazabilidadResponse trazabilidadResponse = new TrazabilidadResponse();
			trazabilidadResponse.setIdTrazabilidad(iTrazabilidad.getIdTrazabilidad());
			trazabilidadResponse.setFechaInicioPreparacion(iTrazabilidad.getFechaInicioPreparacion());
			trazabilidadResponse.setFechaFinPreparacion(iTrazabilidad.getFechaFinPreparacion());
			trazabilidadResponse.setFechaEstimadaEnvio(iTrazabilidad.getFechaEstimadaEnvio());
			trazabilidadResponse.setFechaEnvio(iTrazabilidad.getFechaEnvio());
			trazabilidadResponse.setCodigoTrazabilidad(iTrazabilidad.getCodigoTrazabilidad());
			response.add(trazabilidadResponse);
		}

		responseServiceObject.setBody(response);

		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");

		messageList.add(responseServiceMessage);

		responseServiceObject.setMessageList(messageList);

		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findByid(Integer idTrazabilidad) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseServiceObject deleteById(TrazabilidadRequest trazabilidadRequest) {
		// TODO Auto-generated method stub
		trazabilidadRepository.deleteById(trazabilidadRequest.getIdTrazabilidad());
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<Trazabilidad> trazabilidades = new ArrayList<Trazabilidad>();

		Iterable<Trazabilidad> iterableTrazabilidades = trazabilidadRepository.findAll();

		iterableTrazabilidades.forEach(trazabilidades::add);

		responseServiceObject.setBody(trazabilidades);

		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("201");// 201 = create ok
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");

		messageList.add(responseServiceMessage);

		responseServiceObject.setMessageList(messageList);

		return responseServiceObject;
	}

}
