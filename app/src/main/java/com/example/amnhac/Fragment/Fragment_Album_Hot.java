package com.example.amnhac.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amnhac.Activity.DanhsachtatcaAlbumActivity;
import com.example.amnhac.Adapter.AlbumAdapter;
import com.example.amnhac.Model.Album;
import com.example.amnhac.R;
import com.example.amnhac.Server.APIService;
import com.example.amnhac.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Album_Hot extends Fragment {

    View view;
    RecyclerView recyclerViewalbum;
    TextView textViewalbum;
    AlbumAdapter albumAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album_hot,container,false);// gắn layout vào biến view
        recyclerViewalbum = view.findViewById(R.id.recyclerviewAlbum);
        textViewalbum = view.findViewById(R.id.textviewxemthemalbum);
        textViewalbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachtatcaAlbumActivity.class);
                startActivity(intent);
            }
        });


        GetData();//tạo ra 1 funtion đọc dữ liệu
        return view;// cho hiển thị layout ra
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.GetAlbumHot();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> albumArrayList = (ArrayList<Album>) response.body();
                // phai gắn fragment_album_hot.xml vào fragment_trang_chu.xml
                //Log.d("BBB",albumArrayList.get(0).getTenAlbum());
                albumAdapter = new AlbumAdapter(getActivity(),albumArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewalbum.setLayoutManager(linearLayoutManager);
                recyclerViewalbum.setAdapter(albumAdapter);
                //Log.d("BBB",albumArrayList.get(0).getTenAlbum());

            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}
