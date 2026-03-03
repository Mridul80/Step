import java.util.Scanner;

public class PalindromeApp {
    public static boolean isPalindrome(String str) {
        String normalizedStr = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = normalizedStr.length() - 1;

        while (left < right) {
            if (normalizedStr.charAt(left) != normalizedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check palindrome:");
        String input = sc.nextLine();
        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome (case-insensitive & space-ignored).");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }
        sc.close();
    }
}