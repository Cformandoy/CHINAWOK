package com.example.chinawok.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.chinawok.R;
import com.example.chinawok.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

//        CODIGO PARA CAMBIAR HACIA EL FRAGMENT DE BANQUETES

        ImageButton imb_banquetes = (ImageButton) root.findViewById(R.id.imb_banquetes);

        imb_banquetes.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.banquetesFragment));

//        CODIGO PARA CAMBIAR HACIA EL FRAGMENT DE PROMOCIONES

        ImageButton imb_promociones = (ImageButton) root.findViewById(R.id.imb_promociones);

        imb_promociones.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.promocionesFragment));

//        CODIGO PARA CAMBIAR HACIA EL FRAGMENT DE WOK INDIVIDUAL

        ImageButton imb_wokIndividual = (ImageButton) root.findViewById(R.id.imb_wokIndividual);

        imb_wokIndividual.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.wokIndividualFragment));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}