package com.vikingo.trazap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.vikingo.trazap.app.repository.model.Bodega;
import com.vikingo.trazap.app.service.BodegaService;
import com.vikingo.trazap.app.service.response.ResponseServiceMessage;
import com.vikingo.trazap.app.service.response.ResponseServiceMessageType;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@SpringBootTest
public class BodegaServiceTests {

	//Mockito o Mocks en Spring Boot con JUnit Jupiter
	
	private static BodegaService bodegaService;
	private static ResponseServiceObject responseServiceObject;
	private static ResponseServiceMessage responseServiceMessage;
	private static Bodega bodegaMock1;
	private static List<Bodega> bodegas;
	
	@BeforeAll
	public static void setUp() {
		bodegaService = mock(BodegaService.class);
		responseServiceObject = new ResponseServiceObject();
		responseServiceMessage = new ResponseServiceMessage(); 
		bodegaMock1 = new Bodega();
		bodegaMock1.setIdBodega(1);
		bodegaMock1.setDescripcion("Bodega uno");
		bodegas = new ArrayList<Bodega>();
		bodegas.add(bodegaMock1);
	}
	
	private void generatemockResponse(Object body, String code, ResponseServiceMessageType type) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(body);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode(code);// 201 = create ok
		responseServiceMessage.setType(type);
		responseServiceMessage.setMessage("Servicio ha finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
	}
	
	@Test
	public void saveBodega() {
		
		generatemockResponse(bodegaMock1, "201", ResponseServiceMessageType.OK);
		
		Bodega bodega = new Bodega();
		bodega.setDescripcion("Bodega uno");
		
		when(bodegaService.save(bodega)).thenReturn(responseServiceObject);
		
		ResponseServiceObject respuesta = bodegaService.save(bodega);
		
		assertThat(((Bodega)respuesta.getBody()).getIdBodega()).isEqualTo(1);
		//assertThat(respuesta).isEqualTo(responseServiceObject);
	}
	
	@Test
	public void findAllBodega() {
		
		generatemockResponse(bodegas, "200", ResponseServiceMessageType.OK);
		
		when(bodegaService.findAll()).thenReturn(responseServiceObject);
		
		ResponseServiceObject respuesta = bodegaService.findAll();
		
		assertThat(((ArrayList<Bodega>)respuesta.getBody()).size()).isEqualTo(1);
		assertThat(((ArrayList<Bodega>)respuesta.getBody())).isNotNull();
	}
	
}
