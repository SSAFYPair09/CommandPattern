package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Util.DBUtil;
import web.vo.Post;

public class PostDAOImpl {

	private static PostDAOImpl instance = null;
	private DBUtil dbUtil;

	private PostDAOImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static PostDAOImpl getInstance() {
		if (instance == null) {
			instance = new PostDAOImpl();
		}

		return instance;
	}

	public List<Post> getPosts() {
		List<Post> posts = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = dbUtil.getConnection();
			stmt = con.prepareStatement("select * from post");
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String author = rs.getString(4);
				int visited = rs.getInt(5);
				String created_at = rs.getTimestamp(6).toString();
				Post p = new Post(id, title, content, author, created_at, visited);
				posts.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, stmt, con);
		}

		return posts;
	}
}
