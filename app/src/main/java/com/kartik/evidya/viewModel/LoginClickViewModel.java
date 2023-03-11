package com.kartik.evidya.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.chatapp.model.UserResultEntity;
import com.example.chatapp.repository.CompRepository;

public class LoginClickViewModel extends ViewModel {


    public LiveData<UserResultEntity> getLogin(String email, String password) {
        return CompRepository.getInstance().getLoginDetails(email,password);
    }
}
