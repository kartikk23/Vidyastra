package com.kartik.evidya.handler;

import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.chatapp.databinding.FragmentStudentProfileBinding;

public class StudentProfileClickHandler {
    FragmentActivity activity;
    FragmentStudentProfileBinding binding;
    Bundle bundle;
    String username;
    TextView userName;


    public StudentProfileClickHandler(FragmentActivity activity, FragmentStudentProfileBinding binding, Bundle bundle) {
        this.activity = activity;
        this.binding = binding;
        this.bundle = bundle;
    }

    public void loader() {
        username = bundle.getString("username");

        userName =  binding.tvUserName;
        userName.setText(username);
    }
}
