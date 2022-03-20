package com.elhg.pockemon.webservice;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.elhg.pockemon.PokemonWebServiceApplication;
import com.elhg.pockemon.model.rest.Habilidades;
import com.elhg.pockemon.model.rest.HeldItems;
import com.elhg.pockemon.model.rest.Pockemon;
import com.elhg.pockemon.model.rest.VersionDetails;

@Component
public class PockemonRepository {
	private static final Logger log = LoggerFactory.getLogger(PokemonWebServiceApplication.class);

	public pockemon.soap_webservice.from_api_rest.Pockemon findPockemon(String name) {
		RestTemplate restTemplate = new RestTemplate();
		Pockemon pockemon = restTemplate.getForObject(
				"https://pokeapi.co/api/v2/pokemon/"+name, Pockemon.class);
		
		log.info("id : {}", pockemon.getId());
		log.info("name : {}", pockemon.getName());
		log.info("location_area_encounters : {}", pockemon.getLocation_area_encounters());
		log.info("base_experience : {}", pockemon.getBase_experience());
		
		pockemon.soap_webservice.from_api_rest.Pockemon pocketmonster = new pockemon.soap_webservice.from_api_rest.Pockemon();
		pocketmonster.setId(pockemon.getId());
		pocketmonster.setName(pockemon.getName());
		pocketmonster.setLocationAreaEncounters(pockemon.getLocation_area_encounters());
		pocketmonster.setBaseExperience(pockemon.getBase_experience());
						
		return pocketmonster;

	}


	public List<pockemon.soap_webservice.from_api_rest.Habilidades> findPockemonHabilidades(String name) {
		RestTemplate restTemplate = new RestTemplate();
		Pockemon pockemon = restTemplate.getForObject(
				"https://pokeapi.co/api/v2/pokemon/"+name, Pockemon.class);
		List<pockemon.soap_webservice.from_api_rest.Habilidades> listHabilidades = 
				new ArrayList<pockemon.soap_webservice.from_api_rest.Habilidades>();
		
		log.info("Total Abilities : {}",pockemon.getAbilities().length);
		
		for(Habilidades habilidad : pockemon.getAbilities()) {
			pockemon.soap_webservice.from_api_rest.Habilidades hab = new pockemon.soap_webservice.from_api_rest.Habilidades();
			hab.setIsHidden(habilidad.is_hidden());
			hab.setSlot(habilidad.getSlot());	
			
			pockemon.soap_webservice.from_api_rest.GenericNameUrl gen = new pockemon.soap_webservice.from_api_rest.GenericNameUrl();
			gen.setName(habilidad.getAbility().getName());
			gen.setUrl(habilidad.getAbility().getUrl());
			hab.setAbility(gen);
			
			listHabilidades.add(hab);
		}
				
		return listHabilidades;

	}


	public List<pockemon.soap_webservice.from_api_rest.HeldItems> findPockemonHeldItems(String name) {
		RestTemplate restTemplate = new RestTemplate();
		Pockemon pockemon = restTemplate.getForObject(
				"https://pokeapi.co/api/v2/pokemon/"+name, Pockemon.class);
		List<pockemon.soap_webservice.from_api_rest.HeldItems> listHeldItem = 
				new ArrayList<pockemon.soap_webservice.from_api_rest.HeldItems>();
		
		log.info("Total HeldItem : {}",pockemon.getHeld_items().length);
		
		for(HeldItems helditem : pockemon.getHeld_items()) {
			pockemon.soap_webservice.from_api_rest.HeldItems hel = new pockemon.soap_webservice.from_api_rest.HeldItems();
			
			pockemon.soap_webservice.from_api_rest.GenericNameUrl gen = new pockemon.soap_webservice.from_api_rest.GenericNameUrl();
			gen.setName(helditem.getItem().getName());
			gen.setUrl(helditem.getItem().getUrl());
			hel.setItem(gen);
			
			
			for(VersionDetails versDet : helditem.getVersion_details()) {
				pockemon.soap_webservice.from_api_rest.VersionDetails version = new pockemon.soap_webservice.from_api_rest.VersionDetails();
				version.setRarity(versDet.getRarity());

				pockemon.soap_webservice.from_api_rest.GenericNameUrl generic = new pockemon.soap_webservice.from_api_rest.GenericNameUrl();

				generic.setName(versDet.getVersion().getName());
				generic.setUrl(versDet.getVersion().getUrl());
				
				version.setVersion(generic);

				hel.getVersionDetails().add(version);	
			}
			
			listHeldItem.add(hel);
		}
				
		return listHeldItem;

	}

}
