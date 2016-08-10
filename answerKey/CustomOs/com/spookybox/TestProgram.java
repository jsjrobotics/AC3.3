package com.spookybox;

import java.util.Arrays;
import java.util.List;

public class TestProgram implements ICustomOs {

    int mCommandIndex = 0;
    private int mInspectedValue;

    List<SystemCommands> mProblem1 = Arrays.asList(
        SystemCommands.READ_INPUT,
        SystemCommands.READ_INPUT,
        SystemCommands.ADD,
        SystemCommands.PRINT,
        SystemCommands.END
    );
    private int mSavedValue;


    @Override
    public SystemCommands getNextCommand() {
        return problem2();
    }

    private SystemCommands problem1(){
        SystemCommands result = mProblem1.get(mCommandIndex);
        mCommandIndex++;
        return result;
    }

    private SystemCommands problem2(){
        mCommandIndex += 1;
        if(mCommandIndex < 3){
            return SystemCommands.READ_INPUT;
        } else if ( mCommandIndex == 3){
            return SystemCommands.ADD;
        } else if (mCommandIndex == 4 ){
            return SystemCommands.INSPECT;
        } else if (mCommandIndex == 5 ){
            mSavedValue = mInspectedValue;
            return SystemCommands.READ_INPUT;
        } else if (mCommandIndex == 6){
            return SystemCommands.MULTIPLY;
        } else if (mCommandIndex == 7){
            return SystemCommands.PRINT;
        } else if (mCommandIndex == 8){
            return SystemCommands.END;
        } else {
            throw new IllegalArgumentException("Invalid block");
        }
    }

    @Override
    public void inspectValue(int value) {
        mInspectedValue = value;
    }
}
