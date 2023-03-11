package com.kartik.evidya.handler;

import static com.example.chatapp.app.ChatApplicationApp.loadFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.R;
import com.example.chatapp.adapter.AdapterChat;
import com.example.chatapp.databinding.FragmentChatBinding;
import com.example.chatapp.model.ChatListEntity;
import com.example.chatapp.viewModel.ChatMyClickViewModel;

import java.util.ArrayList;
import java.util.List;

public class ChatMyClickHandler {
    FragmentActivity activity;
    FragmentChatBinding binding;
    ChatMyClickViewModel chatMyClickViewModel;
    Toolbar toolbar;
    Bundle mbundle;
    TextView username;
    FragmentManager fragmentManager;
    String text;
    ImageView imageView;
    RecyclerView recyclerView;

    List<ChatListEntity> chatList;
    AdapterChat adapterChat;
    String imageUrl;


    public ChatMyClickHandler(FragmentActivity activity, FragmentChatBinding binding, ChatMyClickViewModel chatMyClickViewModel, Bundle arguments) {
         this.activity = activity;
         this.binding = binding;
         this.chatMyClickViewModel = chatMyClickViewModel;
         this.mbundle = arguments;
    }

    @SuppressLint("RestrictedApi")
    public void loader() {

        toolbar = binding.chatToolbar.myToolbar;
        recyclerView = binding.chatListRecyclerView;
        String imageUrl = "aa.ff";

        recyclerView();

        text = mbundle.getString("username","");
//        Log.d("username",text);
//        getTitleWithBackButton(activity,toolbar,text);
        username = toolbar.findViewById(R.id.toolbarTitle);
        imageView = toolbar.findViewById(R.id.iv_userImageIcon);

        username.setText(text);
        imageView.getResources().getDrawable(R.drawable.man);


        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager = activity.getSupportFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putString("username", text);
                loadFragment("StudentProfile",bundle,fragmentManager);
            }
        });


        //toolbar Title
//
//        username.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadFragment("TeacherProfile",activity.getSupportFragmentManager());
//            }
//        });


    }

    private void recyclerView() {
        chatList =  new ArrayList<>();

        imageUrl = "";
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);



        adapterChat = new AdapterChat(activity,chatList,imageUrl);
        adapterChat.notifyDataSetChanged();

        recyclerView.setAdapter(adapterChat);

    }

    public void onMsgSendBtn(View view)
   {
       Toast.makeText(activity, "Send Msg", Toast.LENGTH_SHORT).show();
   }
}
