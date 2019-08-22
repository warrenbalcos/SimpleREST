package com.wfdb.restservice.response;

public class MathOperationResponse {

	private long id;
	private float first;
	private float second;
	private float result;

	public MathOperationResponse(long id, float first, float second, float result) {
		super();
		this.id = id;
		this.first = first;
		this.second = second;
		this.result = result;
	}

	public long getId() {
		return id;
	}

	public float getFirst() {
		return first;
	}

	public float getSecond() {
		return second;
	}

	public float getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "MathOperationResponse [id=" + id + ", first=" + first + ", second=" + second + ", result=" + result
				+ "]";
	}
}
