package br.com.giovannemobile.turismogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Giovanne on 12/11/2016.
 */

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(3000);
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
