package br.com.giovannemobile.turismogo.fragments.dummy;

import java.util.ArrayList;
import java.util.List;

import br.com.giovannemobile.turismogo.R;

public class DummyContent {

    public enum ServicesCategory {
        BAR_RESTAURANT,
        BEACH,
        HOTEL
    }

    public DummyContent() {

    }

    public List<DummyPlace> getDummyHistoricalPlaces() {
        List<DummyPlace> list = new ArrayList<>();
        list.add(new DummyPlace("1", "Vesúvio", R.drawable.vesuvio));
        list.add(new DummyPlace("2", "Teatro Municipal", R.drawable.teatro));
        list.add(new DummyPlace("3", "Bataclan", R.drawable.bataclan));
        list.add(new DummyPlace("4", "Casa de Cultura Jorge Amado", R.drawable.jorge));
        list.add(new DummyPlace("5", "Catedral de São Sebastião", R.drawable.catedral));
        return list;
    }

    public List<DummyPlace> getDummyServicePlaces(ServicesCategory category) {

        List<DummyPlace> list = new ArrayList<>();

        switch (category) {
            case BAR_RESTAURANT:
                list.add(new DummyPlace("1", "Barrakítika   [$$$] ", R.drawable.barrakitika));
                list.add(new DummyPlace("2", "Buteco do Posto   [$$]", R.drawable.buteco_posto));
                list.add(new DummyPlace("3", "Mar Aberto    [$$]", R.drawable.mar_aberto));
                break;
            case BEACH:
                list.add(new DummyPlace("1", "Cabana Gabriela   [$$]", R.drawable.gabriela));
                list.add(new DummyPlace("2", "Cabana Guarani    [$]", R.drawable.guarani));
                list.add(new DummyPlace("3", "Cabana Soro Caseiro   [$$]", R.drawable.soro_caseiro));
                list.add(new DummyPlace("4", "Cabana Narigas    [$$$]", R.drawable.narigas));
                break;
            case HOTEL:
                list.add(new DummyPlace("1", "Aldeia da Praia   [$$$]", R.drawable.aldeia_praia));
                list.add(new DummyPlace("2", "Barravento    [$$]", R.drawable.barravento));
                list.add(new DummyPlace("3", "Ilhéus Praia Hotel    [$$$]", R.drawable.ilheus_praia));
                list.add(new DummyPlace("4", "Jardim Atlântico  [$$$]", R.drawable.jardim_atlantico));
                list.add(new DummyPlace("5", "Pousada Praia do Sol  [$$$]", R.drawable.praia_sol));
                break;
        }

        return list;
    }

    public static class DummyPlace {
        public final String id;
        public final String content;
        public final int image;

        public DummyPlace(String id, String content, int image) {
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
