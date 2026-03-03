import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        for (char c : cleanText.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return cleanText.equals(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        for (char c : cleanText.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

class PalindromeChecker {
    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String text) {
        return strategy.isPalindrome(text);
    }
}

public class PalindromeApp {
    public static void main(String[] args) {
        String test = "A man a plan a canal Panama";

        PalindromeChecker checker = new PalindromeChecker(new StackStrategy());
        System.out.println("StackStrategy: " + checker.check(test));

        checker.setStrategy(new DequeStrategy());
        System.out.println("DequeStrategy: " + checker.check(test));
    }
}