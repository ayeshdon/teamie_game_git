package android.cp.ay.com.game;
import android.content.Intent;
import android.cp.ay.com.game.activity.DashboardActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;



/**
 * Splash screen activity
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        Shimmer shimmer = new Shimmer();

        ShimmerTextView splashTextView = (ShimmerTextView) findViewById(R.id.splashTextView);
        shimmer.start(splashTextView);


        Thread timerThread = new Thread() {
            public void run() {
                try {

                    sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timerThread.start();
    }


}

