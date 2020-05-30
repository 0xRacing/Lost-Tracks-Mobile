package com.cartoaware.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cartoaware.mvvm.data.tracks.TracksRepository;
import com.cartoaware.mvvm.data.weather.WeatherRepository;
import com.cartoaware.mvvm.model.geo.GeoResponse;
import com.cartoaware.mvvm.model.tracks.Track;
import com.cartoaware.mvvm.model.weather.WeatherResponse;

import java.util.List;

public class TracksViewModel extends ViewModel {

    private MutableLiveData<List<Track>> lostTracksLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Track>> activeTracksLiveData = new MutableLiveData<>();
    private TracksRepository tracksRepository;

    public TracksViewModel(){
        this.tracksRepository = TracksRepository.getInstance();
    }

    public void fetchLostTracks(){
        lostTracksLiveData = tracksRepository.getLostTracks();
    }

    public LiveData<List<Track>> getLostTracks() {
        return lostTracksLiveData;
    }

    public LiveData<List<Track>> getActiveTracks() {
        return activeTracksLiveData;
    }

}

