package com.nplix.livedataexample;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by PK on 1/14/2018.
 */

public class CounterViewModel extends ViewModel {

    private MutableLiveData<Integer> counter=new MutableLiveData<>();

    private static int ONE_SECOND=1000;
    private static int InitCount=0;

    //Constructor
    public CounterViewModel(){
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                counter.postValue(InitCount++);
            }
        },ONE_SECOND,ONE_SECOND);
    }
    public MutableLiveData<Integer> getCounter() {
        return counter;
    }
}
