package com.abdul.azure.keyvault;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author abdul
 *
 */

public class AzureKeyVaultService {

	private String resourceURI;
	private String token;
	private String apiversion = "2016-10-01";

	AzureKeyVaultService(String resourceURI, String response) throws IOException {

		this.resourceURI = resourceURI;
		createBearerToken(response);

	}

	private void createBearerToken(String response) throws IOException {
		// TODO Auto-generated method stub

		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(response);
		String access_token = actualObj.get("access_token").textValue();
		String token_type = actualObj.get("token_type").textValue();
		this.token = token_type.trim() + " " + access_token;

	}

	public String getSecret(String secret) throws IOException {

		String urlString = resourceURI + "/" + "secrets" + "/" + secret + "?" + "api-version=" + this.apiversion;
		URL urlObj = new URL(urlString);
		HttpURLConnection httpURLConnection = (HttpURLConnection) urlObj.openConnection();
		httpURLConnection.setRequestProperty("Authorization", token);
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.connect();
		String response = Util.readResponse(httpURLConnection);
		System.out.println("data retrived: " + response);
		return response;

	}

}
