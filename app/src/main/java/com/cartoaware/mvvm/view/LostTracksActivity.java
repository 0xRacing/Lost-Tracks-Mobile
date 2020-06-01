package com.cartoaware.mvvm.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.cartoaware.mvvm.adapter.TrackAdapter;
import com.cartoaware.mvvm.data.location.LocationRepository;
import com.cartoaware.mvvm.model.tracks.Track;
import com.cartoaware.mvvm.viewmodel.TracksViewModel;
import com.zeroxracing.losttracks.R;
import com.zeroxracing.losttracks.databinding.LostTracksActivityBinding;

import java.util.ArrayList;

public class LostTracksActivity extends AppCompatActivity {

    private TracksViewModel tracksViewModel;
    private LostTracksActivityBinding binding;

    private ArrayList<Track> trackArrayList = new ArrayList<>();

    private TrackAdapter trackAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lost_tracks);
        getSupportActionBar().setTitle(getString(R.string.lost_tracks_title));

        tracksViewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(TracksViewModel.class);

        binding.tracksRecyclerview.setHasFixedSize(true);
        trackAdapter = new TrackAdapter(trackArrayList);
        binding.tracksRecyclerview.setAdapter(trackAdapter);

        setupLocationUpdates();

    }

    private void setupLocationUpdates() {
        binding.trackLoading.setVisibility(View.VISIBLE);
        tracksViewModel.fetchLostTracks();
        tracksViewModel.getLostTracks().observe(this, response -> {
            if (response != null) {
                trackArrayList.addAll(response);
                trackAdapter.notifyDataSetChanged();
                binding.trackLoading.setVisibility(View.GONE);
            }
        });
    }
}
