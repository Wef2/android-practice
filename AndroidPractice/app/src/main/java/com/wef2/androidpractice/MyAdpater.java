package com.wef2.androidpractice;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BK on 2016-09-18.
 */
public class MyAdpater extends RecyclerView.Adapter<MyAdpater.ViewHolder> {

    private List<Information> informationList;

    public MyAdpater(List<Information> informationList) {
        this.informationList = informationList;
    }

    @Override
    public MyAdpater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_adapter_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdpater.ViewHolder holder, final int position) {
        final Context context = holder.cardView.getContext();
        final Uri uri = informationList.get(position).getUri();
        final int rotationDegree = informationList.get(position).getRotationDegree();

        holder.imageView.setImageURI(uri);
        holder.datetimeTextView.setText(informationList.get(position).getDatetime());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ImageActivity.class);
                intent.putExtra("uri", uri);
                intent.putExtra("degree", rotationDegree);
                context.startActivity(intent);
            }
        });
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informationList.remove(position);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return informationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        public ImageView imageView;
        public TextView datetimeTextView;
        public Button deleteButton;

        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            imageView = (ImageView) v.findViewById(R.id.image_view);
            datetimeTextView = (TextView) v.findViewById(R.id.datetime_text_view);
            deleteButton = (Button) v.findViewById(R.id.delete_button);
        }
    }

}