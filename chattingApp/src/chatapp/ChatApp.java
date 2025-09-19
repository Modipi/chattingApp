package chatapp;

import java.util.Scanner;

public class ChatApp {
    private Login loginSystem;
    
    public ChatApp() {
        this.loginSystem = new Login();
    }
    
    public static void main(String[] args) {
        ChatApp app = new ChatApp();
        app.run();
    }
    
    public void run() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Welcome to ChatApp Registration ===");
        
        // Get user details
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter username (must contain underscore and be ≤5 characters): ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password (must be ≥8 characters with capital, number, and special character): ");
        String password = scanner.nextLine();
        
        System.out.print("Enter South African cell phone number (with international code, e.g., +27838968976): ");
        String cellPhone = scanner.nextLine();
        
        // Register user
        String registrationResult = loginSystem.registerUser(firstName, lastName, username, password, cellPhone);
        System.out.println(registrationResult);
        
        // If registration was successful, proceed to login
        if (registrationResult.equals("User registered successfully.")) {
            System.out.println("\n=== ChatApp Login ===");
            
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();
            
            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();
            
            // Attempt login
            String loginResult = loginSystem.returnLoginStatus(loginUsername, loginPassword);
            System.out.println(loginResult);
            
            // If login successful, show chat interface
            if (loginResult.startsWith("Welcome")) {
                showChatInterface(scanner);
            }
        }
        
        scanner.close();
    }
    
    private void showChatInterface(Scanner scanner) {
        System.out.println("\n=== ChatApp Interface ===");
        System.out.println("Welcome to your chat dashboard, " + loginSystem.getFullName() + "!");
        System.out.println("Type 'exit' to quit the application.");
        
        while (true) {
            System.out.print("\nEnter your message: ");
            String message = scanner.nextLine();
            
            if (message.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye! Thank you for using ChatApp.");
                break;
            }
            
            // Simulate receiving a message
            System.out.println("You: " + message);
            System.out.println("System: Message sent successfully!");
        }
    }
}