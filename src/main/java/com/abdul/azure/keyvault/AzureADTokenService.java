package com.abdul.azure.keyvault;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * 
 * @author abdul
 *
 */

public class AzureADTokenService {

	private String tokenAuthURI;
	private String clientId;
	private String clientSecret;
	private String grantType;
	private String scope;

	public String getToken(String clientId, String clientSecret, String tenantId, String grantType, String scope)
			throws MalformedURLException, IOException, URISyntaxException {

		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.grantType = grantType;
		this.scope = scope;

		tokenAuthURI = "https://login.microsoftonline.com" + "/" + tenantId + "/oauth2/v2.0/token";
		HttpURLConnection connection = null;
		connection = (HttpURLConnection) (new URL(tokenAuthURI)).openConnection();
		connection = setRequestParams(connection);
		System.out.println("url::" + connection.getURL().toURI().toString());
		connection.connect();
		String content = Util.readResponse(connection);
		return content;

	}

	private HttpURLConnection setRequestParams(HttpURLConnection connection) throws IOException {
		// TODO Auto-generated method stub

		String urlBodyParameters =    "grant_type=" + this.grantType + "&"
		                            + "client_id=" + this.clientId + "&"
				                    + "client_secret=" + this.clientSecret + "&"
		                            + "scope=" + this.scope;
		byte[] postBodyData = urlBodyParameters.getBytes(StandardCharsets.UTF_8);
		int postBodyDataLength = postBodyData.length;

		connection.setDoOutput(true);
		connection.setInstanceFollowRedirects(false);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("charset", "utf-8");
		connection.setRequestProperty("Content-Length", Integer.toString(postBodyDataLength));
		connection.setUseCaches(false);
		try (DataOutputStream writerObj = new DataOutputStream(connection.getOutputStream())) {
			writerObj.write(postBodyData);
		}
		return connection;
	}

}
