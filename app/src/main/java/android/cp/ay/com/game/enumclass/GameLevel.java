package android.cp.ay.com.game.enumclass;

/**
 * Created by ayesh on 9/14/2015.
 */
public enum GameLevel {
    LEVEL_01(1,"Level 01",3),LEVEL_02(2,"Level 02",4);

    private int index;
    private String label;
    private int wordCount;

    private GameLevel(int index,String label,int wordCount){
        this.index     = index;
        this.wordCount = wordCount;
        this.label     = label;

    }

    public String getLabel() {
        return label;
    }

    public int getIndex() {
        return index;
    }

    public int getWordCount() {
        return wordCount;
    }
}
