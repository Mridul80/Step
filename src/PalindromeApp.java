public class PalindromeApp {

    public static void main(String[] args) {

        // Hardcoded string (String literal)
        String word = "madam";

        // Reverse the string
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}