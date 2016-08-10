package com.spookybox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CustomOsStateMachine {
    private Stack<Integer> mMemory = new Stack<>();

    public CustomOsStateMachine(){
        mMemory.push(0);
        mMemory.push(0);
    }

    public void execute(SystemCommands nextCommand) {
        switch (nextCommand){
            case PRINT:
                System.out.println(mMemory.peek());
                break;
            case ADD:
                int a = mMemory.pop();
                int b = mMemory.pop();
                mMemory.push(0);
                mMemory.push(a + b);
                break;
            case MULTIPLY:
                int c = mMemory.pop();
                int d = mMemory.pop();
                mMemory.push(0);
                mMemory.push(c * d);
                break;
            case READ_INPUT:
                int e = mMemory.pop();
                int discarded = mMemory.pop();
                mMemory.push(e);
                mMemory.push(readInput());
                break;
        }
    }

    private Integer readInput() {
        Integer result = null;
        while (result == null) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a number [0 - 9]: ");
            try {
                String value = input.readLine();
                result = Integer.parseInt(value);
                if(result < 0 || result > 9){
                    result = null;
                }
            } catch (IOException e) {
                System.out.println("Invalid int entered");
            }
        }
        return result;
    }

    public int inspect() {
        return mMemory.peek();
    }

    public static void executeProgram(ICustomOs program){
        CustomOsStateMachine stateMachine = new CustomOsStateMachine();
        SystemCommands nextCommand;
        do{
            nextCommand = program.getNextCommand();
            switch (nextCommand){
                case INSPECT:
                    program.inspectValue(stateMachine.inspect());
                    break;
                case END:
                    break;
                default:
                    stateMachine.execute(nextCommand);
            }
        } while( nextCommand != SystemCommands.END);

    }
}
