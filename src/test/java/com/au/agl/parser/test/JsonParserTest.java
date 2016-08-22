package com.au.agl.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.agl.au.bean.Owner;
import com.agl.au.bean.Pet;
import com.agl.au.parser.JsonParser;
import com.agl.au.parser.Parser;

public class JsonParserTest {


	/**
	 * This method test the JsonParser with null input.
	 */
	@Test
	public void testListEmpty() {
		Parser parser = new JsonParser();
		List<Owner> ownerList = new ArrayList<Owner>();
		String sb = null;
		assertEquals(ownerList, parser.parseJson(sb));

	}
	
		
	/**
	 * This method test the JsonParser with null pets.
	 */	
	@Test
	public void testListSizeOnePetsNull() {

		String strTest = "[{" + "name" + ":" + "Bob" + "," + "gender" + ":" + "Male"
				+ "," + "age" + ":" + "23" + "," + "pets" + ":" + "null" + "}]";
		Parser parser = new JsonParser();
		List<Owner> ownerList = new ArrayList<Owner>();
		Owner owner = new Owner();
		owner.setName("Bob");
		owner.setGender("Male");
		owner.setAge(23);
		ownerList.add(owner);
		List<Pet> petLst = new ArrayList<Pet>();
		assertEquals(ownerList, parser.parseJson(strTest));

	}

	/**
	 * This method test the JsonParser with owner and pets.
	 */
	@Test
	public void testListWithPets() {

		String strTest1 = "[{" + "name" + ":" + "Bob" + "," + "gender" + ":" + "Male"
				+ "," + "age" + ":" + "23" + "," + "pets" + ":" + "[{" + "name"
				+ ":" + "Garfield" + "," + "type" + ":" + "Cat" + "}" + ","
				+ "{" + "name" + ":" + "Fido" + "," + "type" + ":" + "Dog"
				+ "}]}" + "," + "{" + "name" + ":" + "Jennifer" + ","
				+ "gender" + ":" + "Female" + "," + "age" + ":" + 18 + ","
				+ "pets" + ":" + "[{" + "name" + ":" + "Garfield" + ","
				+ "type" + ":" + "Cat" + "}]}]";

		Parser parser = new JsonParser();
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
		assertEquals(ownerList, parser.parseJson(strTest1));
	}
}
