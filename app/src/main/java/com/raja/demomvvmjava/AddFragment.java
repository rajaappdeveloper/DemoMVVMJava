package com.raja.demomvvmjava;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.raja.demomvvmjava.databinding.AddFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class AddFragment extends Fragment {

    private MainViewModel mainViewModel;

    AddFragmentBinding addFragmentBinding;

    public AddFragment() {
    }

    public static AddFragment newInstance() {
        return new AddFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainViewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        addFragmentBinding = AddFragmentBinding.inflate(getLayoutInflater());

        addFragmentBinding.setMainViewModel(mainViewModel);

        init();

        return addFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void init() {

        mainViewModel.Fields.observe(getActivity(), s -> {

            if (s.equals("Inserted Successfully")) {

                addFragmentBinding.name.setText("");
                addFragmentBinding.gender.setText("");
                addFragmentBinding.email.setText("");
                addFragmentBinding.status.setText("");

            }

            Toast.makeText(getActivity().getApplicationContext(), s, Toast.LENGTH_SHORT).show();

        });


        mainViewModel.allUsers.observe(getActivity(), users ->
                addFragmentBinding.count.setText("Total Users : " + users.size()));
    }

}