package br.com.giovannemobile.turismogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.zxing.integration.android.IntentIntegrator;

import br.com.giovannemobile.turismogo.fragments.GuideFragment;
import br.com.giovannemobile.turismogo.fragments.MapFragment;
import br.com.giovannemobile.turismogo.fragments.PlacesCategoriesFragment;
import br.com.giovannemobile.turismogo.fragments.ScanFragment;
import br.com.giovannemobile.turismogo.fragments.WarningFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_map:
                    getSupportActionBar().setTitle(R.string.action_map);
                    pushFragment(new MapFragment());
                    return true;
                case R.id.navigation_guide:
                    getSupportActionBar().setTitle(R.string.acion_guide);
                    pushFragment(new GuideFragment());
                    return true;
                case R.id.navigation_places:
                    getSupportActionBar().setTitle(R.string.action_places);
                    pushFragment(new PlacesCategoriesFragment());
                    return true;
                case R.id.navigation_warn:
                    getSupportActionBar().setTitle(R.string.action_warn);
                    pushFragment(new WarningFragment());
                    return true;
                case R.id.navigation_scanner:
                    getSupportActionBar().setTitle(R.string.action_scanner);
                    pushFragment(new ScanFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IntentIntegrator.REQUEST_CODE) {
            startActivity(new Intent(MainActivity.this,DetailActivity.class));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pushFragment(new MapFragment());

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void pushFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction().replace(R.id.content, fragment)
                .commit();
    }

}
