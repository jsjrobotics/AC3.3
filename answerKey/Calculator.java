package com.instruction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.instruction.Calculator.CalculatorOperation.*;

public class Calculator {

    public static void main(String[] args){
        CalculatorOperation input = readInstruction();
        print("Selected " + input.name());
        print("Enter a number for Argument 1: ");
        int argument1 = readInput();
        print("Argument 1: "+ argument1);
        print("Enter a number for Argument 2: ");
        int argument2 = readInput();
        print("Argument 2: "+ argument2);
        int result = runOperation(input, argument1, argument2);
        print("Result: " + result);
    }

    private static CalculatorOperation readInstruction() {
        CalculatorOperation operation = null;
        while( operation == null){
            print("Enter an operation. 1 -> Add, 2-> Subtract, 3 -> Multiply, 4 -> Divide");
            int input = readInput();
            if (input == 1){
                operation = ADD;
            } else if (input == 2){
                operation = SUBTRACT;
            } else if (input == 3){
                operation = MULTIPLY;
            } else if (input == 4){
                operation = DIVIDE;
            }
        }
        return operation;
    }

    private static void print(String output) {
        System.out.println(output);
    }

    private static int runOperation(CalculatorOperation input, int argument1, int argument2) {
        switch (input){
            case ADD:
                return argument1 + argument2;
            case SUBTRACT:
                return argument1 - argument2;
            case DIVIDE:
                return argument1 / argument2;
            case MULTIPLY:
                return argument1 * argument2;
            default:
                return 0;
        }
    }

    private static int readInput() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String value = input.readLine();
            return Integer.parseInt(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static enum CalculatorOperation {
        ADD,
        SUBTRACT,
        DIVIDE,
        MULTIPLY
    }
}
