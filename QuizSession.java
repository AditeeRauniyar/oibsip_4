import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizSession {
    private User user;
    private List<MCQ> mcqs;
    private int[] userAnswers;
    private boolean quizCompleted;

    public QuizSession(User user) {
        this.user = user;
        this.mcqs = new ArrayList<>();
        this.userAnswers = new int[5]; // Assuming 5 questions for simplicity
        this.quizCompleted = false;
        loadQuestions();
    }

    private void loadQuestions() {
        mcqs.add(new MCQ("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Madrid"}, 0));
        mcqs.add(new MCQ("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 1));
        mcqs.add(new MCQ("What is the color of the sky?", new String[]{"Blue", "Green", "Red", "Yellow"}, 0));
        mcqs.add(new MCQ("What is the boiling point of water?", new String[]{"90C", "100C", "110C", "120C"}, 1));
        mcqs.add(new MCQ("What is the largest planet in the Solar System?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 2));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!quizCompleted) {
                    quizCompleted = true;
                    System.out.println("\nTime's up! Auto-submitting the quiz...");
                    submitQuiz();
                }
            }
        }, 30000); // 30 seconds timer for quiz

        for (int i = 0; i < mcqs.size(); i++) {
            MCQ mcq = mcqs.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + mcq.getQuestion());
            String[] options = mcq.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }
            System.out.print("Your answer: ");
            int answer = scanner.nextInt();
            userAnswers[i] = answer - 1;
            if (quizCompleted) break;
        }

        if (!quizCompleted) {
            quizCompleted = true;
            submitQuiz();
            timer.cancel();
        }
    }

    private void submitQuiz() {
        int correctCount = 0;
        for (int i = 0; i < mcqs.size(); i++) {
            if (userAnswers[i] == mcqs.get(i).getCorrectAnswerIndex()) {
                correctCount++;
            }
        }
        System.out.println("Quiz completed! You got " + correctCount + " out of " + mcqs.size() + " correct.");
    }
}

