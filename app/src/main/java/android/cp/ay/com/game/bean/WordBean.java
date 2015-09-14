package android.cp.ay.com.game.bean;

/**
 * Created by ayesh on 9/13/2015.
 */
public class WordBean {

    private String word;
    private int correctPos;
    private int answerPos;


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCorrectPos() {
        return correctPos;
    }

    public void setCorrectPos(int correctPos) {
        this.correctPos = correctPos;
    }

    public int getAnswerPos() {
        return answerPos;
    }

    public void setAnswerPos(int answerPos) {
        this.answerPos = answerPos;
    }
}
