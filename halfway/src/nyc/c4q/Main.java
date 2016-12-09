package nyc.c4q;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public ArrayList<String> printList(ArrayList<String> input){
        ArrayList<String> result = new ArrayList<>();
        int index = 0;
        while (!input.isEmpty()){
            System.out.println(input.get(index));
            index++;
        }
        return result;
    }
}
