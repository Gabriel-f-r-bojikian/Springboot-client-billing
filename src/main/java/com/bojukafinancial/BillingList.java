package com.bojukafinancial;

import java.util.HashMap;

public class BillingList {
	//Implement a sort of client:list of bills with a hashmap to keep track of clients and bills. 
	//This is like a SQL relationship table
	
	private HashMap<String, Client> clientMap; 
	private HashMap<String, Bill> billMap;
	private HashMap<String, String> clientBillMap;
	
	BillingList (){
		this.clientMap = new HashMap<String, Client>();
		this.billMap = new HashMap<String, Bill>();
		this.clientBillMap = new HashMap<String, String>();
	}
}
