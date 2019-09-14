package com.example.android.moviapp1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class GridAdapter extends BaseAdapter {

        private final Context mContext;
        private List<Movi> moviList;
        static String  baseurl = "http://image.tmdb.org/t/p/w185/";


    public GridAdapter(Context mContext, List<Movi> moviList) {
        this.mContext = mContext;
        this.moviList = moviList;

    }


      @Override
        public int getCount() {

        return moviList.size();
    }

        // 3
        @Override
        public long getItemId(int position) {
            return 0;
        }

        // 4
        @Override
        public Object getItem(int position) {
            return moviList.get(position);
        }

        // 5
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
        String posterPath = moviList.get(position).getPoster_path();
        ImageView imageView ;
        TextView votavg ;
          if (convertView == null) {
              imageView = new ImageView(mContext);
              final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
              convertView = layoutInflater.inflate(R.layout.list_item, null);
          }
                ImageView img = convertView.findViewById(R.id.poster_path);
          votavg = convertView.findViewById(R.id.vote_average);
         // votavg.setText(" "+moviList.get(position).getVote_average());
          Picasso.get().load(baseurl+posterPath).into(img);
         // convertView.findViewById(R.id.)



            return convertView;
        }


    }




