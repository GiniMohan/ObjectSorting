package com.agl.au.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.agl.au.bean.Owner;
import com.agl.au.bean.Pet;
import com.agl.au.constants.Constants;

/**
 * @author Gini
 * 
 * This Interface will parse the JSON and return the list of owners
 *
 */
public class JsonParser implements Parser {

	List<Owner> ownerList = null;

	/**
	 * This method will parse the JSON consumed from the web service.
	 * 
	 * @param String
	 *            Builder
	 * @return List<Owner>
	 */
	@Override
	public List<Owner> parseJson(String sb) {
				
		JSONArray jsonArray = null;
		try {

			if (sb != null && !sb.isEmpty()) {
				jsonArray = new JSONArray(sb);
			}
			ownerList = new ArrayList<Owner>();

			if (jsonArray != null) {
				int count = jsonArray.length(); // get totalCount of all
												// jsonObjects
				for (int i = 0; i < count; i++) { // iterate through jsonArray
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					Owner ownerObj = new Owner();
					String name = jsonObject.getString(Constants.NAME);
					ownerObj.setName(name);
					String gender = jsonObject.getString(Constants.GENDER);
					ownerObj.setGender(gender);
					long age = jsonObject.getLong(Constants.AGE);
					ownerObj.setAge(age);
					List<Pet> petList = new ArrayList<Pet>();
					if (!jsonObject.get(Constants.PETS).equals(null)) {
					//	JSONObject pets = jsonObject.getJSONObject("pets");
						JSONArray jsonArray1 = jsonObject.getJSONArray("pets");
						if (jsonArray1 != null) {
							int cnt = jsonArray1.length();
							for (int j = 0; j < cnt; j++) {

								Pet petObj = new Pet();
								JSONObject jsonObject1 = jsonArray1
										.getJSONObject(j);
								String petName = jsonObject1
										.getString(Constants.NAME);
								petObj.setName(petName);
								String petType = jsonObject1
										.getString(Constants.TYPE);
								petObj.setType(petType);
								petList.add(petObj);
							}
						}
						ownerObj.setPetsList(petList);
					}
					ownerList.add(ownerObj);
					

				}
			}
		} catch (JSONException e) {
			System.out.println("Error occurred while parsing the JSON"
					+ e);
			e.printStackTrace();
		}
		return ownerList;
	}

}
