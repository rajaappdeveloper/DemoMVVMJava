package com.raja.demomvvmjava;

import android.util.Log;
import android.widget.EditText;

import androidx.lifecycle.ViewModel;

public class AddFragmentViewModel extends ViewModel {


    public void validator() {

        Log.d("Test", "Testing");


    }

    public void validator(String Name) {

        Log.d("Test", "Testing" + Name);


    }

}
