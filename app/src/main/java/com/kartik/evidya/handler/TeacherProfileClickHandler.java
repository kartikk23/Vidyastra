package com.kartik.evidya.handler;

import static com.example.chatapp.app.ChatApplicationApp.getTitleWithBackButton;

import android.annotation.SuppressLint;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kartik.evidya.databinding.FragmentTeacherProfileBinding;
import com.kartik.evidya.model.TeacherLogEntity;

import java.util.ArrayList;

public class TeacherProfileClickHandler {
    FragmentActivity activity;
    FragmentTeacherProfileBinding binding;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.LayoutParams params;
    Toolbar toolbar;
    public TeacherProfileClickHandler(FragmentActivity activity, FragmentTeacherProfileBinding binding) {
        this.activity = activity;
        this.binding = binding;
    }

    public void loader() {
        init();
    }

    @SuppressLint("RestrictedApi")
    private void init() {
        ArrayList<TeacherLogEntity> teacherLogEntities = new ArrayList<>();
        teacherLogEntities.add(new TeacherLogEntity("20","july","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        teacherLogEntities.add(new TeacherLogEntity("31","july","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        teacherLogEntities.add(new TeacherLogEntity("15","july","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        teacherLogEntities.add(new TeacherLogEntity("21","july","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        teacherLogEntities.add(new TeacherLogEntity("25","july","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        teacherLogEntities.add(new TeacherLogEntity("24","july","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        teacherLogEntities.add(new TeacherLogEntity("22","july","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        teacherLogEntities.add(new TeacherLogEntity("20","july","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        teacherLogEntities.add(new TeacherLogEntity("24","july","Lorem Ipsum is simply dummy text of the printing and typesetting industry."));

        toolbar = binding.teacherProfileToolbar.myToolbar;
        getTitleWithBackButton(activity,toolbar,"Profile");


        mRecyclerView = binding.teacherLogRecyclerview;
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mAdapter = new TeacherLogAdapter(teacherLogEntities);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }
}
