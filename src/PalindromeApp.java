public class PalindromeApp {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node stringToLinkedList(String s) {
        if (s == null || s.isEmpty()) return null;
        Node head = new Node(s.charAt(0));
        Node current = head;
        for (int i = 1; i < s.length(); i++) {
            current.next = new Node(s.charAt(i));
            current = current.next;
        }
        return head;
    }
    static Node findMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    static boolean compareLists(Node head1, Node head2) {
        while (head2 != null) {
            if (head1.data != head2.data) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node mid = findMiddle(head);

        Node secondHalfReversed = reverseList(mid);

        boolean result = compareLists(head, secondHalfReversed);

        reverseList(secondHalfReversed);

        return result;
    }
    public static void main(String[] args) {
        String s1 = "racecar";
        Node head1 = stringToLinkedList(s1);
        System.out.println(s1 + " -> Is palindrome? " + isPalindrome(head1));

        String s2 = "hello";
        Node head2 = stringToLinkedList(s2);
        System.out.println(s2 + " -> Is palindrome? " + isPalindrome(head2));

        String s3 = "acca";
        Node head3 = stringToLinkedList(s3);
        System.out.println(s3 + " -> Is palindrome? " + isPalindrome(head3));
    }
}