
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
  
    public String getUsername() {
        String username=null;
        return username;
    }
    public String getPassword() {
        String password = null;
        return password;
    }
    public String getPhoneNumber() {
        String phoneNumber = null;
        return phoneNumber;
    }

    private static class phoneNumber {

        public phoneNumber() {
        }
    }
}
class UserRepository {
    private final User[] users;
    private int userCount;
    public UserRepository(int capacity) {
        users = new User[capacity];
        userCount = 0;
    }
    public void registerUser(String username, String password, String phoneNumber) {
        if (userCount < users.length) {
            if (isValidPhoneNumber(phoneNumber)
                    && validateUsername(username).equals("Username successfully captured")
                    && validatePassword(password).equals("Password successfully captured")) {
                users[userCount] = new User(username, password, phoneNumber);
                userCount++;
                System.out.println("User registered successfully!");
            } else {
                System.out.println(validateUsername(username));
                System.out.println(validatePassword(password));
            }
        } else {
            System.out.println("User repository is full!");
        }
    }
    public boolean loginUser(String username, String password) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
                System.out.println("Login successful!");
                return true;
            }
        }
        System.out.println("Invalid username or password!");
        return false;
    }
    private boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10 && phoneNumber.startsWith("0")) {
            if (phoneNumber.startsWith("06") || phoneNumber.startsWith("07")
                    || phoneNumber.startsWith("08") || phoneNumber.startsWith("09")) {
                return true;
            }
        }
        if (phoneNumber.length() == 13 && phoneNumber.startsWith("+27")) {
            if (phoneNumber.startsWith("+276") || phoneNumber.startsWith("+277")
                    || phoneNumber.startsWith("+278") || phoneNumber.startsWith("+279")) {
                return true;
            }
        }
        return false;
    }
    public static String validateUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return "Username successfully captured";
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length";
        }
    }
    public static String validatePassword(String password) {
        if (password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*\\d.*")
                && password.matches(".*[^A-Za-z0-9].*")) {
            return "Password successfully captured";
        } else {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character";
        }
    }
}




