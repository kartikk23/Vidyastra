package com.kartik.evidya.adapter;

import static com.kartik.evidya.app.ChatApplicationApp.loadFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kartik.evidya.R;
import com.kartik.evidya.model.StudentListEntity;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentListViewHolder> {

    Context ctx;
    List<StudentListEntity> mStudentList;
    StudentListAdapterListner listner;


    public StudentListAdapter(ArrayList<StudentListEntity> studentList) {
        mStudentList = studentList;
    }

    public StudentListAdapter(Context ctx, List<StudentListEntity> mStudentList, StudentListAdapterListner listner) {
        this.ctx = ctx;
        this.mStudentList = mStudentList;
        this.listner = listner;
    }

    @NonNull
    @Override
    public StudentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list, parent, false);
        parent.removeView(v);
        StudentListViewHolder svh = new StudentListViewHolder(v);

        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListViewHolder holder, int position) {

        StudentListEntity currentItem = mStudentList.get(position);
        holder.mUserImage.setImageResource(currentItem.getUserImage());
        holder.mUserName.setText(currentItem.getUserName());
        holder.mSubDetail.setText(currentItem.getSubDetail());
        holder.mTime.setText(currentItem.getTime());
        holder.mMedal.setImageResource(currentItem.getUserMedal());

        holder.mUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = ((AppCompatActivity) view.getContext()).getSupportFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putString("username", currentItem.getUserName());
                bundle.putString("subdetails", currentItem.getSubDetail());


                loadFragment("ChatFragment", bundle, fragmentManager);
//                Toast.makeText(view.getContext(), "User Name - " + currentItem.getUserName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStudentList.size();
    }

    public class StudentListViewHolder extends RecyclerView.ViewHolder {


        public CircleImageView mUserImage;
        public TextView mUserName;
        public TextView mSubDetail;
        public TextView mTime;
        public ImageView mMedal;
        private CardView mCardView;

        public StudentListViewHolder(@NonNull View itemView) {
            super(itemView);
            mUserImage = itemView.findViewById(R.id.iv_userImage);
            mUserName = itemView.findViewById(R.id.tv_userName);
            mSubDetail = itemView.findViewById(R.id.tv_subDetail);
            mTime = itemView.findViewById(R.id.tv_time);
            mMedal = itemView.findViewById(R.id.iv_userMedal);
            mCardView = itemView.findViewById(R.id.cardView);
        }
    }

    public interface StudentListAdapterListner {

    }
}
