import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIOManager {
    private static final String PATH_FOLDER = "Literature/";
    private static final String PATH_BOOKS = PATH_FOLDER + "books.txt";

    // Adds a new book to the file
    public static void newBook(Book book) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PATH_BOOKS, true))) {
            writer.println(
                    book.getTitle() + "," + book.getAuthor() + "," + book.getPublisher() + "," + book.getGenre());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Returns the list of books
    public static List<Book> readBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_BOOKS))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Book book = new Book();
                book.setTitle(parts[0]);
                book.setAuthor(parts[1]);
                book.setPublisher(parts[2]);
                book.setGenre(parts[3]);
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Deletes book when given the title
    public static void deleteBook(String title) {
        List<Book> books = readBooks();
        List<Book> updateBooks = new ArrayList<>();

        for (Book book : books) {
            if (!book.getTitle().equalsIgnoreCase(title)) {
                updateBooks.add(book);
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(PATH_BOOKS))) {
            for (Book book : updateBooks) {
                writer.println(
                        book.getTitle() + "," + book.getAuthor() + "," + book.getPublisher() + "," + book.getGenre());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
