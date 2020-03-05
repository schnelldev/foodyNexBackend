package com.gm.base.vo;

public class ErrorVO {

	String errorCode;
	String errorMessage;

	public ErrorVO(String errorMessage, String errorCode) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
}
