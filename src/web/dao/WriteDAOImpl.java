package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Util.DBUtil;

public class WriteDAOImpl {

	private static WriteDAOImpl instance = null;
	private DBUtil dbUtil;

	private WriteDAOImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static WriteDAOImpl getInstance() {
		if (instance == null) {
			instance = new WriteDAOImpl();
		}

		return instance;
	}

	public int writePost() {
		Connection con = null;
		PreparedStatement stmt = null;
		int result = 0;

		try {
			con = dbUtil.getConnection();
			stmt = con.prepareStatement("insert into post(id,title,content,author,visited) values(?,?,?,?,0)");
			result = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(stmt, con);
		}
		return result;
	}
}
