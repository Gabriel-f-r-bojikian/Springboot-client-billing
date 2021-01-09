package com.bojukafinancial.controller;

public class ClientNotFoundException extends RuntimeException {
	
	ClientNotFoundException(Long id) {
		super("Client " + id.toString() + " not found");
	}

}
