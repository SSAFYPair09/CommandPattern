package web.dao;

public class PostDAOImpl {
	
	private static PostDAOImpl instance = null;
	
	private PostDAOImpl() {}
	
	public static PostDAOImpl getInstance() {
		if(instance == null) {
			instance = new PostDAOImpl();
		}
		
		return instance;
	}
	
	public static List<Post>
}
