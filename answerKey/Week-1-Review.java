public class Main {

    public static void main(String[] args) {
        List<Keyboard_Keys> keyList = getKeyList();
        for (Keyboard_Keys key : keyList)  {
            pressOnTypewriter(key);
        }
    }

    private static void pressOnTypewriter(Keyboard_Keys key) {
        switch (key){
            case SPACE:
                print(" ");
                break;
            case NEWLINE:
                print("\n");
                break;
            default:
                print(key.name());
                break;
        }
    }

    public static void print(String string){
        System.out.print(string);
    }

    private static List<Keyboard_Keys> getKeyList() {
        return Arrays.asList(
                A, SPACE,
                C, O, W, SPACE,
                J, U, M, P, E, D, SPACE,
                O, V, E, R, SPACE, NEWLINE,
                T, H, E, SPACE,
                M, O, O, N
        );
    }
}
