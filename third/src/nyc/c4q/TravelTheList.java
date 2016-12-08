package nyc.c4q;

import java.util.LinkedList;
import java.util.List;

public class TravelTheList {
    private LinkedList<String> stringList = new LinkedList<>();
    public TravelTheList(){
        stringList.add("Hello");
        stringList.add("Middle");
        stringList.add("Goodbye");
        stringList = expandList(0);
        stringList = expandList(stringList.size() -2);
        stringList = expandList(stringList.size() -1);
    }

    public TravelTheList(List<String> input){
        for (String s : input) {
            stringList.add(s);
        }
        for (int index = stringList.size(); index >= 1; index--){
            stringList = expandList(stringList.size() - index);
        }
    }

    private LinkedList<String> expandList(int startPoint) {
        LinkedList<String> result = new LinkedList<>();
        for (int index = 0; index < startPoint; index++){
            result.add(stringList.get(index));
        }
        String stringToExpand = stringList.get(startPoint);
        result.add(stringToExpand);
        for (int index = 0; index < stringToExpand.length(); index++){
            result.add("" + stringToExpand.charAt(index));
        }
        for (int index = startPoint+1; index < stringList.size(); index++){
            result.add(stringList.get(index));
        }
        return result;
    }

    public void printStringList(){
        for (String s : stringList){
            System.out.println(s);
        }
    }
}
