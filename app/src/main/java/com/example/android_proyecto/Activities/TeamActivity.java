package com.example.android_proyecto.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_proyecto.Adapters.TeamAdapter;
import com.example.android_proyecto.Adapters.VideoAdapter;
import com.example.android_proyecto.Models.Team;
import com.example.android_proyecto.Models.TeamMember;
import com.example.android_proyecto.Models.Video;
import com.example.android_proyecto.R;
import com.example.android_proyecto.RetrofitClient;
import com.example.android_proyecto.Services.ApiService;
import com.example.android_proyecto.Services.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamActivity extends AppCompatActivity {

    private TextView tvTeam;
    private RecyclerView recyclerTeam;
    private SessionManager session;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        session = new SessionManager(this);
        tvTeam = findViewById(R.id.tvTeam);
        recyclerTeam = findViewById(R.id.recyclerTeam);
        recyclerTeam.setLayoutManager(new LinearLayoutManager(this));

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        loadVideos(session.getUsername());
    }

    private void loadVideos(String username) {
        ApiService api = RetrofitClient.getApiService();

        api.getTeam(username).enqueue(new Callback<Team>() {
            @Override
            public void onResponse(Call<Team> call, Response<Team> response) {
                if (response.isSuccessful() && response.body() != null) {
                    TeamAdapter adapter = new TeamAdapter(response.body().getMembers());
                    recyclerTeam.setAdapter(adapter);
                } else {
                    Toast.makeText(TeamActivity.this,
                            "Could not load VIDEOs", Toast.LENGTH_SHORT).show();
                }
                tvTeam.setText("Team: " + response.body().getTeam());
            }

            @Override
            public void onFailure(Call<Team> call, Throwable t) {
                Toast.makeText(TeamActivity.this,
                        "Connection error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
