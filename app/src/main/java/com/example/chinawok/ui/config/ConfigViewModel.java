package com.example.chinawok.ui.config;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConfigViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ConfigViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Config fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}