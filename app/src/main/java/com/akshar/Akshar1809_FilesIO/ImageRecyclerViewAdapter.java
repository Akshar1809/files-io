package com.akshar.Akshar1809_FilesIO;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.File;

public class ImageRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private String mFileName;//for sending file to next activity

    ImageRecyclerViewAdapter(Context mContext){
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.files_list,parent,false);
        return new FileLayoutHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((FileLayoutHolder)holder).Title.setText(Constant.allImageMediaList.get(position).getName());
        //we will load thumbnail using glid library
        Uri uri = Uri.fromFile(Constant.allImageMediaList.get(position));

        Glide.with(mContext)
                .load(uri).thumbnail(0.1f).into(((FileLayoutHolder)holder).thumbnail);

((FileLayoutHolder) holder).linearLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Toast.makeText(mContext,uri.getPath().toString(),Toast.LENGTH_LONG).show();

        mFileName =uri.getPath();
        Intent intent = new Intent(mContext,ImageViewer.class);
        intent.putExtra("filePath", mFileName);
        mContext.startActivity(intent);
    }
});

((FileLayoutHolder) holder).send_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //image send code is below
        Intent shareAPkIntent = new Intent();
        shareAPkIntent.setAction(Intent.ACTION_SEND);
        shareAPkIntent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(
                mContext,BuildConfig.APPLICATION_ID + ".provider", new File(uri.getPath())
        ));

        shareAPkIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        shareAPkIntent.setType("application/vnd.android.package-archive");
        mContext.startActivity(Intent.createChooser(shareAPkIntent,"Share Image"));

    }
});


    }

    @Override
    public int getItemCount() {
        return Constant.allImageMediaList.size();
    }



    class FileLayoutHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        ImageView thumbnail;
        TextView Title;
        ImageView send_btn;

        public FileLayoutHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout=itemView.findViewById(R.id.linearLayout);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            Title = itemView.findViewById(R.id.title);
            send_btn = itemView.findViewById(R.id.send_btn);

        }
    }


}



