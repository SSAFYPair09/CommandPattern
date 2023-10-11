package web.vo;

import java.sql.Timestamp;

public class Post {

	int id;
	String title, content, author, created_at;

	int visited;
	
	
	public Post() {
		super();
	}


	public Post(int id, String title, String content, String author, String created_at, int visited) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.created_at = created_at;
		this.visited = visited;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", created_at="
				+ created_at + ", visited=" + visited + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public int getVisited() {
		return visited;
	}
	public void setVisited(int visited) {
		this.visited = visited;
	}
}
