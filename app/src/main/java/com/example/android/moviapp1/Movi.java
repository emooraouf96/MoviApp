package com.example.android.moviapp1;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movi implements Parcelable {
    @SerializedName("original_title")
    @Expose
    private String original_title;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("vote_average")
    @Expose
    private double vote_average;
    @SerializedName("poster_path")
    @Expose
    private String poster_path;
    @SerializedName("release_date")
    @Expose
    private String release_date;
    @SerializedName("overview")
    @Expose
    private String overview;

    protected Movi(Parcel in) {
        original_title = in.readString();
        id = in.readInt();
        vote_average = in.readDouble();
        poster_path = in.readString();
        release_date = in.readString();
        overview = in.readString();
    }

    public static final Creator<Movi> CREATOR = new Creator<Movi>() {
        @Override
        public Movi createFromParcel(Parcel in) {
            return new Movi(in);
        }

        @Override
        public Movi[] newArray(int size) {
            return new Movi[size];
        }
    };

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public String toString() {
        return "Movi{" +
                "original_title='" + original_title + '\'' +
                ", id=" + id +
                ", vote_average=" + vote_average +
                ", poster_path='" + poster_path + '\'' +
                ", release_date='" + release_date + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(original_title);
        dest.writeInt(id);
        dest.writeDouble(vote_average);
        dest.writeString(poster_path);
        dest.writeString(release_date);
        dest.writeString(overview);
    }
}
