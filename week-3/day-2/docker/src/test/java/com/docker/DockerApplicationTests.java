package com.docker;

import com.docker.controller.AppController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DockerApplicationTests {

	@Autowired
	private AppController controller;

	@DisplayName("Context : Spring Application Context Loaded")
	@Test
	void contextLoads() {
		Assertions.assertNotNull(controller);
	}
}
