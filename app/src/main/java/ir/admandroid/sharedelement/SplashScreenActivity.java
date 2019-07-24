package ir.admandroid.sharedelement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView imageViewLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setExitTransition(null);
        imageViewLogo=findViewById(R.id.logo);

        splash.start();
    }

    Thread splash = new Thread() {
        @Override
        public void run() {
            try {
                sleep(2000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(SplashScreenActivity.this, imageViewLogo, "logo");
                        startActivity(i, optionsCompat.toBundle());

                    }
                });

            } catch (Exception e) {

            }
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
