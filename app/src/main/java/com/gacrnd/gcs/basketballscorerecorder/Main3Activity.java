package com.gacrnd.gcs.basketballscorerecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.gacrnd.gcs.basketballscorerecorder.databinding.ActivityMain3Binding;

/**
 * 演示SavedStateHandle+Sharedpreference缓存数据
 */
public class Main3Activity extends AppCompatActivity {

    MyShpViewMedel myShpViewMedel;
    ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);
        myShpViewMedel = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(MyShpViewMedel.class);
        binding.setViewmodel(myShpViewMedel);
        binding.setLifecycleOwner(this);
    }
}
