/*DEMO USER :"user1", "1234"*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizSystem quizSystem = new QuizSystem();
        quizSystem.addUser("user1", "1234"); // Adding a demo user for testing

        System.out.println("Welcome to the Online Quiz System!");

        boolean sessionActive = true;
        while (sessionActive) {
            System.out.println("\n1. Login");
            System.out.println("2. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.next();
                    System.out.print("Enter Password: ");
                    String password = scanner.next();

                    User currentUser = quizSystem.authenticateUser(userId, password);

                    if (currentUser != null) {
                        System.out.println("Login successful!");
                        boolean userLoggedIn = true;
                        while (userLoggedIn) {
                            System.out.println("\nUser Menu:");
                            System.out.println("1. Update Profile and Password");
                            System.out.println("2. Start Quiz");
                            System.out.println("3. Logout");
                            System.out.print("Choose an option: ");
                            int userChoice = scanner.nextInt();

                            switch (userChoice) {
                                case 1:
                                    System.out.print("Enter new password: ");
                                    String newPassword = scanner.next();
                                    quizSystem.updatePassword(currentUser, newPassword);
                                    System.out.println("Password updated successfully.");
                                    break;
                                case 2:
                                    QuizSession quizSession = new QuizSession(currentUser);
                                    quizSession.startQuiz();
                                    break;
                                case 3:
                                    quizSystem.logout(currentUser);
                                    userLoggedIn = false;
                                    System.out.println("Logged out successfully.");
                                    break;
                                default:
                                    System.out.println("Invalid option. Please try again.");
                            }
                        }
                    } else {
                        System.out.println("Invalid User ID or Password.");
                    }
                    break;
                case 2:
                    sessionActive = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
