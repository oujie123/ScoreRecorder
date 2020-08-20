package com.gacrnd.gcs.basketballscorerecorder;

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
        if (!handle.contains(MY_KEY)) {
            handle.set(MY_KEY, 0);
        }
    }

    public MutableLiveData<Integer> getNumber() {
        return handle.getLiveData(MY_KEY);
    }

    public void add() {
        handle.set(MY_KEY, getNumber().getValue() == null ? 0 : getNumber().getValue() + 1);
    }
}
