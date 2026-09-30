package com.bbva.smre.lib.rf10.local;

import com.bbva.smre.lib.rf10.helpers.LogerUtils;
import com.bbva.smre.lib.rf10.utils.Utils;
import com.bbva.smre.lib.rf10.values.SMRERF10Constants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.Instant;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.zip.CRC32;




public class IdTokenFromServiceAccount {

	// Path to the service account json credential file.
	
	static String jsonCredentialName = "oficios_dev2.json";
	
	static String jsonCredentialPath = "/Users/Shared/DesBbvaGitHub/smre/smretf1001es/artifact/libraries/SMRERF10IMPL/src/main/resources/oficios_dev2.json";

	
     static String scope = "email";
	
   
    static String requestor = "natalia.hernando@dev.bbva.com";
     
	static String appId = "dev-bbva-mailbox-interceptor";
	
	static String mailBoxId = "oficios-ia@dev.bbva.com";
	
	
	static String urlApi = "https://dev-gag.bbva.com/mailbox-interceptor/labeling/modify_labels";
	
	static String urlApiGet = "https://dev-gag.bbva.com/mailbox-interceptor/labeling/get_labels";
	
	static String urlApiRep = "https://dev-gag.bbva.com/mailbox-interceptor/processing/reprocess_mail";
	
	static String mailId = "1a05730ef805daf1"; // 19f83de7d355829e ,  19f4620017f83d41  ,  1a00f00d9dae3990 (Prueba Etiquetado)
	
	//static String IAP_CLIENT_ID           = "317059527900-u90envnk5fif8u30f7jcfgip5jlvc794.apps.googleusercontent.com"; NO ES NECESARIO
	
	private static AccessToken accessToken;

	public static void main(String[] args) {

		String access_token = "";
		
		String resFromAccess = "";
		
		boolean callAPI=false;
		
		
		access_token = getGoogleCloudPlatformToken(); // ACCESS_TOKEN OKOKOKOK
		
		
		
		// String jws = jwsGcpTokenForMailBox();
	//	String jws = buildSignedJwtAccessToken(genJson()); // JWS OKOKOKOK
	//	access_token = genGCPTokenByRestTemplate(jws);  // ACCESS_TOKEN OKOKOKOK
		
	//	access_token = "ya29.c.c0AZ4bNpb6ylZGq30ArRe39xlDDNHdt1RdVZ_HVQSNSi3VWcjBV49oRUFT8X9b5whpKDG68E0tMbMYRVqgkQjF5WL0NfR916HhRbLVWLxo2ZWMNweVfI5PF7reaZQ_M-JKbgMybvBvSe39_sfwCzpbevpwlfgv1uf61MthR9YRnbqx13UkYjS0WlvzHpjHr5ogsrV-nM2wPmX4ecoJiGbVdMIdr9tfIcGA6nK2mk3KhOKUhVRluwUKw11fD6kmIADo8s54cfxxdjelMjcnJjXrWRrcBgSYidZHiHrakFB5kA44-Nh5uvQLD9RloYZgD-J3_mDdu7TYrbQ4aWbc2AI2v2wkmIIJ1hDc_C564XSHd5btIp6JLrOD22UG384Cdcg6swgo_Xk0t7bOBy-mdzXz5YzYQYjvM8l0Yi316gwnosuiBn0bdsUnwSxu0F_kef7YJ5dX6qUlR6nf4Vyti3OSFVjSnkBSOORo0RMtI5cZ6lUhidpR0ORYx9BcXpyr5syniBOd3JtuhxRk7dQ5zqWayR4QjSU9O0xxv2Bygy7uoy_SRs-daZwv8eM3dk75Xn27Wp9gOkxBUXpSof5mzJ42zuy0WWYqlkcR-bbX8lzB25xr5Ijs4ffFBJc46BeZ8oU-20iOwdrVxrJdJvZJ8Fj8SvQwV_2O-ae4grugbsd88JMXO4iyIIpuJnnquZlX9objJxicVBF4ZakWpUf1jY-19n4-S4dvlhMJlhRVgX13eQnYid3c-BUIeZB3mRg58ojOqixqRuUwoOaxlvkOQwhShM08n0sXcnUq8qo76lzdoft1xy_6Ixqtkeg-QdcJnR8kYQr83k5x58s9ZMvq1e91Sb9a0Jpjhkq-Ir9z6J5fi9prnZgUkcd-oUwauB5_8IqSylf7Bm7nU1rcdc0-8nOZVOcXk9B_i3t3ddt0Ukp18szJRh23Bt979hX0YRnaU4ZMvVxa2h-97vIRF0vxhWZBOJ906jigUq";
		
	//	System.out.println("jws generated: " + jws);
		System.out.println("");
		
		
		
		
		System.out.println("Scope used: " + scope);
		System.out.println("");
		
		System.out.println("requestor used: " + requestor);
		System.out.println("");
		
		System.out.println("access_token generated: " + access_token);
		System.out.println("");
		
		System.out.println("mailBoxId used: " + mailBoxId);
		System.out.println("");
		
		System.out.println("mailId used: " + mailId);
		System.out.println("");
		
		
		// LLAMADA OKOKOK
		if(callAPI) {
			// Call the API with the generated access_token

			resFromAccess = callApiWithJwtTokenModLabels(urlApi, access_token, 
					mailBoxId, mailId, 
					Arrays.asList("LABEL_A", "LABEL_B"),
					Arrays.asList("LABEL_C"));
	        
			
			// resFromAccess = callApiWithJwtTokenGetLabels(urlApiGet, access_token, mailBoxId, mailId);
			
			// resFromAccess = callApiWithJwtTokenRepro(urlApiRep, access_token, mailBoxId, mailId);
			
			System.out.println("");
			
			System.out.println("Response from API using access_token: " + resFromAccess);
		}
		
        
		System.out.println("");
		
		System.out.println("Fin local test ");

	}

	
	
	
	public static String callApiWithJwtTokenModLabels(String urlApi, String gcp_token, String mailboxId,String mailId, List<String> labelsToAdd,
			List<String> labelsToRemove) {
		
		System.out.println("Calling API with JWT token...");
		
		
		try {
		
			 String jsonBody = String.format(
		                "{\"mailbox_id\":\"%s\",\"mail_id\":\"%s\",\"add_labels\":[%s],\"remove_labels\":[%s]}",
		                mailboxId,
		                mailId, 
		                formatListForJson(labelsToAdd), 
		                formatListForJson(labelsToRemove)
		        );

			 System.out.println("payload: " + jsonBody);
			HttpClient client = HttpClient.newHttpClient();

			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlApi))
					.header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + gcp_token) 																																																																																				
					//.header("X-BBVA-AppId", appId)
					//.header("X-BBVA-AppSecret",IAP_CLIENT_ID ) 
					.header("Requestor", requestor)
					//.header("X-BBVA-Env", "Development")
					.POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();

			
			System.out.println("\n");
			System.out.println("Request headers from API using access_token: " + request.headers());
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println("\n");
			System.out.println("Response headers from API using access_token: " + response.headers());
			
			return response.body();

		} catch (Exception e) {
			// Manejo de errores básico (puedes adaptarlo a tu sistema de logs)
			e.printStackTrace();
			return "Error al realizar la llamada a la API: " + e.getMessage();
		}

	}
	
	public static String callApiWithJwtTokenRepro(String urlApi, String gcp_token, String mailboxId,String mailId) {
		
		System.out.println("Calling API with JWT token...");
		
		
		try {
		
			 String jsonBody = String.format(
		                "{\"mailbox_id\":\"%s\",\"mail_id\":\"%s\",\"delay\":%d}",
		                mailboxId,
		                mailId, 
		                60
		             
		        );

			 System.out.println("payload: " + jsonBody);
			HttpClient client = HttpClient.newHttpClient();

			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlApiRep))
					.header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + gcp_token) 																																																																																							
					.header("Requestor", requestor)					
					.POST(HttpRequest.BodyPublishers.ofString(jsonBody)).build();

			
			System.out.println("\n");
			System.out.println("Request headers from API using access_token: " + request.headers());
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println("\n");
			System.out.println("Response headers from API using access_token: " + response.headers());
			
			return response.body();

		} catch (Exception e) {
			// Manejo de errores básico (puedes adaptarlo a tu sistema de logs)
			e.printStackTrace();
			return "Error al realizar la llamada a la API: " + e.getMessage();
		}

	}
	
	public static String callApiWithJwtTokenGetLabels(String urlApi, String gcp_token, String mailboxId,String mailId) {
		
		System.out.println("Calling API with JWT token...");
		
		
		try {
		
			HttpClient client = HttpClient.newHttpClient();

			String mailboxIdEscaped = URLEncoder.encode(mailboxId, StandardCharsets.UTF_8);
			String mailIdEscaped = URLEncoder.encode(mailId, StandardCharsets.UTF_8);
			
			String urlConParametros = urlApiGet + "?mailbox_id=" + mailboxIdEscaped + "&mail_id=" + mailIdEscaped;

			
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlConParametros))
					.header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + gcp_token) 																																																																																									
					.header("Requestor", requestor)					
					.GET().build();

			
			System.out.println("\n");
			System.out.println("Request headers from API using access_token: " + request.headers());
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println("\n");
			System.out.println("Response headers from API using access_token: " + response.headers());
			
			return response.body();

		} catch (Exception e) {
			// Manejo de errores básico (puedes adaptarlo a tu sistema de logs)
			e.printStackTrace();
			return "Error al realizar la llamada a la API: " + e.getMessage();
		}

	}
	
	

	private static String formatListForJson(List<String> list) {
		if (list == null || list.isEmpty()) {
			return "";
		}
		return list.stream().map(item -> "\"" + item + "\"").collect(Collectors.joining(","));
	}
	
	
	
	
	public static String getGoogleCloudPlatformToken() {

		try {
			accessToken = generateGCPAuthorizationHeader(jsonCredentialPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accessToken.getTokenValue();
	}
	
	public static AccessToken generateGCPAuthorizationHeader(String rutaJson) throws IOException{
        
		 Path ruta = Path.of(rutaJson);
	        String contenidoJson = Files.readString(ruta);
		
		String certificateContent = contenidoJson; // Aquí debes colocar el contenido de tu certificado en formato JSON
        GoogleCredentials credentials;

        try {
            credentials = getGoogleCredentials(certificateContent);
          
            return credentials.refreshAccessToken();
        } catch (IOException e) {
            throw new SecurityException("Failed to generate GCP authorization header", e);
        }
    }
	
	static GoogleCredentials getGoogleCredentials(String certificateContent) throws IOException {
        return GoogleCredentials.fromStream(new ByteArrayInputStream(certificateContent.getBytes()))
                .createScoped(Collections.singleton("email"));
    }
	
	@SuppressWarnings("unchecked")
	private static <T extends Throwable> RuntimeException sneakyThrow(Throwable t) throws T {
	    throw (T) t;
	}
	
	
	
	public static String jwsGcpTokenForMailBox() {
		
		 // ConstantsLoc.IAP_CLIENT_ID_DV en pruebas locales, poner la buena, para subir a null
		return buildSignedJwtAccessToken(genJson());
		
	}
	
	
	public static String printInfo(String key) {
		CRC32 crc = new CRC32();
		crc.update(key.getBytes(java.nio.charset.StandardCharsets.UTF_8));
		crc.getValue();
		
		return String.format("CRC32: %d", crc.getValue());
        
	}
	
	private static final String L_GJWS = "Generated JWS: {}";
	private static final String PK     = "private_key";
	private static final String PKI    = "private_key_id";
	private static final String CL     = "client_email";
	private static final String RS256  = "RS256";
	
	// scope - genera access_token
		public static  String buildSignedJwtAccessToken(JsonNode saInfo)
	    {
			
			    String privateKeyPem = saInfo.get(PK).asText();
			    

			    
			    String privateKeyId = saInfo.get(PKI).asText();
			    
			    System.out.println("privateKeyId length: " + privateKeyId.length());
			    System.out.println("privateKeyPem crc32: " + printInfo(privateKeyId));
			    
			    
			    String clientEmail = saInfo.get(CL).asText();
			   
			   // https://oauth2.googleapis.com/token
			  String aud = SMRERF10Constants.GOOGLE_TOKEN_URL_DV;  
			  aud = "https://oauth2.googleapis.com/token";
			  
			    Instant now = Instant.now();
			    long iatDateSeconds = now.getEpochSecond();
			    long expireDateSeconds = now.plusSeconds(3600).getEpochSecond(); 
			    
			    RSAPrivateKey privateKey = privateKeyFromStr(privateKeyPem);

			    
	        String payLoad = "{" +
	                "\"iss\":\"" + clientEmail + "\"," +
	        		"\"sub\":\"" + clientEmail + "\"," +
	                "\"aud\":\"" + aud + "\"," +
	                "\"scope\":\"" + SMRERF10Constants.MAILBOX_GCP_SCOPE_DV + "\"," +
	                "\"iat\":" + iatDateSeconds + "," + 
	                "\"exp\":" + expireDateSeconds + "}";
	        
	        System.out.println("payLoad used: " + payLoad);
			System.out.println("");
	        
	        return Jwts.builder()
	                .setHeaderParam("typ", "JWT")
	                .setHeaderParam("alg", RS256)
	                .setHeaderParam("kid", privateKeyId)
	                .setPayload(payLoad)
	                .signWith(SignatureAlgorithm.RS256, privateKey)
	                .compact();
	    }
		
		@SneakyThrows 
		private static RSAPrivateKey privateKeyFromStr(String keyPem) {
		    String privateKeyPEM = keyPem
		            .replace("-----BEGIN PRIVATE KEY-----", "")
		            .replace("-----END PRIVATE KEY-----", "")
		            .replace("\\n", "")
		            .replace("\\r", "")
		            .replaceAll("[\\s\\\\]", "");
		    
		    System.out.println("privateKeyPem length: " + privateKeyPEM.length());
		    System.out.println("privateKeyPem crc32: " + printInfo(privateKeyPEM));
		    
		    byte[] keyBytes = Base64.getMimeDecoder().decode(privateKeyPEM);
		    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		    
		    RSAPrivateKey llavePrivada = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(spec);
		    

		    
		    LogerUtils.textLog("llavePrivada: {}", Utils.ofuscar("privateKeyFromStr"));
		    return llavePrivada;
		}
		
		private static  JsonNode genJson() {
			
			
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode rootNode = mapper.createObjectNode();
			rootNode.put("type",  SMRERF10Constants.MAILBOX_GCP_TYPE_DV);
			rootNode.put("project_id", SMRERF10Constants.MAILBOX_GCP_PROJECT_ID_DV);
			rootNode.put(PKI, SMRERF10Constants.MAILBOX_GCP_PRIVATE_KEY_ID_DV);
			
			//ConstantsLoc.MAILBOX_GCP_PRIVATE_KEY_DV_ARR en pruebas locales, poner la buena
			rootNode.put(PK, Utils.getStrPropArr(null, SMRERF10Constants.MAILBOX_GCP_PRIVATE_KEY,ConstantsLoc.MAILBOX_GCP_PRIVATE_KEY_DV_ARR));
			
			rootNode.put(CL, Utils.getStrProp(null, SMRERF10Constants.MAILBOX_GCP_CLIENT_EMAIL,SMRERF10Constants.MAILBOX_GCP_CLIENT_EMAIL_DV));
			
			rootNode.put("auth_uri", Utils.getStrProp(null, SMRERF10Constants.MAILBOX_GCP_AUTH_URI,SMRERF10Constants.MAILBOX_GCP_AUTH_URI_DV));
			rootNode.put("token_uri", Utils.getStrProp(null, SMRERF10Constants.MAILBOX_GCP_TOKEN_URI,SMRERF10Constants.MAILBOX_GCP_TOKEN_URI_DV));
				
			rootNode.put("universe_domain", Utils.getStrProp(null, SMRERF10Constants.MAILBOX_GCP_UNIVERSE_DOMAIN,SMRERF10Constants.MAILBOX_GCP_UNIVERSE_DOMAIN_DV));
			
			return rootNode;
			
		}
		
		public static String  genGCPTokenByRestTemplate(String signedJwt) {
			HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
	                                
	        body.add("grant_type", SMRERF10Constants.JWT_GRANT_TYPE_DV);
	        body.add("assertion", signedJwt); 
	                
	        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);
	      
	        ResponseEntity<Map<String, Object>> mailboxResponse = null;
	        
	        
	        
	        String url = SMRERF10Constants.GOOGLE_TOKEN_URL_DV;
	        url = "https://oauth2.googleapis.com/token";
	        RestTemplate rt =new RestTemplate();
	        
	        try {
				LogerUtils.textLog("genGCPTokenByRestTemplate() - Calling Google Token URL: {}", url);
				mailboxResponse = rt.exchange(url, HttpMethod.POST, requestEntity,new ParameterizedTypeReference<Map<String, Object>>(){},
						java.util.Collections.emptyMap());
			}  catch (RestClientException e) {
				LogerUtils.textLog("Error_logging Google Token URL: {}", e.getMessage());
				return null;
			}
	        if(mailboxResponse.getBody() == null) {
				LogerUtils.textLog("Mailbox response from API is null");
				return null;
			}
	        Map<String, Object> responseBody = mailboxResponse.getBody();

	        if (responseBody == null || !responseBody.containsKey(SMRERF10Constants.MAILBOX_GCP_TYPE_TOKEN)) {
				LogerUtils.textLog("Token not found in Google response");
				return null;
			}
	        LogerUtils.textLog("Campos devueltos por Google: {}", responseBody.keySet()); 
	        
	        String token=Utils.safeStringFromMap(responseBody, SMRERF10Constants.MAILBOX_GCP_TYPE_TOKEN);
	        
	        LogerUtils.textLog("token devuelto por Google: {}", token);
	        
	        return token;
	        
		}

}
