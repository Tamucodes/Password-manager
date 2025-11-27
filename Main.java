import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        PasswordManager manager = new PasswordManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== PASSWORD MANAGER =====");
            System.out.println("1. Add Password");
            System.out.println("2. View Passwords");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // to clear buffer

            if (choice == 1) {
                System.out.print("Site/App Name: ");
                String site = sc.nextLine();

                System.out.print("Username: ");
                String username = sc.nextLine();

                System.out.print("Password: ");
                String password = sc.nextLine();

                manager.addEntry(site, username, password);
            } 
            else if (choice == 2) {
                manager.viewEntries();
            }
            else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } 
            else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
