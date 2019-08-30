package com.abdul.azure.keyvault;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.stream.Collectors;

/**
 * 
 * @author abdul
 *
 */
public class Util {
	
	
	
	public static String readResponse(HttpURLConnection connection) throws IOException {
		BufferedReader bufferedReader = null;
		if (connection.getResponseCode() != 200) {
			bufferedReader = new BufferedReader(new InputStreamReader((connection.getErrorStream())));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
		}
		return readContent(bufferedReader);
	}
	
	
	public static String readContent(BufferedReader reader) {
		return reader.lines().collect(Collectors.joining(System.lineSeparator()));
	}
	
	
	/*
	 * https://www.baeldung.com/how-to-use-resttemplate-with-basic-authentication-in
	 * -spring https://gist.github.com/DaddyMoe/53c4e8e412b00ad34523e4b27ea4e48c
	 * https://stackoverflow.com/questions/21920268/basic-authentication-for-rest-
	 * api-using-spring-resttemplate
	 * https://stackoverflow.com/questions/21101250/sending-get-request-with-
	 * authentication-headers-using-resttemplate/43590348
	 * https://www.google.com/search?source=hp&ei=zw1pXYPECYH69QOjuoGQCw&q=Spring+
	 * restTemplate+add+Authorization+header+for+GET+&oq=Spring+restTemplate+add+
	 * Authorization+header+for+GET+&gs_l=psy-ab.3..33i22i29i30.1090.19894..20617...
	 * 0.0..0.275.7166.13j35j7......0....1..gws-wiz.....6..
	 * 0i324j0i131j0j0i308i154i357j0i3j38j0i22i30j0i13i30j33i160j33i21.ldgGNCBSIOE&
	 * ved=0ahUKEwjD59j3w6rkAhUBfX0KHSNdALIQ4dUDCAU&uact=5
	 * https://stackoverflow.com/questions/38372422/how-to-post-form-data-with-
	 * spring-resttemplate
	 * https://stackoverflow.com/questions/38372422/how-to-post-form-data-with-
	 * spring-resttemplate
	 * https://stackoverflow.com/questions/38372422/how-to-post-form-data-with-
	 * spring-resttemplate
	 * https://stackoverflow.com/questions/35998790/resttemplate-how-to-send-url-and
	 * -query-parameters-together
	 * https://stackoverflow.com/questions/17144215/resttemplate-with-query-params
	 * https://stackoverflow.com/questions/34288716/how-to-send-post-data-or-form-
	 * data-through-java-net-httpurlconnection-to-access
	 * https://stackoverflow.com/questions/7181534/http-post-using-json-in-java
	 * http://zetcode.com/java/getpostrequest/
	 * 
	 * https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
	 */															//https://juffalow.com/java/how-to-send-http-get-post-request-in-java
																//https://stackoverflow.com/questions/4205980/java-sending-http-parameters-via-post-method-easily
																//	https://www.baeldung.com/httpurlconnection-post

}
