package java.rest.tenis.json;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rest.tenis.models.Country;
import java.rest.tenis.models.Data;
import java.rest.tenis.models.Player;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class JsonReaderToList {

	public static List<Player> getPlayers() throws IOException {
		InputStream input = new FileInputStream(".\\jsonfile\\data.json");

		// Create JsonReader object
		JsonReader jsonReader = Json.createReader(input);

		// Get JsonObject (root object).
		JsonObject rootJSON = jsonReader.readObject();

		// Close resources
		jsonReader.close();
		input.close();

		// Create empty Company object.
		JsonArray jsonArray = rootJSON.getJsonArray("players");

		// Traverse the list
		List<Player> players = new ArrayList<Player>();

		for (int i = 0; i < jsonArray.size(); i++) {
			System.out.println(jsonArray.stream());

			JsonObject jsonobject = jsonArray.getJsonObject(i);

			Player player = new Player();
			player.setId(jsonobject.getInt("id"));
			player.setFirstname(jsonobject.getString("firstname"));
			player.setLastname(jsonobject.getString("lastname"));
			player.setShortname(jsonobject.getString("shortname"));
			player.setSex(jsonobject.getString("sex"));

			JsonObject countryJSON = jsonobject.getJsonObject("country");
			Country country = new Country();
			country.setCode(countryJSON.getString("code"));
			country.setPicture(countryJSON.getString("picture"));
			player.setCountry(country);

			// Reading inner object from json object.
			JsonObject dataJSON = jsonobject.getJsonObject("data");
			Data data = new Data();
			data.setAge(dataJSON.getInt("age"));
			data.setHeight(dataJSON.getInt("height"));
			data.setPoints(dataJSON.getInt("points"));
			data.setRank(dataJSON.getInt("rank"));
			data.setWeight(dataJSON.getInt("weight"));

			// Reading websites array from json
			JsonArray lastarray = dataJSON.getJsonArray("last");
			int[] last = new int[lastarray.size()];

			int index = 0;
			for (JsonValue value : lastarray) {
				last[index++] = (int) Integer.parseInt(value.toString());
			}
			data.setLast(last);
			player.setData(data);

			players.add(player);

			

		}
		return players;

	}
}