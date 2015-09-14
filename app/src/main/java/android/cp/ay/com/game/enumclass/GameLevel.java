package android.cp.ay.com.game.enumclass;

/**
 * Created by ayesh on 9/14/2015.
 */
public enum GameLevel {
    LEVEL_01(3,"Level 01"),LEVEL_02(4,"Level 02");

    private int index;
    private String label;

    private GameLevel(int index,String label){
        this.index = index;
        this.label = label;

    }

    public String getLabel() {
        return label;
    }

    public int getIndex() {
        return index;
    }
}
