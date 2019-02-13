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
    out.println("<html><big>Hola Amigo "+ nombre + "</big><br>"+
                cont + " Accesos desde su carga.</html>");
    JSONParser parser = new JSONParser();

    try {

	    Object obj = parser.parse(new FileReader("/home/alumne/Downloads/tomcat/p1_servlets/apache-tomcat-9.0.5/webapps/my_webapp/cotxes.json"));

	    JSONObject jsonObject = (JSONObject) obj;
	    out.println(jsonObject);
    }
    catch (IOException e){
	 e.printStackTrace();
    }
    catch (ParseException e) {
            e.printStackTrace();
        }

  }


   

  public void doPost(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    doGet(req, res);
  }
}
