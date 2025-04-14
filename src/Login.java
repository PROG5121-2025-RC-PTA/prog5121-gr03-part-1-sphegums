/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */

    

 public class Login {
    private String username;
    private String password;
    private String phoneNumber;
 
    public Login(String username, String password, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    Login() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean checkUsername() {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        boolean hasCapital = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkCellPhoneNumber() {
        if (phoneNumber.matches("^\\+\\d{1,4}\\d{1,10}$")) {
            String localPart = phoneNumber.replaceFirst("^\\+\\d{1,4}", "");
            return localPart.length() <= 10;
        }
        return false;
    }

    public String registerUser() {
        if (checkUsername() && checkPasswordComplexity() && checkCellPhoneNumber()) {
            return "User registered successfully!";
        } else {
            return "User registration failed. Please check username, password, or phone number.";
        }
    }

    public boolean loginUser() {
        return checkUsername() && checkPasswordComplexity();
    }

    public String returnLoginStatus() {
        if (loginUser()) {
            return "Welcome " + username + ", it is great to see you again.";
        } else {
            StringBuilder errorMessage = new StringBuilder("Login failed due to:\n");
            if (!checkUsername()) {
                errorMessage.append("- Invalid username (must contain '_' and max 5 characters)\n");
            }
            if (!checkPasswordComplexity()) {
                errorMessage.append("- Invalid password (min 8 chars, must include uppercase, number, special char)\n");
            }
            return errorMessage.toString();
        }
    
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    void pack() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setLocationRelativeTo(Login LoginFrame) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
