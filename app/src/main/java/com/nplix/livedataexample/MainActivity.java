package com.nplix.livedataexample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CounterViewModel counterViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView counterTextView=findViewById(R.id.txtCounter);
        //Declare the Counter Data Model
        counterViewModel=
                ViewModelProviders.of(this).get(CounterViewModel.class);
        //Create the Observer for Livedata
        Observer<Integer> dataObserver=new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                counterTextView.setText("Counter at :"+integer);
                Log.d("LiveData Update:","Data has been updated, current value is"+integer);
            }
        };
        //set the observer on LiveData
        counterViewModel.getCounter().observe(this,dataObserver);

    }
}
