package hello;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Util {

	public static double getUnderLyingPrice() {

		double value = 0;

		try {
			String response = null;

			response = Unirest.get("http://finance.google.com/finance/info?q=.INX")
					.header("authorization", "WpbO0IWzDWSLxgrL1Utg9WOxmmrttep4B6wqqISg")
					.header("cache-control", "no-cache").header("postman-token", "e90ef285-d1f8-2f1e-fe42-79bef6e6e23b")
					.asString().getBody();

			response = response.substring(5);
			response = response.replace(']', ' ');

			JsonNode jsonResponse = new JsonNode(response);
			String stringValue = jsonResponse.getObject().getString("l_cur");
			stringValue = stringValue.replaceAll(",", "");
			value = Double.parseDouble(stringValue.trim());

		} catch (Exception e) {
			System.out.println("!!! Exception in getting S&P 500 price");
		}

		return value;
	}
}
