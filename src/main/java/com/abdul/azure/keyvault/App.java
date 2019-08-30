package com.abdul.azure.keyvault;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


/**
 * 
 * @author abdul
 *
 */
public class App {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub

		String tenantId = "";
		String clientId = "";
		String clientSecret = "";
		String grantType = "";
		String scope = "https://vault.azure.net/.default";
		String resourceURI = "https://samplekeyvault.vault.azure.net";

		System.setProperty("http.proxyHost", "example-proxy-server");
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("https.proxyHost", "example-proxy-server");
		System.setProperty("https.proxyPort", "8080");
		System.setProperty("http.proxyUser", "user");
		System.setProperty("http.proxyPassword", "userpassword");
		System.setProperty("https.proxyUser", "user");

		String tokenResponse = new AzureADTokenService().getToken(clientId, clientSecret, tenantId, grantType, scope);
		System.out.println("Token received is : + " + tokenResponse);

		String data = new AzureKeyVaultService(resourceURI, tokenResponse).getSecret("spring-db-password");
		System.out.println("data received is : + " + data);
	}

}
