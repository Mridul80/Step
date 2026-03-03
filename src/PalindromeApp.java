import java.util.Scanner;

public class PalindromeApp {

    public static boolean isPalindromeReverse(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static boolean isPalindromeTwoPointer(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String str) {
        return isPalindromeRecursiveHelper(str, 0, str.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String str, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        return isPalindromeRecursiveHelper(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check palindrome: ");
        String input = scanner.nextLine();

        long start = System.nanoTime();
        boolean resultReverse = isPalindromeReverse(input);
        long end = System.nanoTime();
        long timeReverse = end - start;
        System.out.println("Reverse Method: " + resultReverse + " | Time: " + timeReverse + " ns");

        start = System.nanoTime();
        boolean resultTwoPointer = isPalindromeTwoPointer(input);
        end = System.nanoTime();
        long timeTwoPointer = end - start;
        System.out.println("Two-Pointer Method: " + resultTwoPointer + " | Time: " + timeTwoPointer + " ns");

        start = System.nanoTime();
        boolean resultRecursive = isPalindromeRecursive(input);
        end = System.nanoTime();
        long timeRecursive = end - start;
        System.out.println("Recursive Method: " + resultRecursive + " | Time: " + timeRecursive + " ns");
    }
}