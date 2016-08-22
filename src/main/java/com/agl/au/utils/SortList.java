package com.agl.au.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.agl.au.bean.Owner;
import com.agl.au.bean.Pet;

/**
 * @author Gini
 * 
 * This class contains the method to sort the list of owners and group
 * them gender and filter the pet types by cat and sort in alphabetical
 * order
 *
 */
public class SortList {

	List<Pet> petLst = null;
	Map<String, List<Owner>> groupBygenderMap = null;
	Map<String, List<Pet>> groupByPet = null;
	List<Pet> catList=null;
	

	/**
	 * This method  sort the list of owners and group them gender and 
	 * filter the pet types by cat and sort in alphabetical order
	 * 
	 * @param ownerList
	 */
	public Map<String, List<Pet>> sortList(List<Owner> ownerList) {
		
		if(ownerList!=null && !ownerList.isEmpty()){

		groupBygenderMap = groupBygender(ownerList);

		groupByPet = new HashMap<String, List<Pet>>();
		for (Entry<String, List<Owner>> entry : groupBygenderMap.entrySet()) {
			petLst = new ArrayList<Pet>();
			List<Owner> owList = entry.getValue();
			for (Owner owner : owList) {
				List<Pet> petList = owner.getPetsList();
				if (petList != null && petList.size() != 0) {

					for (Pet pet : petList) {
						petLst.add(pet);
					}
				}
			}

			catList = filterAndSortPetsByType(petLst);

			groupByPet.put(entry.getKey(), catList);

		}
		}
		return groupByPet;
	}

	

	/**
	 * 
	 * This method group the OwnerList by gender
	 * 
	 * @param ownerLst
	 * @return Map<String, List<Owner>> *
	 * 
	 */
	private Map<String, List<Owner>> groupBygender(List<Owner> ownerLst) {

		groupBygenderMap = ownerLst.stream().collect(
				Collectors.groupingBy(Owner::getGender));
		return groupBygenderMap;
		
	}

	/**
	 * This method filter the cat from the pets and sort in alphabetical order
	 * 
	 * @param petLst
	 * @return
	 */
	private List<Pet> filterAndSortPetsByType(List<Pet> petLst) {

		List<Pet> catList = petLst.stream()
				.filter(t -> t.getType().equals("Cat"))
				.collect(Collectors.toList());
		catList.sort(new Comparator<Pet>() {
			@Override
			public int compare(Pet o1, Pet o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		return catList;
	}

}
