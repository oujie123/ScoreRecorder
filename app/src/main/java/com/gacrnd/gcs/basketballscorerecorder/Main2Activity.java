package com.gacrnd.gcs.basketballscorerecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;

import android.os.Bundle;
import android.util.Log;

import com.gacrnd.gcs.basketballscorerecorder.databinding.ActivityMain2Binding;

/**
 * 此activity演示高级版viewmodel   数据保存不随activity生命周期
 */
public class Main2Activity extends AppCompatActivity {

    ActivityMain2Binding binding;
    MyAdvancedViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        viewModel = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(),this)).get(MyAdvancedViewModel.class);
        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);
    }
}
