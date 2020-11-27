package com.example.amnhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amnhac.Model.Album;
import com.example.amnhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{// kế thừa RecyclerView.Adapter

    Context context;
    ArrayList<Album> mangalbum;

    public AlbumAdapter(Context context, ArrayList<Album> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//dùng để gắn layout vào cho mình
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_album,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {//sử dụng thực hiện gắn giá trị gì đó
        Album album = mangalbum.get(position);
        holder.txtcasialbum.setText(album.getTenCaSiAlbum());
        holder.txttenalbum.setText(album.getTenAlbum());
        Picasso.with(context).load(album.getHinhAlbum()).into(holder.imghinhalbum);
    }

    @Override
    public int getItemCount() {//trả cho function muốn viết bao nhiêu cái item trong cái RecyclerView
        //Log.d("BBB", );
        return mangalbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imghinhalbum;
        TextView txttenalbum,txtcasialbum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghinhalbum = itemView.findViewById(R.id.imageviewalbum);
            txttenalbum = itemView.findViewById(R.id.textviewtenalbum);
            txtcasialbum = itemView.findViewById(R.id.textviewtencasialbum);
        }
    }
}
