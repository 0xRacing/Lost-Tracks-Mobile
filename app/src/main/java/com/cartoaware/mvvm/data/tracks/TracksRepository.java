package com.cartoaware.mvvm.data.tracks;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import com.cartoaware.mvvm.model.tracks.Track;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TracksRepository {
    private static TracksRepository geoRepository = new TracksRepository();
    private TracksApi geoApi = TracksApiService.createApiService(TracksApi.class);

    public static TracksRepository getInstance() {
        return geoRepository;
    }

    public MutableLiveData<List<Track>> getLostTracks() {
        MutableLiveData<List<Track>> mutableLiveData = new MutableLiveData<>();
        Call<List<Track>> call = geoApi.getLostTracks();
        call.enqueue(new Callback<List<Track>>() {
            @Override
            public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }else{
                    try {
                        Log.e("WMVVM", response.errorBody().string());
                    }catch (Exception e){}
                }
            }

            @Override
            public void onFailure(Call<List<Track>> call, Throwable t) {
                mutableLiveData.setValue(null);
                Log.e("WMVVM", t.toString());
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<List<Track>> getActiveTracks() {
        MutableLiveData<List<Track>> mutableLiveData = new MutableLiveData<>();
        Call<List<Track>> call = geoApi.getActiveTracks();
        call.enqueue(new Callback<List<Track>>() {
            @Override
            public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }else{
                    try {
                        Log.e("WMVVM", response.errorBody().string());
                    }catch (Exception e){}
                }
            }

            @Override
            public void onFailure(Call<List<Track>> call, Throwable t) {
                mutableLiveData.setValue(null);
                Log.e("WMVVM", t.toString());
            }
        });
        return mutableLiveData;
    }
}
