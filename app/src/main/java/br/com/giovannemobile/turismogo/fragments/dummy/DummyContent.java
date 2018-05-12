package br.com.giovannemobile.turismogo.fragments.dummy;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.com.giovannemobile.turismogo.R;

public class DummyContent {

    private List<DummyItem> list = new ArrayList<>();

    public DummyContent(){
        list.add(new DummyItem("1","Vesúvio", R.drawable.vesuvio));
        list.add(new DummyItem("2","Teatro Municipal",R.drawable.teatro));
        list.add(new DummyItem("3","Bataclan",R.drawable.bataclan));
        list.add(new DummyItem("4","Casa de Cultura Jorge Amado",R.drawable.jorge));
        list.add(new DummyItem("5","Catedral de São Sebastião",R.drawable.catedral));
    }

    public List<DummyItem> getDummyContent(){
        return list;
    }

    public static class DummyItem {
        public final String id;
        public final String content;
        public final int image;

        public DummyItem(String id, String content, int image) {
            this.id = id;
            this.content = content;
            this.image = image;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
