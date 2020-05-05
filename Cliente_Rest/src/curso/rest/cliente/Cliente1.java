package curso.rest.cliente;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Cliente1 {

	public static void main(String[] args) {		
		
		URL url;
		try {
			url = new URL("http://localhost:8080/Rest_Introduccion/rest/persona/insertar");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");  //accion en la cual se va a invocar
			
			connection.setRequestProperty("Content-Type", "application/xml"); //tipo de contenido que se envia al request
			
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream()); //recuperamos el getOutputStream de la conexion.
			
			writer.write("<persona><apellido>ludena</apellido><cedula>110401176</cedula><nombre>hernan</nombre></persona>"); //String que se envia al request.
			writer.close();
			
			System.out.println(connection.getResponseCode());
			System.out.println(connection.getResponseMessage());
			
			//204
			//Sin Contenido
			
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}		

	}
//	@POST
//	@Path(value = "/insertar")	
//	@Consumes("application/xml")   //tipo de trama a consumir
//	public void insertar(Persona persona){
//		System.out.println(persona);
//		
//	}


}
