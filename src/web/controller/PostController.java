package web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import web.service.PostServiceImpl;
import web.vo.Post;

public class PostController implements Controller {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
	    ObjectMapper om = new ObjectMapper();
	    Map<String, Object> map = new HashMap<>();
        try {
	        PostServiceImpl postService = PostServiceImpl.getInstance();
	        List<Post> list = postService.getPosts();
	        map.put("posts", list);
        } catch (Exception e) {
			e.printStackTrace();
		}
        String json = om.writeValueAsString(map);
        System.out.println(json);
        out.append(json);
	}

}
