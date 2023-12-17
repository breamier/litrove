
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
                String[] okay = { "Breaking Stereotypes", "Be Me Podcast", "Aimee", "3", "Very Nice" };
                FileIOManager.newLit("podcast", okay);

            } else if (choice.equalsIgnoreCase("delete")) {
                System.out.println("What to delete?");
                String toBeDeleted = scanner.nextLine();
                FileIOManager.deleteLit("podcast", toBeDeleted);
            } else if (choice.equalsIgnoreCase("edit")) {
                System.out.println("What to edit?");
                String toEdit = scanner.nextLine();
                System.out.println("What type to edit?");
                String descType = scanner.nextLine();
                System.out.println("What to replace:");
                String newDesc = scanner.nextLine();
                FileIOManager.editLit("podcast", toEdit, descType, newDesc);
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
