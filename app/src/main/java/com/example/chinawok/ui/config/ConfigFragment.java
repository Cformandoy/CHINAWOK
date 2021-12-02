package com.example.chinawok.ui.config;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.chinawok.LoginActivity;
import com.example.chinawok.NavegationDrawerActivity;
import com.example.chinawok.R;
import com.example.chinawok.databinding.FragmentConfigBinding;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.w3c.dom.Text;

public class ConfigFragment extends Fragment {

    private ConfigViewModel configViewModel;
    private FragmentConfigBinding binding;
    public TextView txv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        configViewModel =
                new ViewModelProvider(this).get(ConfigViewModel.class);

        binding = FragmentConfigBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textConfig;
        configViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Bundle miBundle = getActivity().getIntent().getExtras();

        if (miBundle!= null){

            String user = miBundle.getString("user");
            Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();
            txv = (TextView) root.findViewById(R.id.tvConfig);
            txv.setText(user);

        }

//        AQUI COMIENZA EL CODIGO DE LA BD
//
//        final String fullname, username, email, rol;
//
//        username = txv.toString();
//
//
//        if (!username.equals("") ){
//
//            Handler handler = new Handler(Looper.getMainLooper());
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    //Starting Write and Read data with URL
//                    //Creating array for parameters
//                    String[] field = new String[1];
//                    field[0] = "username";
//
//
//                    //Creating array for data
//                    String[] data = new String[1];
//                    data[0] = username;
//
//                    PutData putData = new PutData("http://0.tcp.ngrok.io:17848/chinawok/consultaUser.php", "POST", field, data);
//                    if (putData.startPut()) {
//                        if (putData.onComplete()) {
//
//
//                            String result = putData.getResult();
//                            if (result.equals("Success")){
//
//
//                                //MOSTRAR EN PANTALLA LOS DATOS OBTENIDOS
//
//                            }
//                            else{
//                                Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();
//                            }
//                            //End ProgressBar (Set visibility to GONE)
//                        }
//                    }
//
//                }});
//
//            //End Write and Read data with URL
//        }else {
//            Toast.makeText(getContext(),"All fields required",Toast.LENGTH_SHORT).show();
//        }

//        AQUI TERMINA EL CODIGO DE LA BD


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}