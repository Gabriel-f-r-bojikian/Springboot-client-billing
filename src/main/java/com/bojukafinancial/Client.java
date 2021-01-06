package com.bojukafinancial;

import lombok.Getter;
import lombok.Setter;

public class Client {
	@Getter @Setter private String clientId; //Must be unique
	@Getter @Setter private String name;
	
	Client(String clientId, String name){
		this.clientId = clientId;
		this.name = name;
	}
	

}
