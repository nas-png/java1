import java.io.Console;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        final String correctUsername = "Nasrudin";
        final String correctPassword = "1of1";

        Scanner scanner = new Scanner(System.in);
        Console console = System.console(); 
        int attemptsLeft = 3;

        

        while (attemptsLeft > 0) {
            
            System.out.print("\nEnter Username: ");
            String username = scanner.nextLine();

            
            String password;
            if (console != null) {
                char[] passwordChars = console.readPassword("Enter Password: "); 
                password = new String(passwordChars);
            } else {
                
                System.out.print("Enter Password: ");
                password = scanner.nextLine();
            }

            
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("\nLogin Successful! Welcome, " + username + "!");
                return;
            } else {
                attemptsLeft--;
                System.out.println("Incorrect Username or Password. Attempts remaining: " + attemptsLeft);
            }
        }

        System.out.println("\nToo many failed attempts. Access denied.");
        scanner.close();
    }
}
