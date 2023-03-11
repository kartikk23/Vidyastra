package com.kartik.evidya.adapter;


import static com.kartik.evidya.app.ChatApplicationApp.loadFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.kartik.evidya.R;
import com.kartik.evidya.model.ListItemEntity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListItemViewHolder> implements Filterable {

    private List<ListItemEntity> mListItemList;
    private List<ListItemEntity> mListItemListFull;

    private Context context;


    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        ListItemViewHolder lvh = new ListItemViewHolder(v);

        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        ListItemEntity currentItem = mListItemList.get(position);

        holder.mUserImage.setImageResource(currentItem.getUserImage());
        holder.mUserName.setText(currentItem.getUserName());
        holder.mSubDetail.setText(currentItem.getSubDetail());
        holder.mTime.setText(currentItem.getTime());
        holder.mMedal.setImageResource(currentItem.getUserMedal());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Bundle bundle = new Bundle();
              bundle.putString("username",currentItem.getUserName());
              bundle.putInt("userId",currentItem.getUserId());
              loadFragment("ChatFragment",bundle,((AppCompatActivity)holder.mUserName.getContext()).getSupportFragmentManager());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListItemList.size();
    }


    public ListItemAdapter(ArrayList<ListItemEntity> listItemList) {
        mListItemList = listItemList;
        mListItemListFull = new ArrayList<>(mListItemList);
    }

    @Override
    public Filter getFilter() {
        return listItemFilter;
    }


    private Filter listItemFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<ListItemEntity> filterList = new ArrayList<>();

            if (charSequence == null || charSequence.length() > 0)
            {
                filterList.addAll(mListItemListFull);
            }else
            {
                String filterpattern = charSequence.toString().toLowerCase().trim();

                for (ListItemEntity item: mListItemListFull)
                {
                    if (item.getUserName().toLowerCase().contains(filterpattern))
                    {
                        filterList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filterList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mListItemList.clear();
            mListItemList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };
    public static class ListItemViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView mUserImage;
        public TextView mUserName;
        public TextView mSubDetail;
        public TextView mTime;
        public ImageView mMedal;
        private CardView mCardView;

        public ListItemViewHolder(@NonNull View itemView) {
            super(itemView);

            mUserImage = itemView.findViewById(R.id.iv_userImage);
            mUserName = itemView.findViewById(R.id.tv_userName);
            mSubDetail = itemView.findViewById(R.id.tv_subDetail);
            mTime = itemView.findViewById(R.id.tv_time);
            mMedal = itemView.findViewById(R.id.iv_userMedal);
            mCardView = itemView.findViewById(R.id.cardView);

        }
    }
}
