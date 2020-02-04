package com.steve.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MoviesController {

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${movies}")
	private String movies;

	@GetMapping("/movies")
	public List<Object> getNonAdultMovies() {
		@SuppressWarnings("unchecked")
		Map<String, Object> nonAdultMovies = restTemplate.getForObject(this.movies, Map.class);
		List<Object> returndata = new ArrayList<Object>();
		Object object = nonAdultMovies.get("results");
		List<Object> list = (List<Object>) object;
		for (Object mov : list) {
			Map<String, Object> data = (Map<String, Object>) mov;
			if ( data.get("adult").equals(false)) {
				returndata.add(data.get("title"));
			}
		}
		return returndata;

	}

}
