package nyc.c4q;

public class StateMachine {

    public enum INPUT {
        TURN_KEY,
        SHIFT_UP,
        SHIFT_DOWN,
        NONE
    }

    public enum STATES {
        OFF,
        IGNITION_TURNED,
        ENGINE_STARTING,
        ENGINE_IDLE,
        FIRST_GEAR,
        SECOND_GEAR,
        REVERSE,
        ENGINE_STOPPING
    }

    public static STATES getNextState(STATES currentState) {
        switch (currentState) {
            case OFF:
                break;
            case IGNITION_TURNED:
                return STATES.ENGINE_STARTING;
            case ENGINE_STARTING:
                return STATES.ENGINE_IDLE;
            case ENGINE_IDLE:
                return STATES.FIRST_GEAR;
            case FIRST_GEAR:
                return STATES.FIRST_GEAR;
            case SECOND_GEAR:
                return STATES.SECOND_GEAR;
            case REVERSE:
                return STATES.REVERSE;
            case ENGINE_STOPPING:
                break;
            default:
                throw new IllegalArgumentException("invalid state reached");
        }
        return STATES.OFF;
    }

    public static void handleState(STATES currentState) {
        switch (currentState) {
            case OFF:
                break;
            case IGNITION_TURNED:
                System.out.println("Ignition");
                break;
            case ENGINE_STARTING:
                System.out.println("Starting");
                break;
            case ENGINE_IDLE:
                System.out.println("Idle");
                break;
            case FIRST_GEAR:
                System.out.println("1st");
                break;
            case SECOND_GEAR:
                System.out.println("2nd");
                break;
            case REVERSE:
                System.out.println("Reversing");
                break;
            case ENGINE_STOPPING:
                System.out.println("Stopping");
        }
    }

    public void run(STATES initialState, INPUT[] inputList){
        STATES currentState = initialState;
        for (int index = 0; index < inputList.length; index++) {
            STATES nextState = getNextState(currentState);
            nextState = handleInput(currentState, nextState, inputList[index]);
            handleState(currentState);
            currentState = nextState;
        }
    }

    private STATES handleInput(STATES currentState, STATES nextState, INPUT input) {
        if (currentState == STATES.OFF && input == INPUT.TURN_KEY){
            return STATES.IGNITION_TURNED;
        } else if (currentState == STATES.IGNITION_TURNED && input != INPUT.NONE){
            return STATES.IGNITION_TURNED;
        } else if (currentState == STATES.FIRST_GEAR && input == INPUT.TURN_KEY){
            return STATES.ENGINE_STOPPING;
        } else if (currentState == STATES.FIRST_GEAR && input == INPUT.SHIFT_DOWN){
            return STATES.REVERSE;
        } else if (currentState == STATES.FIRST_GEAR && input == INPUT.SHIFT_UP){
            return STATES.SECOND_GEAR;
        }  else if (currentState == STATES.SECOND_GEAR && input == INPUT.TURN_KEY){
            return STATES.ENGINE_STOPPING;
        } else if (currentState == STATES.SECOND_GEAR && input == INPUT.SHIFT_DOWN){
            return STATES.FIRST_GEAR;
        } else if (currentState == STATES.REVERSE && input == INPUT.TURN_KEY){
            return STATES.ENGINE_STOPPING;
        } else if (currentState == STATES.REVERSE && input == INPUT.SHIFT_UP){
            return STATES.FIRST_GEAR;
        }
        return nextState;
    }

    public static void main(String[] args) {

        INPUT[] input = problem1();
        new StateMachine().run(StateMachine.STATES.OFF, input);
    }

    private static INPUT[] problem1() {
        return new INPUT[]{
                INPUT.NONE,
                INPUT.NONE,
                INPUT.TURN_KEY,
                INPUT.NONE,
                INPUT.NONE,
                INPUT.NONE,
                INPUT.TURN_KEY,
                INPUT.NONE,
        };
    }

    private static INPUT[] problem2() {
        return new INPUT[]{
                INPUT.TURN_KEY,
                INPUT.SHIFT_DOWN,
                INPUT.SHIFT_UP,
                INPUT.TURN_KEY,
                INPUT.NONE,
        };
    }

    private static INPUT[] problem3() {
        return new INPUT[]{
                INPUT.TURN_KEY,
                INPUT.NONE,
                INPUT.SHIFT_DOWN,
                INPUT.SHIFT_UP,
                INPUT.TURN_KEY,
                INPUT.NONE,
        };
    }

    private static INPUT[] problem4() {
        return new INPUT[]{
                INPUT.TURN_KEY,
                INPUT.NONE,
                INPUT.NONE,
                INPUT.SHIFT_DOWN,
                INPUT.NONE,
                INPUT.NONE,
                INPUT.SHIFT_UP,
                INPUT.TURN_KEY,
                INPUT.NONE,
        };
    }

}
