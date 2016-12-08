package nyc.c4q;

import java.util.ArrayList;
import java.util.List;

public class ConstructorChallenge {
    int result = 0;

    public ConstructorChallenge(int value){
        result = value;
    }

    public ConstructorChallenge(String value){
        result = Integer.valueOf(value);
    }

    public ConstructorChallenge(List<Integer> values) {
        for (int index = 0; index < values.size(); index++){
            result += values.get(index);
        }
    }

    public ConstructorChallenge increment(){
        return new ConstructorChallenge(result+1);
    }

    public static void function1(){
        ConstructorChallenge result = new ConstructorChallenge(9);
        System.out.println(result.result);
    }

    public static void function2(){
        ConstructorChallenge result = new ConstructorChallenge("1943");
        System.out.println(result.result);
    }
    public static void function3(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        ConstructorChallenge result = new ConstructorChallenge(list);
        System.out.println(result.result);
    }

    public static void function4(){
        ConstructorChallenge temp = new ConstructorChallenge("1000");
        ConstructorChallenge result = temp.increment();
        System.out.println(result.result);
    }
}
