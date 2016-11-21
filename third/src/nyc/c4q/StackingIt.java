package nyc.c4q;

import java.util.ArrayList;
import java.util.Stack;

public class StackingIt {
    private Stack<Integer> stack = new Stack<>();

    public StackingIt(String input){
        for (char c : input.toCharArray()){
            stack.push((int) c);
        }
    }

    public void popThenAdd(){
        while (stack.size() > 2){
            int value1 = stack.pop();
            int value2 = stack.pop();
            stack.push(value1+value2);
        }
    }

    public void popThenAppend(){
        while (stack.size() != 1){
            int value1 = stack.pop();
            int value2 = stack.pop();
            String result = value1 + "" + value2;
            stack.push(Integer.valueOf(result));
        }
    }

    public void printStack(){
        ArrayList<Integer> output = new ArrayList<>();
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }
        for (int index = output.size()-1; index >= 0; index--){
            System.out.println(output.get(index));
        }
    }


}
