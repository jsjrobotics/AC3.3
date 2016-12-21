package nyc.c4q.testsolution.backend;

public class Animal {
    private final String name;
    private final String textColor;
    private final String background;

    public Animal(String name, String textColor, String background) {
        this.name = name;
        this.textColor = textColor;
        this.background = background;
    }

    public String getBackground() {
        return background;
    }

    public String getTextColor() {
        return textColor;
    }

    public String getName() {
        return name;
    }
}
