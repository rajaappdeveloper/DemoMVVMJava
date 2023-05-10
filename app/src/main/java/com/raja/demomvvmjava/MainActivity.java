package com.raja.demomvvmjava;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.raja.demomvvmjava.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        init();

    }

    public void init() {

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, getSupportFragmentManager());
        binding.viewPager.setAdapter(viewPagerAdapter);


        mainViewModel.allUsers.observe(this, users ->
                binding.setTotalusers("" + users.size()));

    }

}