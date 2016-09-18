package com.wef2.androidpractice;

import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by BK on 2016-09-18.
 */
public class MyAdpater extends RecyclerView.Adapter<MyAdpater.ViewHolder> {

    private List<Uri> uriList;

    public MyAdpater(List<Uri> uriList) {
        this.uriList = uriList;
    }

    @Override
    public MyAdpater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_adapter_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdpater.ViewHolder holder, int position) {
        holder.imageView.setImageURI(uriList.get(position));
    }

    @Override
    public int getItemCount() {
        return uriList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        public ImageView imageView;
        public Button deleteButton;

        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            imageView = (ImageView) v.findViewById(R.id.image_view);
            deleteButton = (Button) v.findViewById(R.id.delete_button);
        }
    }

}