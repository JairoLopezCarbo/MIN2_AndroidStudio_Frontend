package com.example.android_proyecto.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_proyecto.Models.TeamMember;
import com.example.android_proyecto.R;
import com.example.android_proyecto.RetrofitClient;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<TeamMember> teamMembers;

    public TeamAdapter(List<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        TeamMember teamMember = teamMembers.get(position);
        holder.tvUsername.setText(teamMember.getName());
        Glide.with(holder.itemView.getContext())
                .load(teamMember.getAvatar())
                .into(holder.imgAvatar);
        holder.tvPoints.setText("Points: " + String.valueOf(teamMember.getPoints()));
    }

    @Override
    public int getItemCount() {
        return teamMembers != null ? teamMembers.size() : 0;
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {

        TextView tvUsername;

        ImageView imgAvatar;
        TextView tvPoints;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            tvPoints = itemView.findViewById(R.id.tvPoints);
        }
    }
}
