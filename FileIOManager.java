import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIOManager {
    private static final String PATH_FOLDER = "Literature/";
    private static final String PATH_BOOKS = PATH_FOLDER + "books.txt";

    // Adds a new book to the file
    // Piage will also pass the literature type in stirng 
    public static void newBook(String[] bookData) { // its gonna be litData bc not only book
        String everything="";
        for(String str:bookData){
            everything+=str+"|";
        }
        everything = everything.substring(0,everything.length()-1);

        try (PrintWriter writer = new PrintWriter(new FileWriter(PATH_BOOKS, true))) {
            writer.println(everything);
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
                String[] parts = line.split("\\|");
                Book book = new Book(parts);
                // Literature lit = lit.generateLiteratureObject(parts);

                // book.setTitle(parts[0]);
                // book.setAuthor(parts[1]);
                // book.setPublisher(parts[2]);
                // book.setGenre(parts[3]);
                // book.setStatus(parts[4]);
                // book.setRating(parts[5]);
                // book.setReflection(parts[6]);
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
            if (!book.description[0].equalsIgnoreCase(title)) {
                updateBooks.add(book);
            }
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(PATH_BOOKS))) {
            for (Book book : updateBooks) {
                newBook(book.description);
            }    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Insert editBook(String oldName, String[] newDesc )
}
