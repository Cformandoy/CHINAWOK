package com.example.chinawok.ui.PaginaWeb;

import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chinawok.R;
import com.example.chinawok.databinding.FragmentHomeBinding;

public class PaginaWeb extends Fragment {

    private PaginaWebViewModel mViewModel;
    public String URL;

    private FragmentHomeBinding binding;

    public static PaginaWeb newInstance() {
        return new PaginaWeb();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pagina_web_fragment, container, false);

        WebView webView;

        webView = (WebView)view.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

            URL = "https://www.google.cl";
            webView.loadUrl(URL); //solucionar certificados


        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PaginaWebViewModel.class);
        // TODO: Use the ViewModel
    }

}