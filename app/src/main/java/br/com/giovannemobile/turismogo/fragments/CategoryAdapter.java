package br.com.giovannemobile.turismogo.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.giovannemobile.turismogo.DetailActivity;
import br.com.giovannemobile.turismogo.PlacesActivity;
import br.com.giovannemobile.turismogo.R;
import br.com.giovannemobile.turismogo.fragments.dummy.DummyContent;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    Context context;

    private final String[] mValues = {"Artesanato", "Bares e Restaurantes", "Farmácias", "Hotéis e Pousadas", "Lojas", "Praias"};

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mCategory.setText(mValues[position]);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 1:
                        context.startActivity(new Intent(context, PlacesActivity.class).putExtra("category", DummyContent.ServicesCategory.BAR_RESTAURANT));
                        break;
                    case 3:
                        context.startActivity(new Intent(context, PlacesActivity.class).putExtra("category", DummyContent.ServicesCategory.HOTEL));
                        break;
                    case 5:
                        context.startActivity(new Intent(context, PlacesActivity.class).putExtra("category", DummyContent.ServicesCategory.BEACH));
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mCategory;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCategory = (TextView) view.findViewById(R.id.category);
        }
    }
}
