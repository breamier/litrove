import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIOManager {
    private static final String PATH_FOLDER = "Literature/";

    // Adds a new book to the file
    public static void newLit(String litType, String[] data) {
        Literature lit = Literature.generateLitObject(litType, data);
        String line = "";
        for (String str : lit.getDesc()) {
            line += str.replace("\n", " ") + "|";
        }
        line = line.substring(0, line.length() - 1);

        try (PrintWriter writer = new PrintWriter(new FileWriter(PATH_FOLDER + litType + ".txt", true))) {
            writer.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Returns the list of books
    public static List<Literature> readLit(String litType) {
        List<Literature> literature = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_FOLDER + litType + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                Literature lit = Literature.generateLitObject(litType, parts);
                literature.add(lit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return literature;
    }

    // Deletes book when given the title
    public static void deleteLit(String litType, String title) {
        List<Literature> litList = readLit(litType);
        List<Literature> updateLit = new ArrayList<>();

        for (Literature literature : litList) {
            if (!literature.description[0].equalsIgnoreCase(title)) {
                updateLit.add(literature);
            }
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(PATH_FOLDER + litType + ".txt"))) {
            for (Literature literature : updateLit) {
                newLit(litType, literature.description);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editLit(String litType, String oldTitle, String descType, String newDesc) {
        List<Literature> litList = readLit(litType);

        for (Literature literature : litList) {
            if (literature.description[0].equalsIgnoreCase(oldTitle)) {
                literature.setDesc(descType, newDesc);
                break;
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(PATH_FOLDER + litType + ".txt"))) {
            for (Literature literature : litList) {
                newLit(litType, literature.description);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Literature searchLit(String litType, String title) {
        List<Literature> litList = readLit(litType);

        for (Literature literature : litList) {
            if (literature.description[0].equalsIgnoreCase(title)) {
                return literature;
            }
        }
        return null;
    }

}
