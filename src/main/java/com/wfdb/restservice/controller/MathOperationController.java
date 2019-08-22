package com.wfdb.restservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfdb.restservice.response.MathOperationResponse;

@RestController
public class MathOperationController {

	private AtomicLong idCounter = new AtomicLong();

	@RequestMapping(path = "/add")
	public MathOperationResponse add(@RequestParam(value = "first") float first,
			@RequestParam(value = "second") float second) {
		return new MathOperationResponse(idCounter.incrementAndGet(), first, second, first + second);
	}

	@RequestMapping(path = "/subtract")
	public MathOperationResponse subtract(@RequestParam(value = "first") float first,
			@RequestParam(value = "second") float second) {
		return new MathOperationResponse(idCounter.incrementAndGet(), first, second, first - second);
	}

	@RequestMapping(path = "/multiply")
	public MathOperationResponse multiply(@RequestParam(value = "first") float first,
			@RequestParam(value = "second") float second) {
		return new MathOperationResponse(idCounter.incrementAndGet(), first, second, first * second);
	}

	@RequestMapping(path = "/divide")
	public MathOperationResponse divide(@RequestParam(value = "first") float first,
			@RequestParam(value = "second") float second) {
		return new MathOperationResponse(idCounter.incrementAndGet(), first, second, first / second);
	}

}
