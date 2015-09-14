package android.cp.ay.com.game.activity;

import android.content.Intent;
import android.cp.ay.com.game.MainApplication;
import android.cp.ay.com.game.R;
import android.cp.ay.com.game.enumclass.GameLevel;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private Button playGameButton,highScoreButton;
    private MainApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {


            application = (MainApplication) getApplication();

            setContentView(R.layout.activity_dashboard);


            UIInitialize();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, getResources().getString(R.string.exception), Toast.LENGTH_LONG).show();

        }

    }

    /*
    initialize UI Component
     */
    private void UIInitialize() throws Exception {
        try {

            playGameButton = (Button) findViewById(R.id.playGameButton);
            playGameButton.setOnClickListener(this);

            highScoreButton = (Button) findViewById(R.id.highScoreButton);
            highScoreButton.setOnClickListener(this);

        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public void onClick(View v) {

        try {

            switch (v.getId()) {

                case R.id.playGameButton:
                    /*Play game button action*/

                    application.GAME_LEVEL = GameLevel.LEVEL_01;

                    Intent callPlayGame = new Intent(this, GameInitActivity.class);
                    startActivity(callPlayGame);

                    break;

                case R.id.highScoreButton:
                    /*High Score button action*/

                    Intent callHighScore = new Intent(this, HighScoreActivity.class);
                    startActivity(callHighScore);

                    break;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
