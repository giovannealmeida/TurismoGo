package br.com.giovannemobile.turismogo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.List;

import br.com.giovannemobile.turismogo.fragments.CategoryAdapter;
import br.com.giovannemobile.turismogo.fragments.PlacesAdapter;
import br.com.giovannemobile.turismogo.fragments.dummy.DummyContent;

public class PlacesActivity extends AppCompatActivity {

    private List<DummyContent.DummyPlace> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        switch ((DummyContent.ServicesCategory) getIntent().getExtras().get("category")){
            case BAR_RESTAURANT:
                list = new DummyContent().getDummyServicePlaces(DummyContent.ServicesCategory.BAR_RESTAURANT);
                getSupportActionBar().setTitle("Bares e Restaurantes");
                break;
            case BEACH:
                list = new DummyContent().getDummyServicePlaces(DummyContent.ServicesCategory.BEACH);
                getSupportActionBar().setTitle("Praias");
                break;
            case HOTEL:
                list = new DummyContent().getDummyServicePlaces(DummyContent.ServicesCategory.HOTEL);
                getSupportActionBar().setTitle("Hotéis");
                break;
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new PlacesAdapter(list));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
