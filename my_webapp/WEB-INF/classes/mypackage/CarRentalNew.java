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
    String nom = req.getParameter("model_vehicle");
    String motor = req.getParameter("sub_model_vehicle");
    String dies = req.getParameter("dies_lloguer");
    String num_vehi = req.getParameter("num_vehicles");
    String des = req.getParameter("descompte");
    JSONObject obj = new JSONObject();
    obj.put("nom", nom);
    obj.put("motor", motor);
    obj.put("dies", dies);
    obj.put("num_vehi", num_vehi);
    obj.put("descompte", des);
    try(FileWriter file = new FileWriter("/home/alumne/Downloads/tomcat/p1_servlets/apache-tomcat-9.0.5/webapps/my_webapp/cotxes.json", true)){
         file.write(obj.toJSONString());
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
