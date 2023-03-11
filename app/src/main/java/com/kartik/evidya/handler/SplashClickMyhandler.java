package com.kartik.evidya.handler;

import static com.example.chatapp.app.ChatApplicationApp.loadFragment;

import android.os.Handler;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.chatapp.databinding.FragmentSplashBinding;

public class SplashClickMyhandler {
    FragmentActivity activity;
    FragmentSplashBinding binding;
    public SplashClickMyhandler(FragmentActivity activity, FragmentSplashBinding binding) {
        this.activity = activity;
        this.binding = binding;
    }

    public void loader() {
        load();
    }

    private void load() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                loadFragment("LoginFragment", fragmentManager);
            }
        },3000);
    }
}
