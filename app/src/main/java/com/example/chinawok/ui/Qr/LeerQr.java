package com.example.chinawok.ui.Qr;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.chinawok.CaptureActivity;
import com.example.chinawok.R;
import com.example.chinawok.ui.PaginaWeb.PaginaWebViewModel;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class LeerQr extends Fragment {

    private LeerQrViewModel mViewModel;
    EditText edt;
    Button buscar;
    Button cargarWeb;
    public String resqr;



    public static LeerQr newInstance() {
        return new LeerQr();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.leer_qr_fragment, container, false);

        edt = view.findViewById(R.id.EditTextQR);
        buscar = (Button) view.findViewById(R.id.btn_leer);
        cargarWeb = (Button) view.findViewById(R.id.btn_cargarWeb);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                escanear();
            }

        });

        cargarWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resqr = edt.getText().toString();

                Toast.makeText(getContext(), "Cargando: "+resqr, Toast.LENGTH_SHORT).show();

                WebView webView;

                webView = (WebView)view.findViewById(R.id.webqr);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);

                webView.loadUrl(resqr); //solucionar certificados
            }
        });

        return view;
    }

    public void escanear(){
        IntentIntegrator integrador = IntentIntegrator.forSupportFragment(LeerQr.this);
        integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrador.setPrompt("ESCANEAR CODIGO QR");
        integrador.setCameraId(0);
        integrador.setBeepEnabled(true);
        integrador.setBarcodeImageEnabled(true);
        integrador.setOrientationLocked(false);
        integrador.setCaptureActivity(CaptureActivity.class);
        integrador.initiateScan();


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);



        if (result!=null){
            if (result.getContents() == null){
                Toast.makeText(getContext(), "Cancelaste la Lectura de QR", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getContext(), "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

                edt.setText(result.getContents().toString());

            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
            Toast.makeText(getContext(), "Cancelaste la Lectura de QR", Toast.LENGTH_SHORT).show();
        }



        super.onActivityResult(requestCode, resultCode, data);
    }





    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LeerQrViewModel.class);
        // TODO: Use the ViewModel
    }

}