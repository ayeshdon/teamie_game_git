package android.cp.ay.com.game.activity;

import android.content.Intent;
import android.cp.ay.com.game.MainApplication;
import android.cp.ay.com.game.utils.Constant;
import android.cp.ay.com.game.utils.Utils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.cp.ay.com.game.R;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameInitActivity extends ActionBarActivity implements View.OnClickListener{

    private TextView pharaContainerTextView;
    private Button gameStartButton;
    private MainApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {

            application = (MainApplication) getApplication();

            setContentView(R.layout.activity_game_init);

            int ran = Utils.getRandomNumber();

            int parapos = ran % (4);

            application.SELECTED_PARAGRAPH = Constant.PARA_ARRAY[parapos];


            UIInitialize();

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, getResources().getString(R.string.exception), Toast.LENGTH_LONG).show();
            callBack();
        }

    }

    private void UIInitialize() {
        try {

            pharaContainerTextView = (TextView) findViewById(R.id.pharaContainerTextView);
            pharaContainerTextView.setText(application.SELECTED_PARAGRAPH);

            gameStartButton = (Button)findViewById(R.id.gameStartButton);
            gameStartButton.setOnClickListener(this);

        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void onClick(View view) {
        try {

            switch (view.getId()){

                case R.id.gameStartButton:

                    Intent callGame = new Intent(this,GameActivity.class);
                    startActivity(callGame);
                    callBack();

                    break;

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * general back action
     */
    private void callBack() {
        finish();
    }

    @Override
    public void onBackPressed() {
        callBack();
    }


}
