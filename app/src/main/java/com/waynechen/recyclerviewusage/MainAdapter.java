package com.waynechen.recyclerviewusage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Wayne Chen on 2018/5/7.
 */
public class MainAdapter extends RecyclerView.Adapter {

    private final static int VIEWTYPE_TOP = 0x01;
    private final static int VIEWTYPE_NORMAL = 0x02;

    private ArrayList<UsageItem> mUsageItems;

    public MainAdapter(ArrayList<UsageItem> items) {
        mUsageItems = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == VIEWTYPE_TOP) {

            View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_main, parent, false);
            return new TopItemViewHolder(view);
        } else {

            View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
//            View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_main, parent, false);
            return new MainItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MainItemViewHolder) {

            ((MainItemViewHolder) holder).getItemTitle().setText(mUsageItems.get(position).getTitle());

            if (mUsageItems.get(position).getDrawableNum() == 0) {
                ((MainItemViewHolder) holder).getItemImage().setImageResource(R.drawable.yosemite);
            } else if (mUsageItems.get(position).getDrawableNum() == 1) {
                ((MainItemViewHolder) holder).getItemImage().setImageResource(R.drawable.yosemite2);
            }
        } else if (holder instanceof TopItemViewHolder) {

            ((TopItemViewHolder) holder).getItemImage().setImageResource(R.drawable.yosemite);
        }
    }

    @Override
    public int getItemCount() {
        return mUsageItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0) ? VIEWTYPE_TOP : VIEWTYPE_NORMAL;
//        return (position == 0) ? VIEWTYPE_NORMAL : VIEWTYPE_NORMAL;
    }

    private class MainItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView mItemImage;
        private TextView mItemTitle;

        public MainItemViewHolder(View itemView) {
            super(itemView);

            mItemImage = (ImageView) itemView.findViewById(R.id.imageview_image);
            mItemTitle = (TextView) itemView.findViewById(R.id.textview_title);
        }

        public ImageView getItemImage() {
            return mItemImage;
        }

        public TextView getItemTitle() {
            return mItemTitle;
        }
    }

    private class TopItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView mItemImage;

        public TopItemViewHolder(View itemView) {
            super(itemView);

            mItemImage = (ImageView) itemView.findViewById(R.id.imageview_image);
        }

        public ImageView getItemImage() {
            return mItemImage;
        }
    }
}
