package java.rest.tenis.main;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



public class GetJsonAsString {

	 public static void main(String[] args) {

	     // Create Client
	     Client client = Client.create();

	     WebResource webResource = client.resource("http://localhost:8080/tenis/tenis");

	     ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

	     // Status 200 is successful.
	     if (response.getStatus() != 200) {
	         System.out.println("Failed with HTTP Error code: " + response.getStatus());
	         String error= response.getEntity(String.class);
	         System.out.println("Error: "+error);
	         return;
	     }

	     String output = response.getEntity(String.class);

	     System.out.println("Output from Server .... \n");
	     System.out.println(output);
	 }

	}