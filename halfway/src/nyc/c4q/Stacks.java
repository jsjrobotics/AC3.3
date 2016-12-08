package nyc.c4q;

import java.util.Stack;

public class Stacks {

    public static int searchStack(String value, Stack<String> searchSpace){
        if (searchSpace.size() == 0){
            return 0;
        }
        String firstValue = searchSpace.pop();
        if (firstValue.equals(value)) {
            return 1 + searchStack(value, searchSpace);
        } else {
            return searchStack(value, searchSpace);
        }
    }

    public static int countNonValues(String value, Stack<String> searchSpace) {
        int count = searchSpace.size();
        while (searchSpace.size() > 0){
            if (searchSpace.peek().equals(value)){
                count--;
            }
            searchSpace.pop();
        }
        return count;
    }
}
