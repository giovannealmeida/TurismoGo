package br.com.giovannemobile.turismogo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.integration.android.IntentIntegrator;

import br.com.giovannemobile.turismogo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScanFragment extends Fragment {


    public ScanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scan, container, false);

        (view.findViewById(R.id.btScan)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(getActivity());
                integrator.setPrompt("Aponte o leitor para o código");
//                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                integrator.setOrientationLocked(false);
                integrator.setBeepEnabled(false);
                integrator.setCaptureActivity(CaptureActivity.class);
                integrator.initiateScan();
            }
        });

        return view;
    }

}
