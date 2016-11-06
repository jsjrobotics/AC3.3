package nyc.c4q;

public class FunctionsEatingFunctions {
    public static class StringBuilder{
        private String value;

        public StringBuilder(String start){
            value = start;
        }

        public StringBuilder append(String other){
            return new StringBuilder(value + other);
        }

        public String get(){
            return value;
        }
    }

    public void problem1() {
        StringBuilder builder = new StringBuilder("start");
        builder.append("1");
        builder.append("2");
        builder.append("3");
        System.out.println(builder.get());
    }

    public void problem2() {
        StringBuilder builder = new StringBuilder("start").append("1");
        StringBuilder builder2 = new StringBuilder("end");
        builder2.append("2");
        System.out.println(builder.get());
        System.out.println(builder2.get());
    }

    public void problem3() {
        StringBuilder builder = new StringBuilder("start").append("1");
        builder = builder.append("2");
        System.out.println(builder.get());
    }

    public void problem4() {
        System.out.println(
                new StringBuilder("end")
                        .append("2")
                        .get()
        );
    }
}
