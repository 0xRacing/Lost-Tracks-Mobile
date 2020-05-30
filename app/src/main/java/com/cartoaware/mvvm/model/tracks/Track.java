package com.cartoaware.mvvm.model.tracks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Track {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("desc")
    @Expose
    public String desc;
    @SerializedName("imgUrls")
    @Expose
    public List<String> imgUrls = new ArrayList<>();
    @SerializedName("urls")
    @Expose
    public List<String> urls = new ArrayList<String>();
    @SerializedName("lengthMeters")
    @Expose
    public Integer lengthMeters;
    @SerializedName("lat")
    @Expose
    public Double lat;
    @SerializedName("lng")
    @Expose
    public Double lng;
    @SerializedName("fullAddress")
    @Expose
    public String fullAddress;
    @SerializedName("yearOpen")
    @Expose
    public Integer yearOpen;
    @SerializedName("yearClosed")
    @Expose
    public Integer yearClosed;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("surface")
    @Expose
    public String surface;
}
