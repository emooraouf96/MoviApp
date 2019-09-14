package com.example.android.moviapp1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviList {
    @SerializedName("results")
    @Expose
    private List<Movi> moviList;

    public List<Movi> getMoviList() {
        return moviList;
    }

    public void setMoviList(List<Movi> moviList) {
        this.moviList = moviList;
    }
}
