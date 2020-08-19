package com.gacrnd.gcs.basketballscorerecorder;

import android.content.Intent;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/**
 * 演示高级版viewmodel  activity被销毁保存数据
 *
 * @author Jack_Ou  created on 2020/8/19.
 */
public class MyAdvancedViewModel extends ViewModel {

    public static final String MY_KEY = "key";
    private SavedStateHandle handle;

    MyAdvancedViewModel(SavedStateHandle handle) {
        this.handle = handle;
    }

    public MutableLiveData<Integer> getScore() {
        return handle.getLiveData(MY_KEY, 0);
    }

    public void add(){
        handle.set(MY_KEY,(int)handle.getLiveData(MY_KEY).getValue() + 1);
    }
}
