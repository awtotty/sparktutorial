package sparktutorial;

import java.util.*;
import java.util.stream.Collectors;

import lombok.Data;

public class Model {
	private int nextId = 1; 
	private Map posts = new HashMap<>(); // move to db later
	
	public int createPost(String title, String content, List categories) {
		int id = nextId++; 
		Post post = new Post(); 
		post.setTitle(title); 
		post.setContent(content);
		post.setCategories(categories);
		post.setId(id); 
		posts.put(id, post); // move to db
		return id; 
	}
	
	public List getAllPosts() {
		return (List) posts.keySet().stream().sorted().map((id) -> posts.get(id)).collect(Collectors.toList());
	}
}
