Project Structure
We will create several Java classes, each responsible for a specific part of the system:

Main.java: The main entry point of the application.

User.java: A class to represent a user, including user ID, password, profile information, and login state.

QuizSystem.java: A class to manage the overall quiz system, including login, logout, and managing sessions.

MCQ.java: A class to represent an MCQ question, including the question text, options, and the correct answer.

QuizSession.java: A class to handle a user's quiz session, including selecting answers, timing, and auto-submission.

Explanation

Main.java:

This is the main entry point of the program where the user interacts with the quiz system.
It handles user login, logout, profile updates, and starting quiz sessions.
It provides a simple menu-driven interface for navigation.

User.java:

Represents a user in the quiz system with a unique user ID, password, profile information, and login state.
Provides methods to get and set user information.

QuizSystem.java:

Manages the overall quiz system, including user authentication, password updates, and logout.
Stores users in a map for quick lookup by user ID.

MCQ.java:

Represents a multiple-choice question with a question text, options, and the correct answer index.
Provides methods to get question details.

QuizSession.java:

Handles a user's quiz session, including loading questions, selecting answers, timing, and auto-submission.
Uses a Timer to enforce a time limit on the quiz, automatically submitting the quiz when time is up.
