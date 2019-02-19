package mypackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CarRentalList extends HttpServlet {

  int cont = 0;

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    String nombre = req.getParameter("userid");
    cont ++;
   

	JSONObject obj;
	String fileName = "/home/alumne/Documents/apache-tomcat-9.0.5/webapps/my_webapp/cotxes.json";
	String line = null;

	try {
				
		FileReader fileReader = new FileReader(fileName);

		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		//Falta que quedi maco
		while((line = bufferedReader.readLine()) != null) {
			obj = (JSONObject) new JSONParser().parse(line);
			out.println("<p>" + " Nom: " + (String)obj.get("nom") +
			" Motor: " +(String)obj.get("motor") +
			 " Nombre de vehicles: " + (String)obj.get("num_vehi") +
			 " Durada en dies: " + (String)obj.get("dies") +
			 " Descompte: " + (String)obj.get("descompte") + "</p>");
										   
		}
		
		bufferedReader.close();         
	}
	catch(FileNotFoundException ex) {
		System.out.println("Unable to open file '" + fileName + "'");                
	}
	catch(IOException ex) {
		System.out.println("Error reading file '" + fileName + "'");                  
		
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
}
  


   

  public void doPost(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    doGet(req, res);
  }
}
