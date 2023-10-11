package web.service;

import web.dao.WriteDAOImpl;

public class WriteServiceImpl {

	private WriteDAOImpl dao = null;
	private static WriteServiceImpl instance = null;
	
	private WriteServiceImpl() {
		dao = WriteDAOImpl.getInstance();
	}
	
	public static WriteServiceImpl getInstance() {
		if (instance == null) {
			instance = new WriteServiceImpl();
		}
		return instance;
	}
	
	public int writePost() {
		return dao.writePost();
	}
}
