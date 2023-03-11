package com.kartik.evidya.adapter;



import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.R;
import com.example.chatapp.model.ChatListEntity;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AdapterChat extends RecyclerView.Adapter<AdapterChat.AdapterChatViewHolder> {


    private static final int MSG_TYPE_LEFT = 0;
    private static final int MSG_TYPE_RIGHT = 1;
    Context context;
    List<ChatListEntity> chatList;
    String imageUrl;


    public AdapterChat(Context context, List<ChatListEntity> chatList, String imageUrl) {
        this.context = context;
        this.chatList = chatList;
        this.imageUrl = imageUrl;
    }

    @NonNull
    @Override
    public AdapterChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MSG_TYPE_RIGHT)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.row_chat_right,parent,false);
            return new AdapterChatViewHolder(view);
        }else
        {
            View view = LayoutInflater.from(context).inflate(R.layout.row_chat_left,parent,false);
            return new AdapterChatViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterChatViewHolder holder, int position) {

        String message = chatList.get(position).getDataMsgEntity().getChat();
        String time = chatList.get(position).getDataMsgEntity().getCreated_at();

        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(Long.parseLong(time));

        String dateTime = DateFormat.format("dd/MM/yyyy hh:mm aa", cal).toString();

        holder.messageTv.setText(message);
        holder.timeTv.setText(dateTime);
        try{
            Picasso.get().load(imageUrl).into(holder.profileIv);
        }catch (Exception e)
        {

        }

        if (position == chatList.size() -1)
        {
            holder.isSeenTv.setText("Seen");
        }

    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }


    //    my ViewhOlder
    public class AdapterChatViewHolder extends RecyclerView.ViewHolder {

        public ImageView profileIv;
        TextView messageTv, timeTv, isSeenTv;

        public AdapterChatViewHolder(@NonNull View itemView) {
            super(itemView);
            profileIv = itemView.findViewById(R.id.profileIv);
            messageTv = itemView.findViewById(R.id.messageTv);
            timeTv = itemView.findViewById(R.id.timeTv);
            isSeenTv = itemView.findViewById(R.id.isSeenTv);

        }
    }
}
