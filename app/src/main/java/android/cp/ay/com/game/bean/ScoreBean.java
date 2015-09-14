package android.cp.ay.com.game.bean;

/**
 * Created by ayesh on 9/14/2015.
 */
public class ScoreBean{

    private int score;
    private int level;
    private int rank;
    private String name;


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
