package com.agl.au.main;

import com.agl.au.client.ApacheHttpClient;
import com.agl.au.controller.Controller;

/**
 * @author Gini
 * Main Class for the program contains the main method
 * 
 */
public class JsonObjectSorter {

	public static void main(String[] args) {
		ApacheHttpClient httpClient=null;
		Controller ctrllerObj=null;
		
		httpClient=new ApacheHttpClient();
		ctrllerObj=new Controller();
		
		String strJson = httpClient.getJson();
		if(strJson != null && !strJson.isEmpty()){
		ctrllerObj.groupAndSortList(strJson);
		}
	}

}
