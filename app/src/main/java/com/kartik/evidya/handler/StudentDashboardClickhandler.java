package com.kartik.evidya.handler;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kartik.evidya.R;
import com.kartik.evidya.adapter.ListItemAdapter;
import com.kartik.evidya.adapter.StudentListAdapter;
import com.kartik.evidya.databinding.FragmentStudentDashboardBinding;
import com.kartik.evidya.model.StudentListEntity;
import com.kartik.evidya.views.TeacherDashboardFragment;

import java.util.ArrayList;

public class StudentDashboardClickhandler {

    FragmentActivity activity;
    FragmentStudentDashboardBinding binding;
    Toolbar toolbar;
    ListItemAdapter listAdapter;
    TeacherDashboardFragment teacherDashboardFragment;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.LayoutParams params;
    Bundle bundle;
    TextView textView;
    ImageView imageView;

    public StudentDashboardClickhandler(FragmentActivity activity, FragmentStudentDashboardBinding binding, Bundle arguments) {
        this.activity = activity;
        this.binding = binding;
        this.bundle = arguments;
    }

    public void loader() {
        init();
    }
    private void init() {
        ArrayList<StudentListEntity> studentList = new ArrayList<>();
        studentList.add(new StudentListEntity(R.drawable.man, "Sudent List", "demo@gmail.com", "8:30", R.drawable.medal));
        studentList.add(new StudentListEntity(R.drawable.man, "Demo List 1", "demo1@gmail.com", "8:31", R.drawable.medal));
        studentList.add(new StudentListEntity(R.drawable.man, "Demo User 2", "demo2@gmail.com", "8:32", R.drawable.medal));
        studentList.add(new StudentListEntity(R.drawable.man, "teacher User 3", "demo3@gmail.com", "8:33", R.drawable.medal));
        studentList.add(new StudentListEntity(R.drawable.man, "Demo User 4", "demo4@gmail.com", "8:34", R.drawable.medal));
        studentList.add(new StudentListEntity(R.drawable.man, "Demo User 5", "demo5@gmail.com", "8:35", R.drawable.medal));
        studentList.add(new StudentListEntity(R.drawable.man, "Demo User 6", "demo6@gmail.com", "8:36", R.drawable.medal));
        studentList.add(new StudentListEntity(R.drawable.man, "Demo User 7", "demo7@gmail.com", "8:37", R.drawable.medal));
        studentList.add(new StudentListEntity(R.drawable.man, "Demo User 8", "demo8@gmail.com", "8:38", R.drawable.medal));
        studentList.add(new StudentListEntity(R.drawable.man, "Demo User 9", "demo9@gmail.com", "8:39", R.drawable.medal));
        studentList.add(new StudentListEntity(R.drawable.man, "Demo User 10", "demo10@gmail.com", "8:40", R.drawable.medal));
        studentList.add(new StudentListEntity(R.drawable.man, "Demo User 11", "demo11@gmail.com", "8:41", R.drawable.medal));
        studentList.add(new StudentListEntity(R.drawable.man, "Demo User 12", "demo12@gmail.com", "8:42", R.drawable.medal));
        studentList.add(new StudentListEntity(R.drawable.man, "Demo User 13", "demo13@gmail.com", "8:43", R.drawable.medal));

        toolbar = binding.mainToolbar.myToolbar;
        ((AppCompatActivity) activity).setSupportActionBar(toolbar);

        ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();

        actionBar.setTitle("vidyastra");





        mRecyclerView = binding.recyclerViewListStudent;
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mAdapter = new StudentListAdapter(studentList);
        params = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 0);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }
}
