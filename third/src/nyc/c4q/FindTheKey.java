package nyc.c4q;

import java.util.*;

public class FindTheKey {
    private static final int MAP_SIZE_RANGE = 3;
    private static final int SIZE_ONE = 5;
    private static final int SIZE_TWO = 2;
    private static final int SIZE_OF_ALPHABET = 26;
    private static final int ASCII_CAPITAL_A = 65;

    private final Map<String,Integer> keyValues;
    private final Random random = new Random();

    public FindTheKey(){
        keyValues = new HashMap<>();
        int mapSize = random.nextInt(MAP_SIZE_RANGE) + 1;
        for (int index = 0; index < mapSize; index++) {
            keyValues.put(randomString(), index);
        }
    }

    private String randomString() {
        int tempA = random.nextInt(SIZE_ONE) + SIZE_TWO;
        String value = "";
        for (int index = 0; index < tempA; index++){
            value += (char) (random.nextInt(SIZE_OF_ALPHABET) + ASCII_CAPITAL_A);
        }
        return value;
    }


    public List<String> listOfKeys(){
        Set<String> keys = keyValues.keySet();
        ArrayList<String> result = new ArrayList<>();
        for (String s : keys){
            result.add(s);
        }
        return result;
    }

    /**
     * Write code that will print all of the key value pairs in the map as follows:
     * Key: ####   Value: ****
     * Substituting the # and * with the key and value in map
     */
    public void printAllKeys() {
        List<String> keys = listOfKeys();
        for (String s : keys){
             System.out.println("Key: "+ s + "  Value: "+keyValues.get(s));
        }
    }
}
