package com.cartoaware.mvvm.data.tracks;

import com.cartoaware.mvvm.model.tracks.Track;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TracksApi {
    @GET("lost_tracks/tracks.json")
    Call<List<Track>> getLostTracks();

    @GET("active_tracks/tracks.json")
    Call<List<Track>> getActiveTracks();
}
