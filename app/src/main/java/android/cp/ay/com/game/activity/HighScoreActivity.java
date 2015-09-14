package android.cp.ay.com.game.activity;

import android.cp.ay.com.game.adapter.HighScoreListAdapter;
import android.cp.ay.com.game.bean.ScoreBean;
import android.cp.ay.com.game.db.table.ScoresTable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.cp.ay.com.game.R;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HighScoreActivity extends ActionBarActivity {

    ArrayList<ScoreBean> scoreList;
    private ListView highScoreListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {

            setContentView(R.layout.activity_high_score);


            UIInitialize();

            loadScoreList();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, getResources().getString(R.string.exception), Toast.LENGTH_LONG).show();

        }
    }

    private void loadScoreList() throws  Exception{
        try {

            ScoresTable table = new ScoresTable(this);
            scoreList = table.getTopScoreList();


            HighScoreListAdapter scoreListAdapter = new HighScoreListAdapter(this,scoreList);

            highScoreListView.setAdapter(scoreListAdapter);



        }catch (Exception e){
            throw  e;
        }
    }



    private void UIInitialize() throws  Exception{
        try {

            highScoreListView = (ListView) findViewById(R.id.highScoreListView);

        }catch (Exception e){
            throw  e;
        }
    }


}
