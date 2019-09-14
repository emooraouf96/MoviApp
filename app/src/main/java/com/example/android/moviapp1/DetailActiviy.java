package com.example.android.moviapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.moviapp1.model.Main2Activity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailActiviy extends AppCompatActivity {

     TextView originalTitle;
     ImageView posterPath;
     TextView overView;
     TextView voteAverage;
     TextView releaseDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activiy);


        originalTitle = findViewById(R.id.original_title);
        posterPath = findViewById(R.id.poster_path);
        overView = findViewById(R.id.overview);
        voteAverage = findViewById(R.id.vote_average);
        releaseDate = findViewById(R.id.release_date);
        String baseURL = GridAdapter.baseurl;

       Intent intent=getIntent();
       List<Movi> getlist =intent.getParcelableArrayListExtra("key");
       Movi movi=getlist.get(Main2Activity.mPosition);
                  String original_title;
                  String Poster_path;
                  double Vote_average;
                  String Overview;
                  String Release_Date;
                  int pos=Main2Activity.mPosition;
                  Log.v("DetailActiviy","sssssssssssss"+pos);

                  original_title = getlist.get(Main2Activity.mPosition).getOriginal_title();
                   Poster_path = getlist.get(Main2Activity.mPosition).getPoster_path();
                   Vote_average = getlist.get(Main2Activity.mPosition).getVote_average();
                   Overview = getlist.get(Main2Activity.mPosition).getOverview();
                   Release_Date = getlist.get(Main2Activity.mPosition).getRelease_date();


                  originalTitle.setText(original_title);
                  Picasso.get().load(baseURL+Poster_path).into(posterPath);
                  voteAverage.setText(""+ Vote_average);
                  overView.setText(Overview);
                  releaseDate.setText(Release_Date);
              }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (outState != null) {
            String originalTitle = outState.getString("message");
            String Poster_path = outState.getString("message");
            String Vote_average = outState.getString("message");
            String Overview = outState.getString("message");
            String ReleaseDate = outState.getString("message");

            outState.putString("original_Title", "This is a saved message");
            outState.putString("Poster_path", "This is a saved message");
            outState.putString("Vote_average", "This is a saved message");
            outState.putString("Overview", "This is a saved message");
            outState.putString("ReleaseDate", "This is a saved message");


        }

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
    }

}

