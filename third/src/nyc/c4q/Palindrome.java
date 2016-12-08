package nyc.c4q;

/**
 * Write a class that checks if a letter is a palidrome
 */
public class Palindrome {
    private final String input;
    private boolean isPalidrome;
    private boolean finishedCalculations;

    public Palindrome(String testString) {
        input = testString;
        isPalidrome = false;
        finishedCalculations = false;
    }

    public boolean isPalindrome() {
        if (!finishedCalculations) {
            isPalidrome = doPalindromeCheck();
            finishedCalculations = true;
        }
        return isPalidrome;
    }

    /**
     *
     * Write code to check whether the input field is a palidrome
     * A string is a palindrome if it remains unchanged when reversed
     *
     */
    private boolean doPalindromeCheck() {
        return false;
    }
}
