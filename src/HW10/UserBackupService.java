package HW10;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class UserBackupService {

    public void saveUsers(List<User> users, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(users);
            System.out.println("Users saved successfully to " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving users: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<User> loadUsers(String filePath) {
        List<User> users = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            users = (List<User>) ois.readObject();
            System.out.println("Users loaded successfully from " + filePath);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found during deserialization: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error loading users: " + e.getMessage());
            e.printStackTrace();
        }

        return users;
    }

    public void backupFile(String sourceFile, String backupDir) {
        try {
            Path backupDirPath = Paths.get(backupDir);
            if (!Files.exists(backupDirPath)) {
                Files.createDirectories(backupDirPath);
            }

            Path sourcePath = Paths.get(sourceFile);
            Path destPath = Paths.get(backupDir, sourcePath.getFileName().toString().replace(".dat", "_backup.dat"));

            Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Backup created at " + destPath);

        } catch (InvalidPathException e) {
            System.err.println("Invalid path: " + e.getMessage());
        } catch (NoSuchFileException e) {
            System.err.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error creating backup: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteBackup(String backupFilePath) {
        try {
            Path path = Paths.get(backupFilePath);

            if (Files.exists(path)) {
                Files.delete(path);
                System.out.println("Backup file deleted successfully: " + backupFilePath);
            } else {
                System.out.println("Backup file does not exist: " + backupFilePath);
            }

        } catch (InvalidPathException e) {
            System.err.println("Invalid path: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error deleting backup: " + e.getMessage());
            e.printStackTrace();
        }
    }
}