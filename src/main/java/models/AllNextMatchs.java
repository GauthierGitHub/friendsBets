package models;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AllNextMatchs {

	private List<Match> nextMatchs;

	/**
	 * TODO matched with time
	 * apiToken : 1292d83abc324519b807bafd9a3c4a84
	 * @throws ParseException
	 */
	public AllNextMatchs() throws ParseException {
		try {
			URL url = new URL("http://api.football-data.org/v2/competitions");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Authorization", "1292d83abc324519b807bafd9a3c4a84");
			conn.setUseCaches(false);
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			else {
				// Next part of the functionality
				// There is a response from API
				Scanner sc = new Scanner(url.openStream());
				String inline = null; // string of the json
				while (sc.hasNext()) {
					inline = "";
					inline += sc.nextLine();
				}
				System.out.println("\nJSON data in string format");
				System.out.println(inline);
				sc.close();
// https://dzone.com/articles/how-to-parse-json-data-from-a-rest-api-using-simpl				
//				JSONParser parse = new JSONParser();
//				// throw parse error
//				JSONObject jobj = (JSONObject) parse.parse(inline);
//				System.out.println(jobj);
//				JSONArray jsonarr_1 = (JSONArray) jobj.get("competitions"); // must take an array []
//				System.out.println(jsonarr_1);
//				// Get data for Results array
//				for (int i = 0; i < jsonarr_1.size(); i++) {
//					// Store the JSON objects in an array
//					// Get the index of the JSON object and print the values as per the index
//					JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
//					System.out.println("Elements under results array");
//					System.out.println("\nid: " + jsonobj_1.get("id"));
//					System.out.println("area: " + jsonobj_1.get("area"));
//					System.out.println("name: " + jsonobj_1.get("name"));
//				}

				////////////////// parsint to string
				// Parse the JSON data present in the string format
				JSONParser parse = new JSONParser();
				// Type caste the parsed json data in json object
				JSONObject jobj = (JSONObject) parse.parse(inline);
				// Store the JSON object in JSON array as objects (For level 1 array element i.e
				// Results)
				JSONArray jsonarr_1 = (JSONArray) jobj.get("competitions");
				// Get data for Results array
				for (int i = 0; i < jsonarr_1.size(); i++) {
					// Store the JSON objects in an array
					// Get the index of the JSON object and print the values as per the index
					JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
					// Store the JSON object in JSON array as objects (For level 2 array element i.e
					// Address Components)
					JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get("competitions");
					System.out.println("Elements under results array");
					System.out.println("\nid: " + jsonobj_1.get("id"));
					System.out.println("area: " + jsonobj_1.get("area"));
					System.out.println("name: " + jsonobj_1.get("name"));
					// Get data for the Address Components array
					System.out.println("Elements under address_components array");
					System.out.println("The long names, short names and types are:");
					System.out.println(jsonobj_1);
					//System.out.println(jsonarr_2);
//					for (int j = 0; j < jsonarr_2.size(); j++){
//						// Same just store the JSON objects in an array
//						// Get the index of the JSON objects and print the values as per the index
//						JSONObject jsonobj_2 = (JSONObject) jsonarr_2.get(j);
//						// Store the data as String objects
//						String str_data1 = (String) jsonobj_2.get("long_name");
//						System.out.println(str_data1);
//						String str_data2 = (String) jsonobj_2.get("short_name");
//						System.out.println(str_data2);
//						System.out.println(jsonobj_2.get("types"));
//						System.out.println("\n");
//					}

				}
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
