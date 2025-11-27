import java.io.*;

public class PasswordManager {
    private static final String FILE_NAME = "passwords.enc";

    public void addEntry(String site, String username, String password) throws Exception {
        String entry = site + "," + username + "," + password;
        String encrypted = EncryptionUtil.encrypt(entry);

        FileWriter fw = new FileWriter(FILE_NAME, true);
        fw.write(encrypted + "\n");
        fw.close();

        System.out.println("Password saved securely!");
    }

    public void viewEntries() throws Exception {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No saved passwords.");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;

        while ((line = br.readLine()) != null) {
            String decrypted = EncryptionUtil.decrypt(line);
            String[] parts = decrypted.split(",");

            System.out.println("Site: " + parts[0]);
            System.out.println("Username: " + parts[1]);
            System.out.println("Password: " + parts[2]);
            System.out.println("-------------------");
        }

        br.close();
    }
}
