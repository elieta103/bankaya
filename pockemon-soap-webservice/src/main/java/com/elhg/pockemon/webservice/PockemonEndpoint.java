package com.elhg.pockemon.webservice;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.elhg.pockemon.model.entity.PeticionEntity;
import com.elhg.pockemon.repository.PeticionesRepository;

import pockemon.soap_webservice.from_api_rest.GetBaseExperiencePockemonRequest;
import pockemon.soap_webservice.from_api_rest.GetBaseExperiencePockemonResponse;
import pockemon.soap_webservice.from_api_rest.GetHabilidadesPockemonRequest;
import pockemon.soap_webservice.from_api_rest.GetHabilidadesPockemonResponse;
import pockemon.soap_webservice.from_api_rest.GetHeldItemsPockemonRequest;
import pockemon.soap_webservice.from_api_rest.GetHeldItemsPockemonResponse;
import pockemon.soap_webservice.from_api_rest.GetIdPockemonRequest;
import pockemon.soap_webservice.from_api_rest.GetIdPockemonResponse;
import pockemon.soap_webservice.from_api_rest.GetLocalAreaEncountersPockemonRequest;
import pockemon.soap_webservice.from_api_rest.GetLocalAreaEncountersPockemonResponse;
import pockemon.soap_webservice.from_api_rest.GetNamePockemonRequest;
import pockemon.soap_webservice.from_api_rest.GetNamePockemonResponse;
import pockemon.soap_webservice.from_api_rest.GetPockemonRequest;
import pockemon.soap_webservice.from_api_rest.GetPockemonResponse;


@Endpoint
public class PockemonEndpoint {
	private static final String NAMESPACE_URI = "http://pockemon/soap-webservice/from-api-rest";

	@Autowired
	private PockemonRepository pockemonRepository;
	
	@Autowired
	private PeticionesRepository peticionesRepository;
	
	@Autowired
	private HttpServletRequest httpServletRequest;


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPockemonRequest")
	@ResponsePayload
	public GetPockemonResponse getPockemon(@RequestPayload GetPockemonRequest request) {
		GetPockemonResponse response = new GetPockemonResponse();
		response.setPockemon(pockemonRepository.findPockemon(request.getName()));
		savePeticion("getPockemon");
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdPockemonRequest")
	@ResponsePayload
	public GetIdPockemonResponse getIdPockemon(@RequestPayload GetIdPockemonRequest request) {
		GetIdPockemonResponse response = new GetIdPockemonResponse();
		response.setId(pockemonRepository.findPockemon(request.getName()).getId());
		savePeticion("getIdPockemon");
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNamePockemonRequest")
	@ResponsePayload
	public GetNamePockemonResponse getNamePockemon(@RequestPayload GetNamePockemonRequest request) {
		GetNamePockemonResponse response = new GetNamePockemonResponse();
		response.setName(pockemonRepository.findPockemon(request.getName()).getName());
		savePeticion("getNamePockemon");
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperiencePockemonRequest")
	@ResponsePayload
	public GetBaseExperiencePockemonResponse getBaseExperiencePockemon(@RequestPayload GetBaseExperiencePockemonRequest request) {
		GetBaseExperiencePockemonResponse response = new GetBaseExperiencePockemonResponse();
		response.setBaseExperience(pockemonRepository.findPockemon(request.getName()).getBaseExperience());
		savePeticion("getBaseExperiencePockemon");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocalAreaEncountersPockemonRequest")
	@ResponsePayload
	public GetLocalAreaEncountersPockemonResponse getLocalAreaEncountersPockemon(@RequestPayload GetLocalAreaEncountersPockemonRequest request) {
		GetLocalAreaEncountersPockemonResponse response = new GetLocalAreaEncountersPockemonResponse();
		response.setLocationAreaEncounters(pockemonRepository.findPockemon(request.getName()).getLocationAreaEncounters());
		savePeticion("getLocalAreaEncountersPockemon");
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHabilidadesPockemonRequest")
	@ResponsePayload
	public GetHabilidadesPockemonResponse getHabilidadesPockemon(@RequestPayload GetHabilidadesPockemonRequest request) {
		GetHabilidadesPockemonResponse response = new GetHabilidadesPockemonResponse();
		response.getAbilities().addAll(pockemonRepository.findPockemonHabilidades(request.getName()));
		savePeticion("getHabilidadesPockemon");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsPockemonRequest")
	@ResponsePayload
	public GetHeldItemsPockemonResponse getHeldItemPockemon(@RequestPayload GetHeldItemsPockemonRequest request) {
		GetHeldItemsPockemonResponse response = new GetHeldItemsPockemonResponse();
		response.getHeldItems().addAll(pockemonRepository.findPockemonHeldItems(request.getName()));
		savePeticion("getHeldItemPockemon");
		return response;
	}
	

	private void savePeticion( String nombreMetodo) {
		String ip = this.httpServletRequest.getRemoteAddr();
		PeticionEntity entity = new PeticionEntity();
		entity.setIp(ip);
		entity.setMetodo(nombreMetodo);
		entity.setFecha(new Timestamp(new Date().getTime()));
		peticionesRepository.save(entity);		
	}
	
}
