package com.raja.demomvvmjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.raja.demomvvmjava.databinding.ListFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private MainViewModel mainViewModel;

    ListFragmentBinding listFragmentBinding;

    List<User> users = new ArrayList<User>();

    RecyclerItemAdapter recyclerItemAdapter;

    public ListFragment() {

    }

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainViewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        listFragmentBinding = ListFragmentBinding.inflate(getLayoutInflater());

        listFragmentBinding.setMainViewModel(mainViewModel);

        init();

        return listFragmentBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    public void init() {

        listFragmentBinding.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        mainViewModel.allUsers.observe(getActivity(), users1 -> {

            listFragmentBinding.recyclerview.setAdapter(new RecyclerItemAdapter(getActivity(), users1));

        });

    }
}