package com.agl.au.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import com.agl.au.bean.Owner;
import com.agl.au.bean.Pet;
import com.agl.au.parser.JsonParser;
import com.agl.au.parser.Parser;
import com.agl.au.utils.SortList;

/**
 * @author Gini
 * This class controls the all the functionalities of the program.
 *
 */
public class Controller {
	
	/**
	 * 
	 * This method controls the all the functionalities of the program.
	 * @param strJson
	 */
	public void groupAndSortList(String strJson){
	List<Owner> ownerLst = null;
	Parser parserObj = null;	
	SortList srtList = null;
	Map<String, List<Pet>> groupByType = null;
	
	ownerLst = new ArrayList<Owner>();	
	parserObj = new JsonParser();
	if (strJson != null && !strJson.isEmpty()){
	ownerLst = parserObj.parseJson(strJson);
	}
	srtList = new SortList();
	if(!CollectionUtils.isEmpty(ownerLst)){
	groupByType=srtList.sortList(ownerLst);
	}
	if(!MapUtils.isEmpty(groupByType)){
	display(groupByType);
	}
	}

	
	
	/**
	 * 
	 * This method iterate and print the final map.
	 * @param groupByPet
	 */
	public void display(Map<String, List<Pet>> groupByPet) {
		for (Entry<String, List<Pet>> entry : groupByPet.entrySet()) {
			System.out.println(entry.getKey());
			List<Pet> ptLst = entry.getValue();
			for (Pet pet : ptLst) {
				System.out.println("\t"+pet.getName());
			}
		}

	}

}
