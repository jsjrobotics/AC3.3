package com.spookybox;

public class Main {

    public static void main(String[] args) {
        ICustomOs program = new TestProgram();
        CustomOsStateMachine.executeProgram(program);
    }


}
