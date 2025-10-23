package com.example.apitest;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Tag;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView rcvMain;


        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rcvMain=findViewById(R.id.rcvMain);
        rcvMain.setLayoutManager(new LinearLayoutManager(this));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final List<DataModel>[] alluserlist = new List[1];


        RetrofitInstance.getInstance().apiInterface.getPhotos().enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                alluserlist[0] =response.body();
                rcvMain.setAdapter(new userAdapter(MainActivity.this,alluserlist[0]));
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                Log.e("api", "onFailure: "+t.getLocalizedMessage() );
            }
        });
    }
}