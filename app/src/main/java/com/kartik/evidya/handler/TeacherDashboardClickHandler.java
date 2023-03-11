package com.kartik.evidya.handler;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.R;
import com.example.chatapp.adapter.ListItemAdapter;
import com.example.chatapp.databinding.FragmentTeacherDashboardBinding;
import com.example.chatapp.model.ListItemEntity;
import com.example.chatapp.viewModel.TeacherDashboardClickViewModel;
import com.example.chatapp.views.TeacherDashboardFragment;

import java.util.ArrayList;

public class TeacherDashboardClickHandler {
    FragmentActivity activity;
    FragmentTeacherDashboardBinding binding;
    TeacherDashboardClickViewModel teacherDashboardClickViewModel;
    Toolbar toolbar;
    ListItemAdapter listAdapter;
    TeacherDashboardFragment teacherDashboardFragment;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.LayoutParams params;
    Bundle bundle;


    public TeacherDashboardClickHandler(FragmentActivity activity, FragmentTeacherDashboardBinding binding, TeacherDashboardClickViewModel teacherDashboardClickViewModel, Bundle bundle) {
        this.activity = activity;
        this.teacherDashboardClickViewModel = teacherDashboardClickViewModel;
        this.binding = binding;
        this.bundle = bundle;
    }

    public void loader() {
        init();


    }


    private void init() {
        ArrayList<ListItemEntity> exampleList = new ArrayList<>();
        exampleList.add(new ListItemEntity(1,R.drawable.man, "Demo User", "demo@gmail.com", "8:30", R.drawable.medal));
        exampleList.add(new ListItemEntity(2,R.drawable.man, "Demo User 1", "demo1@gmail.com", "8:31", R.drawable.medal));
        exampleList.add(new ListItemEntity(3,R.drawable.man, "Demo User 2", "demo2@gmail.com", "8:32", R.drawable.medal));
        exampleList.add(new ListItemEntity(4,R.drawable.man, "teacher User 3", "demo3@gmail.com", "8:33", R.drawable.medal));
        exampleList.add(new ListItemEntity(5,R.drawable.man, "Demo User 4", "demo4@gmail.com", "8:34", R.drawable.medal));
        exampleList.add(new ListItemEntity(6,R.drawable.man, "Demo User 5", "demo5@gmail.com", "8:35", R.drawable.medal));
        exampleList.add(new ListItemEntity(7,R.drawable.man, "Demo User 6", "demo6@gmail.com", "8:36", R.drawable.medal));
        exampleList.add(new ListItemEntity(8,R.drawable.man, "Demo User 7", "demo7@gmail.com", "8:37", R.drawable.medal));
        exampleList.add(new ListItemEntity(9,R.drawable.man, "Demo User 8", "demo8@gmail.com", "8:38", R.drawable.medal));
        exampleList.add(new ListItemEntity(10,R.drawable.man, "Demo User 9", "demo9@gmail.com", "8:39", R.drawable.medal));
        exampleList.add(new ListItemEntity(11,R.drawable.man, "Demo User 10", "demo10@gmail.com", "8:40", R.drawable.medal));
        exampleList.add(new ListItemEntity(12,R.drawable.man, "Demo User 11", "demo11@gmail.com", "8:41", R.drawable.medal));
        exampleList.add(new ListItemEntity(13,R.drawable.man, "Demo User 12", "demo12@gmail.com", "8:42", R.drawable.medal));
        exampleList.add(new ListItemEntity(14,R.drawable.man, "Demo User 13", "demo13@gmail.com", "8:43", R.drawable.medal));

        toolbar = binding.toolbar.myToolbar;
        ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        String text = bundle.getString("token");
//        String name = bundle.getString("name");

        toolbar.setTitle("");

        mRecyclerView = binding.recyclerViewList;
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mAdapter = new ListItemAdapter(exampleList);
        params = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 0);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }



}
