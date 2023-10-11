package web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.service.PostServiceImpl;
import web.service.WriteServiceImpl;
import web.vo.Post;

public class WriteController implements Controller {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		int ret = 0;
		try {
			WriteServiceImpl writeService = WriteServiceImpl.getInstance();
			ret = writeService.writePost();
			map.put("success", Boolean.TRUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String json = om.writeValueAsString(map);
		System.out.println(json);
		out.append(json);
	}

}
