/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.elhg.pockemon;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;



import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import pockemon.soap_webservice.from_api_rest.GetBaseExperiencePockemonRequest;
import pockemon.soap_webservice.from_api_rest.GetHabilidadesPockemonRequest;
import pockemon.soap_webservice.from_api_rest.GetHeldItemsPockemonRequest;
import pockemon.soap_webservice.from_api_rest.GetIdPockemonRequest;
import pockemon.soap_webservice.from_api_rest.GetLocalAreaEncountersPockemonRequest;
import pockemon.soap_webservice.from_api_rest.GetNamePockemonRequest;
import pockemon.soap_webservice.from_api_rest.GetPockemonRequest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PockemonWebServiceTests {

	@LocalServerPort
	private int port = 0;
	
	private  static final String LOCALHOST= "http://localhost:";

	@Test
	public void testSendAndReceive_Pockemon() throws Exception {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan(ClassUtils.getPackageName(GetPockemonRequest.class));
		marshaller.afterPropertiesSet();

		WebServiceTemplate ws = new WebServiceTemplate(marshaller);
		GetPockemonRequest request = new GetPockemonRequest();
		request.setName("ditto");

		assertNotNull(ws.marshalSendAndReceive(LOCALHOST+ port + "/ws", request));
    }

	@Test
	public void testSendAndReceive_Id() throws Exception {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan(ClassUtils.getPackageName(GetIdPockemonRequest.class));
		marshaller.afterPropertiesSet();

		WebServiceTemplate ws = new WebServiceTemplate(marshaller);
		GetIdPockemonRequest request = new GetIdPockemonRequest();
		request.setName("pikachu");

		assertNotNull(ws.marshalSendAndReceive(LOCALHOST+ port + "/ws", request));
    }

	@Test
	public void testSendAndReceive_Name() throws Exception {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan(ClassUtils.getPackageName(GetNamePockemonRequest.class));
		marshaller.afterPropertiesSet();

		WebServiceTemplate ws = new WebServiceTemplate(marshaller);
		GetNamePockemonRequest request = new GetNamePockemonRequest();
		request.setName("ditto");

		assertNotNull(ws.marshalSendAndReceive(LOCALHOST+ port + "/ws", request));
    }

	@Test
	public void testSendAndReceive_LocalAreaEncounters() throws Exception {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan(ClassUtils.getPackageName(GetLocalAreaEncountersPockemonRequest.class));
		marshaller.afterPropertiesSet();

		WebServiceTemplate ws = new WebServiceTemplate(marshaller);
		GetLocalAreaEncountersPockemonRequest request = new GetLocalAreaEncountersPockemonRequest();
		request.setName("pikachu");

		assertNotNull(ws.marshalSendAndReceive(LOCALHOST+ port + "/ws", request));
    }
	
	@Test
	public void testSendAndReceive_BaseExperience() throws Exception {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan(ClassUtils.getPackageName(GetBaseExperiencePockemonRequest.class));
		marshaller.afterPropertiesSet();

		WebServiceTemplate ws = new WebServiceTemplate(marshaller);
		GetBaseExperiencePockemonRequest request = new GetBaseExperiencePockemonRequest();
		request.setName("ditto");

		assertNotNull(ws.marshalSendAndReceive(LOCALHOST+ port + "/ws", request));
    }

	@Test
	public void testSendAndReceive_Habilidades() throws Exception {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan(ClassUtils.getPackageName(GetHabilidadesPockemonRequest.class));
		marshaller.afterPropertiesSet();

		WebServiceTemplate ws = new WebServiceTemplate(marshaller);
		GetHabilidadesPockemonRequest request = new GetHabilidadesPockemonRequest();
		request.setName("pikachu");

		assertNotNull(ws.marshalSendAndReceive(LOCALHOST+ port + "/ws", request));
    }
	
	@Test
	public void testSendAndReceive_HeldItems() throws Exception {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan(ClassUtils.getPackageName(GetHeldItemsPockemonRequest.class));
		marshaller.afterPropertiesSet();

		WebServiceTemplate ws = new WebServiceTemplate(marshaller);
		GetHeldItemsPockemonRequest request = new GetHeldItemsPockemonRequest();
		request.setName("ditto");

		assertNotNull(ws.marshalSendAndReceive(LOCALHOST+ port + "/ws", request));
    }
	
	
}
