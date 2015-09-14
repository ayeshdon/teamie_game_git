package android.cp.ay.com.game.bean;

/**
 * Created by ayesh on 9/13/2015.
 */
public class ParagraphBean {

    private int pos;
    private String text;
    private WordBean wordBean;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public WordBean getWordBean() {
        return wordBean;
    }

    public void setWordBean(WordBean wordBean) {
        this.wordBean = wordBean;
    }
}
