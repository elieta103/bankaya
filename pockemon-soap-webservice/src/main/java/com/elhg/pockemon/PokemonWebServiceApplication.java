package com.elhg.pockemon;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@SpringBootApplication
@EntityScan({"com.elhg.pockemon.model.entity"})
public class PokemonWebServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(PokemonWebServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PokemonWebServiceApplication.class, args);
	}

	/*
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Pockemon pockemon = restTemplate.getForObject(
					"https://pokeapi.co/api/v2/pokemon/ditto", Pockemon.class);
			
			log.info("id : {}", pockemon.getId());
			log.info("name : {}", pockemon.getName());
			log.info("location_area_encounters : {}", pockemon.getLocation_area_encounters());
			log.info("base_experience : {}", pockemon.getBase_experience());
			
			log.info("Total Abilities : {}",pockemon.getAbilities().length);
			Arrays.asList(pockemon.getAbilities()).stream().forEach(item ->log.info(item.toString()));
			log.info("Total Held_items : {}",pockemon.getHeld_items().length);
			Arrays.asList(pockemon.getHeld_items()).stream().forEach(item ->log.info(item.toString()));
			
		};
	}
   */
}





