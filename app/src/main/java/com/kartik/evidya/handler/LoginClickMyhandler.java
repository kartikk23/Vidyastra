package com.kartik.evidya.handler;

import static com.example.chatapp.app.ChatApplicationApp.loadFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;

import com.example.chatapp.databinding.FragmentLoginBinding;
import com.example.chatapp.model.UserResultEntity;
import com.example.chatapp.viewModel.LoginClickViewModel;

public class LoginClickMyhandler {

    FragmentActivity activity;
    FragmentLoginBinding binding;
    LoginClickViewModel loginClickViewModel;
    FragmentManager fragmentManager;
    String email, password;
    Bundle bundle;


    public LoginClickMyhandler(FragmentActivity activity, FragmentLoginBinding binding, LoginClickViewModel loginClickViewModel, Bundle arguments) {
        this.activity = activity;
        this.binding = binding;
        this.loginClickViewModel = loginClickViewModel;
        this.bundle = arguments;
    }


    public void loader() {
    }

    public void onClickLogin(View view) {
        if (isValidated()) {
            email = binding.etEmail.getText().toString().trim();
            password = binding.etPassword.getText().toString().trim();

            loginClickViewModel.getLogin(email, password).observe(activity, new Observer<UserResultEntity>() {

                @Override
                public void onChanged(UserResultEntity userResultEntity) {
                    if (userResultEntity.getAccess_token() != null)
                    {
                        fragmentManager = activity.getSupportFragmentManager();
//                        String name = userResultEntity.getUser().getName();
                        Bundle bundle = new Bundle();
                        bundle.putString("token", userResultEntity.getAccess_token());
                        bundle.putString("name", "name");
                        loadFragment("TeacherFragment",bundle,fragmentManager);
                        Toast.makeText(activity, "welcome", Toast.LENGTH_SHORT).show();

                    }else
                    {
                        Toast.makeText(activity, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private boolean isValidated() {
        if (binding.etEmail.getText().toString().isEmpty()) {
            binding.etEmail.setError("Required");
            binding.etEmail.requestFocus();
            return false;
        } else if (binding.etPassword.getText().toString().isEmpty()) {
            binding.etPassword.setError("Required");
            binding.etPassword.requestFocus();
            return false;
        } else {
            return true;
        }
    }


    public void errorMethodShow(int statusCode) {
        Toast.makeText(activity, "Error 401" + statusCode, Toast.LENGTH_SHORT).show();
    }
}
