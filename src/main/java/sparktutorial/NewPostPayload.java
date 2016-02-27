/**
 * Validates appropriate form of a JSON post 
 */
package sparktutorial;

import java.util.List;
import java.util.LinkedList;
import lombok.Data;

@Data
class NewPostPayload implements Validable {
	private String title;
	private List categories = new LinkedList<>();
	private String content;
	
	// Made obsolete by lombok!!
//	public String getTitle() { return title; }
//	public List getCategories() { return categories; }
//	public String getContent() { return content; }
//	public void setTitle(String title) { this.title = title; }
//	public void setCategories(List categories) { this.categories = categories; }
//	public void setContent(String content) { this.content = content; }
	
	public boolean isValid() {
		return title != null && !title.isEmpty() && !categories.isEmpty(); 
	}
}
