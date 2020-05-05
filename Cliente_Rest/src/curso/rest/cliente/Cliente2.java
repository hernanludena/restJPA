package curso.rest.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Cliente2 {

	public static void main(String[] args) {		
		
		URL url;
		try {
			url = new URL("http://localhost:8080/Rest_Introduccion/rest/persona/recuperar");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			
			connection.setDoInput(true); //input
			connection.setRequestMethod("GET");  //accion en la cual se va a invocar
			
			connection.setRequestProperty("Accept", "application/xml"); //tipo de contenido que se recibe
			
			InputStreamReader reader = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(reader);
			String tmp = null;
			String respuesta = "";
			while ((tmp=br.readLine())!=null) {
				respuesta += tmp;				
			}
						
			System.out.println("Respuesta"+respuesta);
			System.out.println(connection.getResponseCode());
			System.out.println(connection.getResponseMessage());
			
			//Respuesta<?xml version="1.0" encoding="UTF-8" standalone="yes"?><persona><apellido>ludena</apellido><cedula>110401176</cedula><nombre>hernan</nombre></persona>
			//200
			//OK
			
			
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}		

	}
//	@GET
//	@Path(value = "/recuperar")
//	@Produces("application/xml")  //tipo de trama a producir  	
//	public Persona recuperar(){
//		return new Persona("110401176","hernan","ludena");
//	}


}
