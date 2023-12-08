package com.wipro.raemisclient.apiservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.wipro.raemisclient.common.Core5GDetails;

public abstract class HTTPService {

	protected static void POST(final String microserviceUrl, String data) throws IOException {

		try {
			// Microservice endpoint URL with query parameters
			String urlString = microserviceUrl + "?node_id=" + data;

			URL url = new URL(urlString);

			// Open a connection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Set the request method to GET
			connection.setRequestMethod("POST");

			// Get the response code
			int responseCode = connection.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			// Read the response
			try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				// Print the response
				System.out.println("Response: " + response.toString());
			}

			// Close the connection
			connection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * try { // Create an HttpClient HttpClient httpClient =
		 * HttpClient.newHttpClient();
		 * 
		 * // Create an HttpRequest with POST method and JSON payload HttpRequest
		 * request = HttpRequest.newBuilder().uri(URI.create(microserviceUrl))
		 * .header("Content-Type", "application/json")
		 * .POST(HttpRequest.BodyPublishers.ofString(jsonData,
		 * StandardCharsets.UTF_8)).build();
		 * 
		 * // Send the request and get the response HttpResponse<String> response =
		 * httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		 * 
		 * // Print the response code and body System.out.println("Response Code: " +
		 * response.statusCode()); System.out.println("Response Body: " +
		 * response.body());
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
	}
}
