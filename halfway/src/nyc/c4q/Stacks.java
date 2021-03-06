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

    public static Stack<String> buildStack(){
        Stack<String> input = new Stack<>();
        for (int index = 0; index < 10; index++) {
            input.add("a");
        }
        for (int index = 0; index < 5; index++) {
            input.add("b");
        }
        for (int index = 0; index < 0; index++) {
            input.add("c");
        }
        return input;
    }

}
