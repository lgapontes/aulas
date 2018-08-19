package com.lgapontes.dicaboa;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatadorMoeda {

    public static void configurar(final EditText editText) {

        /* Adiciona um listener para escutar alterações no texto */
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence valor, int start, int before, int count) {

                /* Evita invocação circular */
                editText.removeTextChangedListener(this);

                /* Remove caracteres não numéricos para tratamento */
                String cleanString = valor.toString().replaceAll("[R$,.]", "").trim();
                double parsed = Double.parseDouble(cleanString);

                /* Converte para moeda real */
                Locale ptBr = new Locale("pt", "BR");
                String formatted = NumberFormat.getCurrencyInstance(ptBr).format(parsed/100);

                /* Define o texto e posicionamento do cursor */
                editText.setText(formatted);
                editText.setSelection(formatted.length());

                /* Configura novamente este listener */
                editText.addTextChangedListener(this);
            }

            @Override
            public void beforeTextChanged(CharSequence valor, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable editable) {}
        });

    }

}
