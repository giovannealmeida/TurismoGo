package br.com.giovannemobile.turismogo.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.com.giovannemobile.turismogo.R;

public class WarningFragment extends Fragment {

    public WarningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_warning, container, false);

        final EditText etDescription = (EditText) view.findViewById(R.id.etDescription);
        final TextView tvCharCounter = (TextView) view.findViewById(R.id.tvCharCounter);
        tvCharCounter.setText(String.valueOf(0+"/"+getResources().getInteger(R.integer.description_max_length)));

        final TextWatcher mTextEditorWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                tvCharCounter.setText(String.valueOf(s.length()+"/"+getResources().getInteger(R.integer.description_max_length)));
            }
        };

        etDescription.addTextChangedListener(mTextEditorWatcher);

        (view.findViewById(R.id.btMyLocation)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((EditText) view.findViewById(R.id.etMyLocation)).setText("Centro de Convenções - Ilhéus");
            }
        });

        view.findViewById(R.id.btSendWarn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Alerta enviado com sucesso")
                        .setMessage("O seu alerta foi enviado diretamente para a secretaria responsável! ;)")
                        .setPositiveButton("Ok", null)
                        .create().show();

            }
        });

        return view;
    }
}
