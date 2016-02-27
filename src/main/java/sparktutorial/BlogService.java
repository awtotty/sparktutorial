package sparktutorial;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import spark.Route;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class BlogService {
	
	private static final int HTTP_BAD_REQUEST = 400; 
	
	public static void main(String[] args) {
		Model model = new Model(); 
		
		// Get all posts (using HTTP get method)
		get("/posts", (req, res) -> {
			res.status(200); 
			res.type("application/json");
			return JsonHelper.dataToJson(model.getAllPosts()); 
		});
		
		// Create a post (using HTTP post method)
		post("/posts", (req, res) -> {
			try {
				ObjectMapper mapper = new ObjectMapper(); 
				NewPostPayload creation = mapper.readValue(req.body(), NewPostPayload.class); // .class? 
				if (!creation.isValid()) {
					res.status(HTTP_BAD_REQUEST);
					return ""; 
				}
				int id = model.createPost(creation.getTitle(), creation.getContent(), creation.getCategories());
				res.status(200);
				res.type("application/json");
				return id; 
			} catch (JsonParseException jpe) {
				res.status(HTTP_BAD_REQUEST);
				return ""; 
			}
		});
	}
}
