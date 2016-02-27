package sparktutorial;

import lombok.Data;
import java.util.List;

public @Data class Post {
	private int id; 
	private String title;
	private List categories; 
	private String content; 
}
