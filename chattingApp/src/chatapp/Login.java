package chatapp;

public class Login {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhone;

    public Login() {
        // Constructor
    }

    public String registerUser(String firstName, String lastName, String username, String password, String cellPhone) {
        // Check username
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        if (!checkCellPhone(cellPhone)) {
            return "Cell phone number is not correctly formatted, please ensure it is a valid South African number.";
        }

        // If all checks pass, set the user details and return success.
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;

        return "User registered successfully.";
    }

    public String returnLoginStatus(String loginUsername, String loginPassword) {
        if (loginUsername.equals(username) && loginPassword.equals(password)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    private boolean checkUserName(String username) {
        // Check if username contains '_' and length <= 5
        return username.contains("_") && username.length() <= 5;
    }

    private boolean checkPasswordComplexity(String password) {
        // Check length >= 8
        if (password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        return hasCapital && hasDigit && hasSpecial;
    }

    private boolean checkCellPhone(String cellPhone) {
        // Check if it starts with "+27" and then has 9 digits (so total 12 characters)
        if (cellPhone.length() != 12 || !cellPhone.startsWith("+27")) {
            return false;
        }

        // Check the remaining 9 characters are digits
        String digits = cellPhone.substring(3);
        for (char c : digits.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
    
    // Getter methods for user information
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
}