package android.cp.ay.com.game.bean;

/**
 * Created by ayesh on 9/13/2015.
 */
public class WordBean {

    private String word;
    private int correctPos = -1;
    private int answerPos = -1;

    /**
     * Get word text
     * @return
     */
    public String getWord() {
        return word;
    }

    /**
     * set word text
     * @param word
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * get sentence number of correct place
     * @return
     */
    public int getCorrectPos() {
        return correctPos;
    }

    /**
     * set sentence number of correct place
     * @param correctPos
     */
    public void setCorrectPos(int correctPos) {
        this.correctPos = correctPos;
    }

    /**
     * get player selected answer positon
     * @return
     */
    public int getAnswerPos() {
        return answerPos;
    }

    /**
     * set player selected answer positon
     * @param answerPos
     */
    public void setAnswerPos(int answerPos) {
        this.answerPos = answerPos;
    }
}
