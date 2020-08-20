package com.gacrnd.gcs.basketballscorerecorder;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

/**
 * @author Jack_Ou  created on 2020/8/20.
 */
public class MyShpViewMedel extends AndroidViewModel {

    private String myKey = getApplication().getResources().getString(R.string.my_key);
    private String shpName = getApplication().getResources().getString(R.string.shp_name);
    private SharedPreferences sharedPreference = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
    private SharedPreferences.Editor editor = sharedPreference.edit();
    private SavedStateHandle handle;

    public MyShpViewMedel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if (!handle.contains(myKey)) {
            load();
        }
    }

    private void load() {
        int x = sharedPreference.getInt(myKey, 0);
        handle.set(myKey, x);
    }

    private void save() {
        editor.putInt(myKey, (int) handle.get(myKey));
        editor.apply();
    }

    public MutableLiveData<Integer> getNumber() {
        return handle.getLiveData(myKey);
    }

    public void add(int num) {
        handle.set(myKey,getNumber().getValue() == null ? 0 : getNumber().getValue() + num);
        save();
    }
}
