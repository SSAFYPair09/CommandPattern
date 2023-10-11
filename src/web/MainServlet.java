package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import web.controller.Controller;
import web.controller.XmlBeanFactory;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Controller> controllers;
       
    public void init() throws ServletException {
		try {
	    	String path = getServletContext().getRealPath("/WEB-INF/beans.xml");
	    	XmlBeanFactory fac = XmlBeanFactory.getInstance(path);
	    	controllers = fac.getBeans();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("main servlet >> process");
		
		 request.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html;charset=utf-8");
	        PrintWriter out=response.getWriter();

		    ObjectMapper om = new ObjectMapper();
		    Map<String, Object> map = new HashMap<>();
		    
		    Map<String, String> rmap = new HashMap<>();
	        try {
		        Map<String, Object> js = om.readValue(request.getInputStream(), new TypeReference<Map<String, Object>>(){});
	            String sign = (String) js.get("sign");
	            System.out.println(sign);
	            
	            if(sign != null) {
	                
	                HttpSession session=null;
	                
	                switch(sign) {
	                case "listPost":
	                	Controller con = controllers.get("PostController");
	                	con.service(request, response);
	                    break;
	                    
	                 default : rmap.put("msg", "sorry");
	                }
	            } else {
	                System.out.println("secure coding...");
	                rmap.put("msg", "sorrysorry");
	            }
	            
	        } catch(Exception e) {
	            e.printStackTrace();
	            rmap.put("msg", e.getMessage());
	            
	        }
	        
	}

}
