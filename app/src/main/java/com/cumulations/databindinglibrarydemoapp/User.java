package com.cumulations.databindinglibrarydemoapp;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class User extends BaseObservable {
    public String firstName;
    public String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }
}
