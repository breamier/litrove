
// import java.util.List;
import java.util.Scanner;

// Run this to test Book.java and fileIOManager.java
// We need a List that contains all existing / updated books (onf for books,podcast,etc.)
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What to do? add/delete/edit/exit: ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("add")) {
                String[] okay = { "A", "B", "C", "F", "finished", "5", "reflect" };
                FileIOManager.newLit("book", okay);

            } else if (choice.equalsIgnoreCase("delete")) {
                System.out.println("What to delete?");
                String toBeDeleted = scanner.nextLine();
                FileIOManager.deleteLit("book", toBeDeleted);
            } else if (choice.equalsIgnoreCase("edit")) {
                System.out.println("What to edit?");
                String toEdit = scanner.nextLine();
                System.out.println("What type to edit?");
                String descType = scanner.nextLine();
                System.out.println("What to replace:");
                String newDesc = scanner.nextLine();
                FileIOManager.editLit("book", toEdit, descType, newDesc);
            } else {
                break;
            }

        }

        // List<Literature> books = FileIOManager.readLit("books");

        // Show Books
        // for (Literature book : books) {
        // String everything = "";
        // for (String str : book.getDesc()) {
        // everything += str + "|";
        // }
        // everything = everything.substring(0, everything.length() - 1);
        // System.out.println(everything);
        // }

        // Show All Reflections
        // System.out.println("\n\nReflections List");
        // for (Literature book : books) {
        // System.out.println("\nReflection: " + book.description[6]);
        // }

        scanner.close();
    }
}
