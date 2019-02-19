package mypackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class CarRentalNew extends HttpServlet {

  int cont = 0;

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    String nombre = req.getParameter("name");
    cont ++;
    out.println("<html><big>Hola Amigo Premoh' "+ nombre + "</big><br>"+
                cont + " Accesos desde su carga.</html>");
    int nom = Integer.parseInt(req.getParameter("model_vehicle"));
    String motor = req.getParameter("sub_model_vehicle");
    String dies = req.getParameter("dies_lloguer");
    String num_vehi = req.getParameter("num_vehicles");
    String des = req.getParameter("descompte");
    JSONObject obj = new JSONObject();
    if( nom == 71 ){
		obj.put("nom", "SemilLuxe");
	}
	else if( nom == 54) obj.put("nom", "Economic");
	else if( nom == 82) obj.put("nom", "Luxe");
	else if( nom == 139) obj.put("nom", "Limusina");
    obj.put("motor", motor);
    obj.put("dies", dies);
    obj.put("num_vehi", num_vehi);
    obj.put("descompte", des);
    try(FileWriter file = new FileWriter("/home/alumne/Documents/apache-tomcat-9.0.5/webapps/my_webapp/cotxes.json", true)){
         file.write(obj.toJSONString());
         file.write("\n");
	 file.flush();
         out.println("<br><br>" + obj);
    }
    catch (IOException e){
	 e.printStackTrace();
    }
    
    
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException {
    doGet(req, res);
  }
}
