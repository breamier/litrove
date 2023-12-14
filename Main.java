import java.util.List;
import java.util.Scanner;

// Run this to test Book.java and fileIOManager.java
// We need a List that contains all existing / updated books (onf for books,podcast,etc.)
public class Main {
    
    List<Literature> books = FileIOManager.readLiterature("Books");
    List<Literature> podcast = Fil
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What to do? add/delete/exit: ");
            String choice = scanner.nextLine();
            if (choice.equals("add")) {
                String[] okay = {  "Title","Author","Publisher","Genres","Status","Rating","Reflection"};
                FileIOManager.newBook(okay);
                //books = readBooks()

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
            String everything="";
            for(String str:book.desc){
                everything+=str+"|";
            }
            everything = everything.substring(0,everything.length()-1);
        System.out.println(everything);
        }

        // Show All Reflections
        System.out.println("\n\nReflections List");
        for (Book book : books) {
            System.out.println("\nReflection: " + book.description[6]);
        }

        scanner.close();
    }
}
