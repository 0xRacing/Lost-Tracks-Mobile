package com.cartoaware.mvvm.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cartoaware.mvvm.model.tracks.Track;
import com.cartoaware.mvvm.model.weather.Hourly;
import com.zeroxracing.losttracks.databinding.ViewHourItemBinding;
import com.zeroxracing.losttracks.databinding.ViewTrackItemBinding;

import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder> {

    private List<Track> hourlyItems;

    public TrackAdapter(List<Track> hourlyList) {
        this.hourlyItems = hourlyList;
    }

    @NonNull
    @Override
    public TrackAdapter.TrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewTrackItemBinding itemBinding = ViewTrackItemBinding.inflate(layoutInflater, parent, false);
        return new TrackAdapter.TrackViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackAdapter.TrackViewHolder holder, int position) {
        final Track restaurant = hourlyItems.get(position);
        holder.bindHourly(restaurant);
    }

    @Override
    public int getItemCount() {
        return hourlyItems != null ? hourlyItems.size() : 0;
    }

    class TrackViewHolder extends RecyclerView.ViewHolder {
        private ViewTrackItemBinding hourItemBinding;

        TrackViewHolder(ViewTrackItemBinding binding) {
            super(binding.getRoot());
            this.hourItemBinding = binding;
        }

        void bindHourly(Track hourly) {
            hourItemBinding.setTrack(hourly);
            hourItemBinding.executePendingBindings();
        }
    }
}
