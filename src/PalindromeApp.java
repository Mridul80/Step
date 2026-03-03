import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class PalindromeApp {

    public static void main(String[] args) {

        String input = "LEVEL";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            queue.add(ch);
            stack.push(ch);
        }
        System.out.println("Input String: " + input);
        System.out.println("\nComparing Dequeue (Queue) and Pop (Stack):");

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            char fromQueue = queue.remove();
            char fromStack = stack.pop();

            System.out.println("Queue: " + fromQueue +
                    " | Stack: " + fromStack);

            if (fromQueue != fromStack) {
                isPalindrome = false;
            }
        }
        if (isPalindrome) {
            System.out.println("\nResult: It is a Palindrome.");
        } else {
            System.out.println("\nResult: It is NOT a Palindrome.");
        }
    }
}