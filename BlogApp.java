import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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

// Main class to run the blog application
public class BlogApp {
    private static Blog blog = new Blog();
    private static final Logger logger = Logger.getLogger(BlogApp.class.getName());

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            do {
                displayMenu();
                choice = getUserChoice(scanner);

                switch (choice) {
                    case 1:
                        addBlogPost(scanner);
                        break;
                    case 2:
                        blog.viewPosts();
                        break;
                    case 3:
                        deleteBlogPost(scanner);
                        break;
                    case 4:
                        logger.log(Level.INFO, "Exiting the application.");
                        break;
                    default:
                        logger.log(Level.WARNING, "Invalid choice. Please try again.");
                }
            } while (choice != 4);
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add Blog Post");
        System.out.println("2. View Blog Posts");
        System.out.println("3. Delete Blog Post");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice(Scanner scanner) {
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            logger.log(Level.WARNING, "Invalid input. Please enter a number.");
        } finally {
            scanner.nextLine(); // Consume newline
        }
        return choice;
    }

    private static void addBlogPost(Scanner scanner) {
        System.out.print("Enter post title: ");
        String title = scanner.nextLine();
        System.out.print("Enter post content: ");
        String content = scanner.nextLine();
        BlogPost post = new BlogPost(title, content);
        blog.addPost(post);
    }

    private static void deleteBlogPost(Scanner scanner) {
        System.out.print("Enter post number to delete: ");
        try {
            int postNumber = scanner.nextInt();
            blog.deletePost(postNumber - 1); // Convert to zero-based index
        } catch (InputMismatchException e) {
            logger.log(Level.WARNING, "Invalid input. Please enter a valid post number.");
        } finally {
            scanner.nextLine(); // Consume newline
        }
    }
}