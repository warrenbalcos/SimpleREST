package com.wfdb.restservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfdb.restservice.response.EchoResponse;

@RestController
public class EchoController {

	private AtomicLong counter = new AtomicLong();

	@RequestMapping(path = "/echo")
	public EchoResponse echo(@RequestParam(value = "data") String data) {
		return new EchoResponse(counter.getAndIncrement(), data);
	}

}
