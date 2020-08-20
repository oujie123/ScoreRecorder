package com.gacrnd.gcs.basketballscorerecorder;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Jack_Ou  created on 2020/8/4.
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> aScore;
    private MutableLiveData<Integer> bScore;
    private int aScoreTemp;
    private int bScoreTemp;

    public MutableLiveData<Integer> getaScore() {
        if (null == aScore) {
            aScore = new MutableLiveData<>();
            aScore.setValue(0);
        }
        return aScore;
    }

    public MutableLiveData<Integer> getbScore() {
        if (null == bScore) {
            bScore = new MutableLiveData<>();
            bScore.setValue(0);
        }
        return bScore;
    }

    public void addScore(boolean isAteam, int score) {
        if (isAteam) {
            aScoreTemp = aScore.getValue() == null ? 0 : aScore.getValue();
            bScoreTemp = bScore.getValue() == null ? 0 : bScore.getValue();
            aScore.setValue(aScore.getValue() == null ? 0 : aScore.getValue() + score);
        } else {
            aScoreTemp = aScore.getValue() == null ? 0 : aScore.getValue();
            bScoreTemp = bScore.getValue() == null ? 0 : bScore.getValue();
            bScore.setValue(bScore.getValue() == null ? 0 : bScore.getValue() + score);
        }
    }

    public void unDo() {
        aScore.setValue(aScoreTemp);
        bScore.setValue(bScoreTemp);
    }

    public void reset() {
        aScore.setValue(0);
        bScore.setValue(0);
    }
}
