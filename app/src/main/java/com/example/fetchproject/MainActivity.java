package com.example.fetchproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView textView;
    LinearLayoutManager layoutManager;
    HiringAdapter adapter;
    List<Hiring> hiringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        textView = findViewById(R.id.titleName);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HiringAdapter(hiringList);
        recyclerView.setAdapter(adapter);

        fetchHiring();
    }

    private void fetchHiring() {
        RetrofitClient.getRetrofitClient().getHiring().enqueue(new Callback<List<Hiring>>() {
            @Override
            public void onResponse(Call<List<Hiring>> call, Response<List<Hiring>> response) {
                if(!response.isSuccessful())
                {
                    Log.e("onResponse", "not successful: " + response.code());
                }
                hiringList.addAll(response.body());
                adapter.notifyDataSetChanged();
                return;
            }

            @Override
            public void onFailure(Call<List<Hiring>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}