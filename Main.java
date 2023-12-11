import java.util.List;
import java.util.Scanner;

// Run this to test Book.java and fileIOManager.java
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What to do? add/delete/exit: ");
            String choice = scanner.nextLine();
            if (choice.equals("add")) {
                // Save a Book
                Book book = new Book();
                System.out.print("Title: ");
                book.setTitle(scanner.nextLine());
                System.out.print("Author: ");
                book.setAuthor(scanner.nextLine());
                System.out.print("Publisher: ");
                book.setPublisher(scanner.nextLine());
                System.out.print("Genre: ");
                book.setGenre(scanner.nextLine());
                FileIOManager.newBook(book);
            } else if (choice.equals("delete")) {
                System.out.println("What to delete?");
                String toBeDeleted = scanner.nextLine();
                FileIOManager.deleteBook(toBeDeleted);
            } else {
                break;
            }

        }

        // Read Books
        List<Book> books = FileIOManager.readBooks();
        for (Book b : books) {
            System.out.println(b.getTitle() + " by " + b.getAuthor());
        }
        scanner.close();
    }
}
