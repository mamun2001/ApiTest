package com.example.apitest;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Tag;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView txtid,txttitle,txturl,thumbnailUrl;
        txtid=findViewById(R.id.txtid);
        txttitle=findViewById(R.id.txttitle);
        txturl=findViewById(R.id.txturl);
        thumbnailUrl=findViewById(R.id.txtthumbnailUrl);

        RetrofitInstance.getApiInterface().getPhotos().enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                ArrayList<DataModel> data = new ArrayList<DataModel>();

                data.add(response.body());

                txtid.setText(data.get(0).id);
                txttitle.setText(data.get(0).title);
                txturl.setText(data.get(0).url);
                thumbnailUrl.setText(data.get(0).thumbnailUrl);

                Log.d("de", "size: "+ data.size());
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });
    }
}