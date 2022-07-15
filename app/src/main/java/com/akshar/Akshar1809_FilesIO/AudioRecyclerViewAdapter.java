package com.akshar.Akshar1809_FilesIO;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
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

import java.io.File;
import java.io.IOException;

import static android.content.ContentValues.TAG;

public class AudioRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    MediaPlayer mPlayer;
    Boolean yes_no=false;
    private String mFileName;//for sending file to next activity


    AudioRecyclerViewAdapter(Context mContext){
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
        ((FileLayoutHolder)holder).Title.setText(Constant.allAudioMediaList.get(position).getName());
        //we will load thumbnail using glid library
        Uri uri = Uri.fromFile(Constant.allAudioMediaList.get(position));
        ((FileLayoutHolder) holder).thumbnail.setImageResource(R.drawable.tune);

//        Glide.with(mContext)
//                .load(uri).thumbnail(0.1f).into(((FileLayoutHolder)holder).thumbnail);
        ((FileLayoutHolder) holder).linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,uri.getPath().toString(),Toast.LENGTH_LONG).show();
                mFileName =uri.getPath();
                yes_no=true;
//                Intent shareAPkIntent = new Intent();
//                shareAPkIntent.setAction(Intent.ACTION_SEND);
//                shareAPkIntent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(
//                        mContext,BuildConfig.APPLICATION_ID + ".provider", new File(uri.getPath())
//                ));
//
//                shareAPkIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                shareAPkIntent.setType("application/vnd.android.package-archive");
//                mContext.startActivity(Intent.createChooser(shareAPkIntent,"Share APK"));
                if (mPlayer==null) {
                    startPlaying();

                }
                else {
                    mPlayer.stop();
                    startPlaying();
                }
            }
        });

        ((FileLayoutHolder) holder).send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareAPkIntent = new Intent();
                shareAPkIntent.setAction(Intent.ACTION_SEND);
                shareAPkIntent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(
                        mContext,BuildConfig.APPLICATION_ID + ".provider", new File(uri.getPath())
                ));

                shareAPkIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                shareAPkIntent.setType("application/vnd.android.package-archive");
                mContext.startActivity(Intent.createChooser(shareAPkIntent,"Share Audio"));

            }
        });

    }

    private void startPlaying() {

        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e(TAG, "prepare() failed");
        }
    }

    @Override
    public int getItemCount() {
        return Constant.allAudioMediaList.size();
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



