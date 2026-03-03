import java.util.Deque;
import java.util.ArrayDeque;
public class PalindromeApp {

    public static boolean isPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : text.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String str1 = "madam";
        String str2 = "hello";

        System.out.println(str1 + " -> " + isPalindrome(str1));
        System.out.println(str2 + " -> " + isPalindrome(str2));
    }
}