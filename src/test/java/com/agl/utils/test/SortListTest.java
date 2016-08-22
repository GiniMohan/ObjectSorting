package com.agl.utils.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.agl.au.bean.Owner;
import com.agl.au.bean.Pet;
import com.agl.au.utils.SortList;

public class SortListTest {
	
	
	/**
	 * This method test the list with null input
	 */
	@Test
	public void testListWithNull() {
		SortList srtLst=new SortList();
		List<Owner> ownerList = null;
		Map<String, List<Pet>> groupByPet = null;
		assertEquals(groupByPet, srtLst.sortList(ownerList));
	}

	
	/**
	 * This method test the list with two input
	 */
	@Test
	public void testListWithTwoInputs() {
		SortList srtLst=new SortList();
		List<Owner> ownerList = new ArrayList<Owner>();
		Owner owner = new Owner();
		owner.setName("Bob");
		owner.setGender("Male");
		owner.setAge(23);
		List<Pet> petLst = new ArrayList<Pet>();
		Pet pet=new Pet();
		pet.setName("Garfield");
		pet.setType("Cat");
		petLst.add(pet);
		Pet petO1=new Pet();
		petO1.setName("Fido");
		petO1.setType("Dog");
		petLst.add(petO1);
		owner.setPetsList(petLst);		
		ownerList.add(owner);
		
		Owner owner1 = new Owner();
		owner1.setName("Jennifer");
		owner1.setGender("Female");
		owner1.setAge(18);
		List<Pet> petLst1 = new ArrayList<Pet>();
		Pet pet1=new Pet();
		pet1.setName("Garfield");
		pet1.setType("Cat");
		petLst1.add(pet1);
		owner1.setPetsList(petLst1);
		ownerList.add(owner1);	
		
		List<Pet> petLst2 = new ArrayList<Pet>();
		Pet pet2=new Pet();
		pet2.setName("Garfield");
		pet2.setType("Cat");
		petLst2.add(pet);
		
		Map<String, List<Pet>> groupByPet = new HashMap<String, List<Pet>>();
		groupByPet.put("Female", petLst1);
		groupByPet.put("Male", petLst2);	
		
		assertEquals(groupByPet, srtLst.sortList(ownerList));
		
	}
	
	
	/**
	 * This method test the list with more inputs
	 */
	@Test
	public void testListWithInputs() {
		SortList srtLst=new SortList();
		List<Owner> ownerList = new ArrayList<Owner>();
		Owner owner = new Owner();
		owner.setName("Bob");
		owner.setGender("Male");
		owner.setAge(23);
		List<Pet> petLst = new ArrayList<Pet>();
		Pet pet=new Pet();
		pet.setName("Fido");
		pet.setType("Cat");
		petLst.add(pet);
		Pet petO1=new Pet();
		petO1.setName("Garfield");
		petO1.setType("Cat");
		petLst.add(petO1);
		owner.setPetsList(petLst);		
		ownerList.add(owner);
		
		Owner owner1 = new Owner();
		owner1.setName("Jennifer");
		owner1.setGender("Female");
		owner1.setAge(18);
		List<Pet> petLst1 = new ArrayList<Pet>();
		Pet pet1=new Pet();
		pet1.setName("Garfield");
		pet1.setType("Cat");
		petLst1.add(pet1);
		owner1.setPetsList(petLst1);
		ownerList.add(owner1);	
		
		
		Owner owner3 = new Owner();
		owner3.setName("Asha");
		owner3.setGender("Female");
		owner3.setAge(18);
		List<Pet> petLst3 = new ArrayList<Pet>();
		Pet pet3=new Pet();
		pet3.setName("Tabby");
		pet3.setType("Cat");
		petLst3.add(pet3);
		owner3.setPetsList(petLst3);
		ownerList.add(owner3);
		
		List<Pet> petLst4 = new ArrayList<Pet>();
		petLst4.add(pet1);
		petLst4.add(pet3);
				
		Map<String, List<Pet>> groupByPet = new HashMap<String, List<Pet>>();
		groupByPet.put("Female", petLst4);
		groupByPet.put("Male", petLst);	
		assertEquals(groupByPet, srtLst.sortList(ownerList));
		
	}
	
	

}
