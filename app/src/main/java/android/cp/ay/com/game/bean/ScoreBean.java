package android.cp.ay.com.game.bean;

/**
 * Created by ayesh on 9/14/2015.
 */
public class ScoreBean{

    private int score;
    private int level;
    private int rank;
    private String name;

    /**
     * Get final score of the task
     * @return
     */
    public int getScore() {
        return score;
    }


    /**
     * Set final score of the task
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Get Level of the game
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set level of the game
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Get player name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set player name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get players rank
     * @return
     */
    public int getRank() {
        return rank;
    }

    /**
     * set players rank
     * @param rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }
}
