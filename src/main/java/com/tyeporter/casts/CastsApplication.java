package com.tyeporter.casts;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tyeporter.casts.model.Genres;
import com.tyeporter.casts.model.GenresResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SpringBootApplication
@EnableCaching
public class CastsApplication {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		Resource resource = new ClassPathResource("genres.json");

		try {
			GenresResponse genres = mapper.readValue(resource.getInputStream(), GenresResponse.class);
			Genres.setGenres(genres.getGenres());
		} catch (IOException e) {
			e.printStackTrace();
		}

		SpringApplication.run(CastsApplication.class, args);
	}

}
