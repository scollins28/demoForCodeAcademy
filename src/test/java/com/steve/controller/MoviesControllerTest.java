package com.steve.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MoviesControllerTest {

	@Autowired
	private MoviesController moviesController = new MoviesController();
	
	@Test
	void test() {
		assertThat(moviesController).isNotNull();
		assertThat(moviesController.getNonAdultMovies()).isNotNull();
	}

	@Test
	void testReturnsCorrectJSON() {
		List<Object> nonAdultMovies = moviesController.getNonAdultMovies();
		System.err.println(nonAdultMovies);
	}
}
