package com.raja.demomvvmjava;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemListViewModel extends ViewModel {

    public MutableLiveData<String> Name = new MutableLiveData<>();
    public MutableLiveData<String> Gender = new MutableLiveData<>();
    public MutableLiveData<String> Email = new MutableLiveData<>();
    public MutableLiveData<String> Staus = new MutableLiveData<>();
}
