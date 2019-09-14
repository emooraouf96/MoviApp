package com.example.android.moviapp1.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.moviapp1.DetailActiviy;
import com.example.android.moviapp1.GridAdapter;
import com.example.android.moviapp1.Movi;
import com.example.android.moviapp1.MoviList;
import com.example.android.moviapp1.MoviServer;
import com.example.android.moviapp1.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {

    private ArrayList<Movi> moviList;
    GridView gridView;
    private GridAdapter gridAdapter;
    public  static  int mPosition;

    private static final String TAG = "movi@@@@";
    private static final String BaseUrl = "http://api.themoviedb.org";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridView = (GridView) findViewById(R.id.gridview);

        Toast.makeText(this,"Main2 Activity ",Toast.LENGTH_LONG);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MoviServer moviServer = retrofit.create(MoviServer.class);
        Call<MoviList> popularMovi = moviServer.getPopularMovi("popular", MoviServer.apiKey);




        popularMovi.enqueue(new Callback<MoviList>() {
            @Override
            public void onResponse(Call<MoviList> call, Response<MoviList> response) {

                moviList = (ArrayList<Movi>) response.body().getMoviList();
                GridAdapter gridAdapter = new GridAdapter(getApplicationContext(), moviList);
                gridView.setAdapter(gridAdapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        mPosition=position;
                        Intent i = new Intent(getApplicationContext(), DetailActiviy.class);
                        i.putExtra("position",position);
                        Log.v(TAG,"possssss"+position);
                        i.putParcelableArrayListExtra("key", moviList);
                        startActivity(i);

                    }
                });


            }

            @Override
            public void onFailure(Call<MoviList> call, Throwable t) {
                Log.e(TAG, "fail", t);
                Log.v(TAG, "onFailure: No Internet Connection: " + t.getMessage());
                Toast.makeText(Main2Activity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.movi_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
                switch (id){
                     case R.id.Popular:
                             Toast.makeText(getApplicationContext(),"Popular" ,Toast.LENGTH_LONG).show();
                             Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(BaseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    MoviServer moviServer = retrofit.create(MoviServer.class);
                    Call<MoviList> popularMovi = moviServer.getPopularMovi("popular", MoviServer.apiKey);

                    popularMovi.enqueue(new Callback<MoviList>() {
                        @Override
                        public void onResponse(Call<MoviList> call, Response<MoviList> response) {

                            moviList = (ArrayList<Movi>) response.body().getMoviList();
                            GridAdapter gridAdapter = new GridAdapter(getApplicationContext(), moviList);
                            gridView.setAdapter(gridAdapter);
                            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    Intent i = new Intent(getApplicationContext(), DetailActiviy.class);
                                    i.putParcelableArrayListExtra("key", moviList);
                                    startActivity(i);
                                }
                            });


                        }

                        @Override
                        public void onFailure(Call<MoviList> call, Throwable t) {
                            Log.e(TAG, "fail", t);
                            Log.v(TAG, "onFailure: : No Internet Connection" + t.getMessage());
                            Toast.makeText(Main2Activity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();

                        }

                    });

                    case R.id.TopRated:
                                Toast.makeText(getApplicationContext(),"Top Rated",Toast.LENGTH_LONG).show();
                                 Retrofit retrofit2 = new Retrofit.Builder()
                                .baseUrl(BaseUrl)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        MoviServer moviServer2 = retrofit2.create(MoviServer.class);
                        Call<MoviList> popularMovi2 = moviServer2.getPopularMovi("top_rated", MoviServer.apiKey);

                        popularMovi2.enqueue(new Callback<MoviList>() {
                            @Override
                            public void onResponse(Call<MoviList> call, Response<MoviList> response) {

                                moviList = (ArrayList<Movi>) response.body().getMoviList();
                                GridAdapter gridAdapter = new GridAdapter(getApplicationContext(), moviList);
                                gridView.setAdapter(gridAdapter);
                                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        mPosition=position;

                                        Intent i = new Intent(getApplicationContext(), DetailActiviy.class);
                                        i.putParcelableArrayListExtra("key", moviList);
                                        startActivity(i);
                                    }
                                });


                            }

                            @Override
                            public void onFailure(Call<MoviList> call, Throwable t) {
                                Log.e(TAG, "fail", t);
                                Log.v(TAG, "onFailure: No Internet Connection: " + t.getMessage());
                                Toast.makeText(Main2Activity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();

                            }
                        });

                      default:

                          return true;

                }
    }


}
