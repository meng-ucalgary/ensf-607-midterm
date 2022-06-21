package midterm.server.model;

public class StringModel {
    private String myString;

    public void concatenate(String s1, String s2) {
        setMyString(s1 + s2);
    }

    public void concatenateWithLower(String s1, String s2) {
        this.concatenate(s1.toLowerCase(), s2.toLowerCase());
    }

    public void concatenateWithUpper(String s1, String s2) {
        this.concatenate(s1.toUpperCase(), s2.toUpperCase());
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }
}
