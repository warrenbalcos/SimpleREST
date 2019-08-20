package com.wfdb.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.wfdb.restservice.controller.EchoController;
import com.wfdb.restservice.response.EchoResponse;

@SpringBootTest
class SimpleRestApplicationTests {

	@Test
	void echoControllerTest() {
		EchoController controller = new EchoController();
		EchoResponse response = controller.echo("hello");
		assertEquals("hello", response.getContent());
	}

}
