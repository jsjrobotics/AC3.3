package nyc.c4q;

public class OptionalOperations {
    private static class Optional<T> {
        T value;

        public Optional(T value){
            this.value = value;
        }

        public T orElse(T other){
            if (value != null) {
                return value;
            }
            return other;
        }

        public Optional<T> transform(boolean toTransform, T value){
            if (toTransform) {
                this.value = value;
            }
            return this;
        }

        public Optional<T> filter(T other){
            if (value != null){
                return this;
            }
            return new Optional<T>(other);
        }

        public T get(){
            if ( value == null) {
                throw new IllegalArgumentException("null value");
            }
            return value;
        }
    }

    public static void main(String[] args){
        problem4();

    }

    private static void problem1() {
        Optional<String> maybeString = new Optional<String>("hello");
        String result = maybeString.transform(false, "hello2")
                .transform(true, "hello1")
                .filter("notCrazy")
                .get();
        System.out.println(result);
    }

    private static void problem2() {
        Optional<String> maybeString = new Optional<String>(null);
        String result = maybeString.transform(false, "hello2")
                .transform(false, "hello1")
                .filter("notCrazy")
                .get();
        System.out.println(result);
    }

    private static void problem3() {
        Optional<String> maybeString = new Optional<String>(null);
        String result = maybeString.transform(false, "hello2")
                .transform(false, "hello1")
                .filter(null)
                .filter("test")
                .get();
        System.out.println(result);
    }

    private static void problem4() {
        Optional<Integer> maybeString = new Optional<Integer>(null);
        int result = maybeString.transform(false, new Integer(5))
                .transform(false, new Integer(8))
                .filter(null)
                .orElse(new Integer(10));
        System.out.println(result);
    }
}
