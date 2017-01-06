package nyc.c4q.testsolution.backend;

public class KeyboardKey {
    private final String name;
    private final String textColor;
    private final String url;

    public KeyboardKey(String name, String textColor, String url) {
        this.name = name;
        this.textColor = textColor;
        this.url = url;
    }

    public String getUrlPath() {
        return url;
    }

    public String getTextColor() {
        return textColor;
    }

    public String getName() {
        return name;
    }
}
