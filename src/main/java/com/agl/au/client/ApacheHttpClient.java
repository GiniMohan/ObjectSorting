package com.agl.au.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author Gini 
 * This class will consume the json web service and get the JSON with Owner Details
 *
 */
public class ApacheHttpClient  {

	/**
	 * This method will consume the web service and get the JSON from the
	 * service
	 * 
	 * @return String
	 */
	public String getJson() {

		StringBuilder sb = null;
		String strJson = null;
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(
					"http://agl-developer-test.azurewebsites.net/people.json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			String output;
			sb = new StringBuilder();
			while ((output = br.readLine()) != null) {
				sb.append(output);
			}
			if (sb != null && !sb.toString().equals("")) {
				strJson = sb.toString();
			}
			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {
			System.out
					.println("Error occured while consuming the web service :"
							+ e.getMessage());
		} catch (IOException e) {
			System.out.println("Error occured while consuming the web service"
					+ e.getMessage());
		}
		return strJson;
	}
}
