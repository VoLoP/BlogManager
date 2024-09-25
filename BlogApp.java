import java.util.ArrayList;
import java.util.Scanner;

// Class representing a single blog post
class BlogPost {
    private String title;
    private String content;

    public BlogPost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nContent: " + content + "\n";
    }
}

// Class managing the list of blog posts
class Blog {
    private ArrayList<BlogPost> posts;

    public Blog() {
        posts = new ArrayList<>();
    }

    public void addPost(BlogPost post) {
        posts.add(post);
        System.out.println("Post added successfully!");
    }

    public void viewPosts() {
        if (posts.isEmpty()) {
            System.out.println("No blog posts available.");
            return;
        }
        for (int i = 0; i < posts.size(); i++) {
            System.out.println("Post " + (i + 1) + ":");
            System.out.println(posts.get(i));
        }
    }

    public void deletePost(int index) {
        if (index < 0 || index >= posts.size()) {
            System.out.println("Invalid post index.");
            return;
        }
        posts.remove(index);
        System.out.println("Post deleted successfully!");
    }
}

// Main class to run the blog application
public class BlogApp { }
