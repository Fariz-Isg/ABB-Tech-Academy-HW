package HW10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        UserBackupService service = new UserBackupService();

        List<User> users = new ArrayList<>();
        users.add(new User("Aydin", "aydin@mail.com", 28));
        users.add(new User("Leyla", "leyla@mail.com", 24));
        users.add(new User("Ruslan", "ruslan@mail.com", 30));

        String dataFile = "src/HW10/users.dat";
        String backupDir = "backup";
        String backupFile = backupDir + "/users_backup.dat";

        System.out.println("=== User Data Backup System ===\n");

        service.saveUsers(users, dataFile);

        List<User> loadedUsers = service.loadUsers(dataFile);
        System.out.println("\nLoaded Users:");
        loadedUsers.forEach(System.out::println);

        service.backupFile(dataFile, backupDir);

        service.deleteBackup(backupFile);

        System.out.println("\n=== Process Completed ===");

    }
}
