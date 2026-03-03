import java.util.Stack;
import java.util.Scanner;
class PalindromeChecker {
    private Stack<Character> charStack;

    public PalindromeChecker(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        charStack = new Stack<>();
        for (char c : normalized.toCharArray()) {
            charStack.push(c);
        }
    }
    public boolean checkPalindrome() {
        Stack<Character> tempStack = (Stack<Character>) charStack.clone();
        StringBuilder reversed = new StringBuilder();

        while (!tempStack.isEmpty()) {
            reversed.append(tempStack.pop());
        }

        StringBuilder original = new StringBuilder();
        for (char c : charStack) {
            original.append(c);
        }

        return original.toString().equals(reversed.toString());
    }
}
public class PalindromeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker(input);

        if (checker.checkPalindrome()) {
            System.out.println("The string is a palindrome!");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }
        scanner.close();
    }
}