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
                String bookTitle = scanner.nextLine();
                book.setTitle(bookTitle);
                System.out.print("Author: ");
                book.setAuthor(scanner.nextLine());
                System.out.print("Publisher: ");
                book.setPublisher(scanner.nextLine());
                System.out.print("Genre: ");
                book.setGenre(scanner.nextLine());
                System.out.print("Status: ");
                book.setStatus(scanner.nextLine());
                System.out.print("Rating: ");
                book.setRating(scanner.nextLine());
                System.out.print("Reflection: ");
                book.setReflection(scanner.nextLine());
                FileIOManager.newBook(book);

            } else if (choice.equals("delete")) {
                System.out.println("What to delete?");
                String toBeDeleted = scanner.nextLine();
                FileIOManager.deleteBook(toBeDeleted);
            } else {
                break;
            }

        }

        List<Book> books = FileIOManager.readBooks();

        // Show Books
        for (Book book : books) {
        System.out.println("Title: " + book.getTitle() + "\nAuthor: " +
        book.getAuthor() + "\nPublisher:"
        + book.getPublisher() + "\nGenre:" + book.getGenre() + "\nStatus: " +
        book.getStatus()
        + "\nRating: " + book.getRating() + "\nReflection: " + book.getReflection());
        }

        // Show All Reflections
        System.out.println("\n\nReflections List");
        for (Book book : books) {
            System.out.println("\nReflection: " + book.getReflection());
        }

        scanner.close();
    }
}
