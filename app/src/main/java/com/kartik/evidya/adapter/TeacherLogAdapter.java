package com.kartik.evidya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.R;
import com.example.chatapp.model.TeacherLogEntity;

import java.util.ArrayList;
import java.util.List;

public class TeacherLogAdapter extends RecyclerView.Adapter<TeacherLogAdapter.TeacherLogViewHolder> {

    private List<TeacherLogEntity> mTeacherLogList;

    public TeacherLogAdapter(ArrayList<TeacherLogEntity> teacherLogEntities) {
        mTeacherLogList = teacherLogEntities;
    }

    @NonNull
    @Override
    public TeacherLogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacherloglistitem, parent, false);

        TeacherLogViewHolder tvh = new TeacherLogViewHolder(v);

        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherLogViewHolder holder, int position) {
        TeacherLogEntity currentItem = mTeacherLogList.get(position);

        holder.mdate.setText(currentItem.getDate());
        holder.mMonth.setText(currentItem.getMonth());
        holder.mteacherLog.setText(currentItem.getTeacherlog());

    }

    @Override
    public int getItemCount() {
        return mTeacherLogList.size();
    }

    public class TeacherLogViewHolder extends RecyclerView.ViewHolder{

    public TextView mdate;
    public TextView mMonth;
    public TextView mteacherLog;
        public TeacherLogViewHolder(@NonNull View itemView) {
            super(itemView);

            mdate = itemView.findViewById(R.id.tv_date);
            mMonth = itemView.findViewById(R.id.tv_month);
            mteacherLog = itemView.findViewById(R.id.tv_teacherlogtext);
        }
    }
}
