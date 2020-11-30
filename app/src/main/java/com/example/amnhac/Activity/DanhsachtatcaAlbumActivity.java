package com.example.amnhac.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amnhac.R;

public class DanhsachtatcaAlbumActivity extends AppCompatActivity {

    RecyclerView recyclerViewAllalbum;
    Toolbar toolbaralbum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatca_album);
        init();
    }

    private void init() {
        recyclerViewAllalbum=findViewById(R.id.relativewAllalbum);
        toolbaralbum=findViewById(R.id.toolbarALLalbum);
        setSupportActionBar(toolbaralbum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất cả Album");
        toolbaralbum.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}