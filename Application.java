import java.util.Scanner;

public class Application{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Yehey! You've successfully ran the application!");
        System.out.println("What's your name? ");
        String name = scanner.nextLine();
        System.out.println("Nice job, " + name);
    }
}