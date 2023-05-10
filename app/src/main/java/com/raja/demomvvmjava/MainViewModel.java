package com.raja.demomvvmjava;

import android.app.Application;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public MutableLiveData<String> Fields = new MutableLiveData<>();

    // creating a new variable for course repository.
    public UserRepository repository;

    // below line is to create a variable for live
    // data where all the courses are present.
    public LiveData<List<User>> allUsers;


    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAllUsers();

    }

    public void AddUser(EditText Name, EditText Gender, EditText Email, EditText Status) {

        if (Validator(Name, Gender, Email, Status)) {

            User user = new User();

            user.setName("" + Name.getText().toString().trim());
            user.setGender("" + Gender.getText().toString().trim());
            user.setEmail("" + Email.getText().toString().trim());
            user.setStatus("" + Status.getText().toString().trim());

            insert(user);

        } else {

            Fields.setValue("Please fill all fields");
        }

    }

    public void DeleteUser(int ID) {

        repository.deleteID(ID);

    }

    public boolean Validator(EditText Name, EditText Gender, EditText Email, EditText Status) {

        return (Name.getText().toString().trim().length() != 0) &&
                (Gender.getText().toString().trim().length() != 0) &&
                (Email.getText().toString().trim().length() != 0) &&
                (Status.getText().toString().trim().length() != 0);

    }


    public void insert(User user) {

        repository.insert(user);

        Fields.setValue("Inserted Successfully");
    }


}
