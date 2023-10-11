package web.service;

import java.util.List;

import web.dao.PostDAOImpl;
import web.vo.Post;

public class PostServiceImpl {

	private PostDAOImpl dao = null;
	private static PostServiceImpl instance = null;
	
	private PostServiceImpl() {
		dao = PostDAOImpl.getInstance();
	}
	
	public static PostServiceImpl getInstance() {
		if (instance == null) {
			instance = new PostServiceImpl();
		}
		return instance;
	}

	public List<Post> getPosts() {
		return dao.getPosts();
	}
}
