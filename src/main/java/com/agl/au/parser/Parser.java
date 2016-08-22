package com.agl.au.parser;

import java.util.List;

import com.agl.au.bean.Owner;

/**
 * @author Gini 
 * 
 * This Interface will parse the JSON and return the list of owners
 */
public interface Parser {

	/**
	 * This method will parse the JSON consumed from the web service.
	 * 
	 * @param String Builder
	 * @return List<Owner>
	 */
	List<Owner> parseJson(String sb);
}
