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

import java.io.File;

public class DocumentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;


    DocumentRecyclerViewAdapter(Context mContext){
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
        ((FileLayoutHolder)holder).Title.setText(Constant.allDocumentMediaList.get(position).getName());
        //we will load thumbnail using glid library
        Uri uri = Uri.fromFile(Constant.allDocumentMediaList.get(position));
        if (uri.toString().endsWith(".txt"))
        {
            ((FileLayoutHolder) holder).thumbnail.setImageResource(R.drawable.txt);
        }
        else if (uri.toString().endsWith(".doc")|| uri.toString().endsWith(".docx")|| uri.toString().endsWith(".docm")
                || uri.toString().endsWith(".dotx")|| uri.toString().endsWith(".dotm")|| uri.toString().endsWith(".dot"))
        {
//            ".doc",".docx",".docm",".dotx",".dotm",".dot",
            ((FileLayoutHolder) holder).thumbnail.setImageResource(R.drawable.doc);
        }
        else if (uri.toString().endsWith(".pdf"))
        {
            ((FileLayoutHolder) holder).thumbnail.setImageResource(R.drawable.pdf);
        }
        else if (uri.toString().endsWith(".xls")|| uri.toString().endsWith(".xlsm")|| uri.toString().endsWith(".xlsb")|| uri.toString().endsWith(".xlsx")
                || uri.toString().endsWith(".xltx")|| uri.toString().endsWith(".xltm")|| uri.toString().endsWith(".csv"))
        {
//            ".xls",".xlsm",".xlsb",".xlsx",".xltx",".xltm",".csv"
            ((FileLayoutHolder) holder).thumbnail.setImageResource(R.drawable.xls);
        }
        else
        {
            ((FileLayoutHolder) holder).thumbnail.setImageResource(R.drawable.other_files);
        }



        ((FileLayoutHolder) holder).linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            Intent shareAPkIntent = new Intent();
//            shareAPkIntent.setAction(Intent.ACTION_SEND);
                Toast.makeText(mContext,uri.getPath().toString(),Toast.LENGTH_LONG).show();
//            shareAPkIntent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(
//                    mContext,BuildConfig.APPLICATION_ID + ".provider", new File(uri.getPath())
//            ));
////            shareAPkIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            shareAPkIntent.setType("application/vnd.android.package-archive");
//
//            mContext.startActivity(Intent.createChooser(shareAPkIntent,"Share APK"));


//            ApplicationInfo app = mContext.getApplicationInfo();
//            String filePath = app.publicSourceDir;
//            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
//            Uri uri = Uri.parse(filePath);
//            sharingIntent.setType("*/*");
//            sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);
//            mContext.startActivity(Intent.createChooser(sharingIntent, "Share app using"));
                Intent shareAPkIntent = new Intent();
                shareAPkIntent.setAction(Intent.ACTION_SEND);
                shareAPkIntent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(
                        mContext,BuildConfig.APPLICATION_ID + ".provider", new File(uri.getPath())
                ));

                shareAPkIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                shareAPkIntent.setType("application/vnd.android.package-archive");

                mContext.startActivity(Intent.createChooser(shareAPkIntent,"Share APK"));
            }
        });
    }



    @Override
    public int getItemCount() {
        return Constant.allDocumentMediaList.size();
    }

    class FileLayoutHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        ImageView thumbnail;
        TextView Title;
        ImageView ic_more_btn;

        public FileLayoutHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linearLayout);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            Title = itemView.findViewById(R.id.title);
            ic_more_btn = itemView.findViewById(R.id.send_btn);

        }
    }

}




