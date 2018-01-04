package hello;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Util {

	public static double getUnderLyingPrice(String symbol) {

		double value = 0;

		try {
			String response = null;

			response = Unirest.get("https://finance.google.com/finance?q=" + symbol + "&output=json")
					.header("authorization", "WpbO0IWzDWSLxgrL1Utg9WOxmmrttep4B6wqqISg")
					.header("cache-control", "no-cache").header("postman-token", "e90ef285-d1f8-2f1e-fe42-79bef6e6e23b")
					.asString().getBody();

			response = response.substring(3);
			//response = response.replace(']', ' ');

			JsonNode jsonResponse = new JsonNode(response);
			JSONArray jsonArray = jsonResponse.getArray();
			JSONObject stockInfo = jsonArray.getJSONObject(0);
			String stringValue = stockInfo.getString("l");
			stringValue = stringValue.replaceAll(",", "");
			value = Double.parseDouble(stringValue.trim());

		} catch (Exception e) {
			System.out.println(e);
		}

		return value;
	}
}
