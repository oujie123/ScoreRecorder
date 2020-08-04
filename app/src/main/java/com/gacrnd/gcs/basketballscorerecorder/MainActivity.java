package com.gacrnd.gcs.basketballscorerecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.gacrnd.gcs.basketballscorerecorder.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MyViewModel myViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        //把数据放入binding中
        binding.setData(myViewModel);
        //设置监听
        binding.setLifecycleOwner(this);
    }
}
