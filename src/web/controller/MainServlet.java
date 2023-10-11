package web.controller;

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

import web.util.RSAEncryption;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
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
	        
	        //return Map 생성
	        Map<String, String> rmap = new HashMap<>();
	        
	        try {
	            Map<String, Object> js = om.readValue(request.getInputStream(), new TypeReference<Map<String, Object>>(){});
	            String sign = (String) js.get("sign");
	            System.out.println(sign);
	            
	            if(sign != null) {
	                
	                HttpSession session=null;
	                
	                switch(sign) {
	                case "listPost":
	                	
	                    break;
	                    
	                 default : rmap.put("msg", "잘못된 요청입니다");
	                }
	            } else {
	                System.out.println("secure coding...");
	                rmap.put("msg", "잘못된 요청입니다");
	            }
	            
	        } catch(Exception e) {
	            e.printStackTrace();
	            rmap.put("msg", e.getMessage());
	            
	        }
	        
	        String json = om.writeValueAsString(rmap);
	        out.append(json);
	        
	}

}
