package nyc.c4q;

import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        question4();
    }

    public static void question3(){
        StackingIt s = new StackingIt("AAA");
        s.popThenAdd();
        s.popThenAppend();
        s.printStack();
    }

    public static void question4(){
        List<String> test = Arrays.asList("Hello", "Middle", "Go");
        new TravelTheList(test).printStringList();
    }

    public static void question6() {
        Palindrome p = new Palindrome("test");
        p.isPalindrome();
        p.isPalindrome();
        p = new Palindrome("help");
        p = new Palindrome("done");
        p.isPalindrome();
    }
}
