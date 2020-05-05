package curso.rest.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Cliente3 {

	public static void main(String[] args) {		
		
		URL url;
		try {
			url = new URL("http://localhost:8080/Rest_Introduccion/rest/persona/modificar");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			
			connection.setDoOutput(true); //output
			connection.setDoInput(true); //input
			connection.setRequestMethod("POST");  //accion en la cual se va a invocar
			
			
			connection.setRequestProperty("Content-Type", "application/json"); //@Consumes //tipo de contenido que se envia al request
			connection.setRequestProperty("Accept", "application/xml"); //@Produces //tipo de contenido que se recibe
			
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream()); //recuperamos el getOutputStream de la conexion.			
			writer.write("{\"cedula\":\"110401176\",\"nombre\":\"hernan\",\"apellido\":\"ludena\"}"); //String que se envia al request.
			writer.close();			
						
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
			
			
			//Respuesta<?xml version="1.0" encoding="UTF-8" standalone="yes"?><persona><apellido>ludena</apellido><cedula>110401176</cedula><genero>M</genero><nombre>hernan</nombre></persona>
			//200
			//OK

		
			
			
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}		

	}
//	@POST
//	@Path(value = "/modificar")	  //recibe json y devuelve xml
//	@Produces("application/xml") 
//	@Consumes("application/json")   
//	public Persona modificar(Persona persona){	
//		persona.setGenero("M");
//		System.out.println(persona); 
//		return persona;
//	}


}
