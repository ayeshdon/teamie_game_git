package android.cp.ay.com.game.bean;

/**
 * Created by ayesh on 9/13/2015.
 */
public class ParagraphBean {

    private int pos;
    private String text;
    private WordBean wordBean;

    /**
     * get paragraph possition
     * @return
     */
    public int getPos() {
        return pos;
    }

    /**
     * set paragraph position
     * @param pos
     */
    public void setPos(int pos) {
        this.pos = pos;
    }

    /**
     * get paragraph text
     * @return
     */
    public String getText() {
        return text;
    }


    /**
     * set paragraph text
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * get removed word data bean
     * @return
     */
    public WordBean getWordBean() {
        return wordBean;
    }

    /**
     * set removed word data bean
     * @return
     */
    public void setWordBean(WordBean wordBean) {
        this.wordBean = wordBean;
    }
}
