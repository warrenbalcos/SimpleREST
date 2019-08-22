package com.wfdb.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.wfdb.restservice.controller.EchoController;
import com.wfdb.restservice.controller.MathOperationController;
import com.wfdb.restservice.response.EchoResponse;
import com.wfdb.restservice.response.MathOperationResponse;

@SpringBootTest
class SimpleRestApplicationTests {

	@Test
	void echoControllerTest() {
		EchoController controller = new EchoController();
		EchoResponse response = controller.echo("hello");
		assertEquals("hello", response.getContent());
	}

	@Test
	void addApiTest() {
		MathOperationController controller = new MathOperationController();
		MathOperationResponse response = controller.add(2, 2);
		assertEquals(4, response.getResult());
	}

	@Test
	void subtractApiTest() {
		MathOperationController controller = new MathOperationController();
		MathOperationResponse response = controller.subtract(2, 1);
		assertEquals(1, response.getResult());
	}

	@Test
	void multiplyApiTest() {
		MathOperationController controller = new MathOperationController();
		MathOperationResponse response = controller.multiply(3, 3);
		assertEquals(9, response.getResult());
	}

	@Test
	void divideApiTest() {
		MathOperationController controller = new MathOperationController();
		MathOperationResponse response = controller.divide(20, 4);
		assertEquals(5, response.getResult());
	}

}
