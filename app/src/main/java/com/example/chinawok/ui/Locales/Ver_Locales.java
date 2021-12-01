package com.example.chinawok.ui.Locales;

import androidx.lifecycle.ViewModelProvider;

import android.icu.text.Transliterator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.chinawok.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ver_Locales extends Fragment {
    ListView lv1;
    private Spinner spinner1;
    Button btn;

    private VerLocalesViewModel mViewModel;


    public static Ver_Locales newInstance() {
        return new Ver_Locales();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.ver_locales_fragment, container, false);

        spinner1 = (Spinner) view.findViewById(R.id.spinner);
        lv1 = (ListView) view.findViewById(R.id.lv2);
        btn = (Button)view.findViewById(R.id.btn_Buscar);

        ArrayAdapter<CharSequence> adaptador1 = ArrayAdapter.createFromResource(getContext(), R.array.Regiones, android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adaptador1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscar(view);
            }
        });

        return view;


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VerLocalesViewModel.class);

        // TODO: Use the ViewModel
    }


    public void buscar(View view){

        String seleccion = spinner1.getSelectedItem().toString();

        if (seleccion.equals("Antofagasta")){
            ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource(getContext(), R.array.Antofagasta, android.R.layout.simple_list_item_1);
            lv1.setAdapter(adaptador2);
        }else if (seleccion.equals("Tarapaca")){
            ArrayAdapter<CharSequence> adaptador3 = ArrayAdapter.createFromResource(getContext(), R.array.Tarapaca, android.R.layout.simple_list_item_1);
            lv1.setAdapter(adaptador3);
        }else if (seleccion.equals("Metropolitana")){
            ArrayAdapter<CharSequence> adaptador4 = ArrayAdapter.createFromResource(getContext(), R.array.Metropolitana, android.R.layout.simple_list_item_1);
            lv1.setAdapter(adaptador4);
        }else if (seleccion.equals("Atacama")){
            ArrayAdapter<CharSequence> adaptador5 = ArrayAdapter.createFromResource(getContext(), R.array.Atacama, android.R.layout.simple_list_item_1);
            lv1.setAdapter(adaptador5);
        }else if (seleccion.equals("Coquimbo")){
            ArrayAdapter<CharSequence> adaptador6 = ArrayAdapter.createFromResource(getContext(), R.array.Coquimbo, android.R.layout.simple_list_item_1);
            lv1.setAdapter(adaptador6);
        }
    }

}