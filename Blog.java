package BlogManager;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Blog {
    private ArrayList<BlogPost> posts;
    private static final Logger logger = Logger.getLogger(Blog.class.getName());

    public Blog() {
        posts = new ArrayList<>();
    }

    public void addPost(BlogPost post) {
        posts.add(post);
        logger.log(Level.INFO, "Post added successfully!");
    }

    public void viewPosts() {
        if (posts.isEmpty()) {
            logger.log(Level.INFO, "No blog posts available.");
            return;
        }
        for (int i = 0; i < posts.size(); i++) {
            logger.log(Level.INFO, "Post {0}:\n{1}", new Object[]{i + 1, posts.get(i)});
        }
    }

    public void deletePost(int index) {
        if (index < 0 || index >= posts.size()) {
            logger.log(Level.WARNING, "Invalid post index.");
            return;
        }
        posts.remove(index);
        logger.log(Level.INFO, "Post deleted successfully!");
    }
}