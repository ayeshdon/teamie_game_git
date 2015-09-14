package android.cp.ay.com.game.activity;

import android.content.Intent;
import android.cp.ay.com.game.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private Button playGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.activity_dashboard);

//            CommonUI.getInstace().showAlert("Test","Message",this);

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

                    Intent callPlayGame = new Intent(this, GameInitActivity.class);
                    startActivity(callPlayGame);

                    break;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
