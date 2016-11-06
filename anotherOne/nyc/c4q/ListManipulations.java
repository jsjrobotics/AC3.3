package nyc.c4q;

public class ListManipulations {
    private int[] mColors = { 5, 10, 15, 20 };
    private int[] mStates = { 40, 50, 60, 70 };
    private int[] mTables = { 1, 2, 3, 4 };

    public static void main(String[] args) {
        new ListManipulations().problem3();
        new ListManipulations().problem4();
    }

    public void problem1(){
        for ( int index1 = 0; index1 < mTables.length; index1++) {
            for ( int index2 = 0; index2 < mColors.length; index2++) {
                System.out.println( mColors[index1] + ":" + mTables[index2]);
            }
        }
    }

    public void problem2(){
        int index1 = 0;
        int index2 = 1;
        while (mStates.length > index1) {
            System.out.println(mStates[index1]);
            index1 += index2;
            index2 += 1;
        }
    }

    public void problem3(){
        for (int index = 0; index < 3; index+=2) {
            System.out.println(mColors[index]);
        }
    }

    public void problem4(){
        int[] d1 = new int[3];
        for (int index = 0; index < d1.length; index++) {
            d1[index] = mStates[index];
        }

        int[] d2 = new int[4];
        for (int index = 0; index < d2.length; index++) {
            d2[index] = mColors[index];
        }

        for (int index = 0; index < d1.length; index++) {
            System.out.println(d2[index]);
            System.out.println(d1[index]);
        }

    }
}
