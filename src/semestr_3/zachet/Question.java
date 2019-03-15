package semestr_3.zachet;

public class Question {
    private int x;
    private int y;
    private int wx;
    private int wy;
    private String questionString;

    Question(int x, int y, int wx, int wy, String questionString) {
        this.x = x;
        this.y = y;
        this.wx = wx;
        this.wy = wy;
        this.questionString = questionString;
    }

    public int getWx() {
        return wx;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWy() {
        return wy;
    }

    public String getQuestionString() {
        return questionString;
    }
}

